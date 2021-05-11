// packages to create graphics
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

class Stopwatch extends TT_SH_DailyTimeManager implements ActionListener {
    
    // fields involved in the stopwatch
    JFrame frame = new JFrame(); 
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    JButton doneButton = new JButton("DONE");
    JLabel timeLabel = new JLabel();
    int elapsedTime = 0; 
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    Timer timer = new Timer(1000, new ActionListener() { // create a Timer object  
        public void actionPerformed(ActionEvent e) {
            // time in the background
            elapsedTime = elapsedTime + 1000;
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            // show formatted time 
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        }
    });
    
    Stopwatch() { // stopwatch graphics
        // timeLabel
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        timeLabel.setBounds(50, 100, 300, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setForeground(new Color(105,105,105));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        timeLabel.setBackground(new Color(230,230,250));

        // start button
        startButton.setBounds(50, 200, 100, 50);
        startButton.setFont(new Font("Consolas", Font.PLAIN, 15));
        startButton.setBackground(new Color(176,196,222));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        // reset button
        resetButton.setBounds(150, 200, 100, 50);
        resetButton.setFont(new Font("Consolas", Font.PLAIN, 15));
        resetButton.setBackground(new Color(176,196,222));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        // done button
        doneButton.setBounds(250, 200, 100, 50);
        doneButton.setFont(new Font("Consolas", Font.PLAIN, 15));
        doneButton.setBackground(new Color(176,196,222));
        doneButton.setFocusable(false);
        doneButton.addActionListener(this); 

        // frame
        frame.add(startButton);  
        frame.add(resetButton);
        frame.add(doneButton);
        frame.add(timeLabel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(230,230,250));
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) { // override the default actionPerformed method in ActionListener
        if (e.getSource() == startButton) { // if user clicks "start"
            if (started == false) {
                started = true;
                startButton.setText("PAUSE");
                start();
            } else {
                started = false;
                startButton.setText("RESUME");
                stop();
            }
        }

        if (e.getSource() == resetButton) { // if user clicks "reset"
            started = false;
            startButton.setText("START");
            reset();
        }

        if (e.getSource() == doneButton) { // if user clicks "done"
            started = false;
            startButton.setText("START");
            stop();
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
        } 
    } 

    public void start() { // start the timer
        timer.start();
    } 

    public void stop() { // stop the timer
        timer.stop();
    }

    public void reset() { // reset the timer
        timer.stop();
        elapsedTime = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;

        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
    }
}