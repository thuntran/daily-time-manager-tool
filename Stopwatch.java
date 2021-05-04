import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

import java.util.*;
import java.io.*; //eventually needed for file

class Stopwatch extends TT_SH_Project implements ActionListener {
    
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

    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            elapsedTime = elapsedTime + 1000;
            hours = (elapsedTime / 3600000);
            minutes = (elapsedTime / 60000) % 60;
            seconds = (elapsedTime / 1000) % 60;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        }
    });
    


    Stopwatch() {
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        timeLabel.setBounds(50, 100, 300, 100);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);

        startButton.setBounds(50, 200, 100, 50);
        startButton.setFont(new Font("Ink Free", Font.PLAIN, 15));
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        resetButton.setBounds(150, 200, 100, 50);
        resetButton.setFont(new Font("Ink Free", Font.PLAIN, 15));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        doneButton.setBounds(250, 200, 100, 50);
        doneButton.setFont(new Font("Ink Free", Font.PLAIN, 15));
        doneButton.setFocusable(false);
        doneButton.addActionListener(this);

        frame.add(startButton);  
        frame.add(resetButton);
        frame.add(doneButton);
        frame.add(timeLabel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
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

        if (e.getSource() == resetButton) {
            started = false;
            startButton.setText("START");
            reset();
        }

        if (e.getSource() == doneButton) {
            started = false;
            startButton.setText("START");
            stop();
            //int recordtime = seconds + minutes * 60 + hours * 3600;
            seconds_string = String.format("%02d", seconds);
            minutes_string = String.format("%02d", minutes);
            hours_string = String.format("%02d", hours);
            //System.out.println("Time taken: " + hours_string + ":" + minutes_string + ":" + seconds_string);
        }
        
        
    } 

    public void start() {
        timer.start();
    } 

    public void stop() {
        timer.stop();
    }

    public void reset() {
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

//Stopwatch - https://www.youtube.com/watch?v=0cATENiMsBE