import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GUI implements ActionListener {
    static JFrame frame;
    static JPanel panel;
    static JLabel taskLabel;
    static JTextField taskText;
    static JButton confirmButton;
    static JLabel task1Label;
    static JLabel task2Label;
    static JLabel task3Label;
    static JLabel task4Label;
    static JLabel task5Label;
    static JCheckBox checkBox1;
    static JCheckBox checkBox2;
    static JCheckBox checkBox3;
    static JCheckBox checkBox4;
    static JCheckBox checkBox5;

    GUI() {
        frame = new JFrame();
        frame.setTitle("To-Do List"); // title of frame
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // exit
        frame.setResizable(true); 
        frame.setSize(500,150); // frame size x,y
        frame.getContentPane().setBackground(Color.DARK_GRAY); // change background color
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        taskLabel = new JLabel("Enter task here");
        taskLabel.setBounds(10,20,150,25);
        panel.add(taskLabel);

        taskText = new JTextField(20);
        taskText.setBounds(120,20,250,25);
        panel.add(taskText);

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(400,20,100,25);
        confirmButton.addActionListener(this);
        panel.add(confirmButton);

        taskLabel = new JLabel("Tasks (maximum 5):");
        taskLabel.setBounds(10,40,150,45);
        panel.add(taskLabel);

        task1Label = new JLabel("");
        task1Label.setBounds(30,70,150,75);
        task1Label.setFont(new Font("Consolas", Font.PLAIN,15));
        panel.add(task1Label);

        task2Label = new JLabel("");
        task2Label.setBounds(30,90,150,95);
        task2Label.setFont(new Font("Consolas", Font.PLAIN,15));
        panel.add(task2Label);

        task3Label = new JLabel("");
        task3Label.setBounds(30,110,150,115);
        task3Label.setFont(new Font("Consolas", Font.PLAIN,15));
        panel.add(task3Label);

        task4Label = new JLabel("");
        task4Label.setBounds(30,130,150,135);
        task4Label.setFont(new Font("Consolas", Font.PLAIN,15));
        panel.add(task4Label);

        task5Label = new JLabel("");
        task5Label.setBounds(30,150,150,155);
        task5Label.setFont(new Font("Consolas", Font.PLAIN,15));
        panel.add(task5Label);

        frame.setVisible(true); // make frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String t = taskText.getText(); // get text from the text box
        if (task1Label.getText().isEmpty()) {
            checkBox1 = new JCheckBox(t);
            checkBox1.setBounds(5,68,20,73);
            checkBox1.setFont(new Font("Consolas", Font.PLAIN,15));
            panel.add(checkBox1);
            frame.setSize(500, 200);
            // task1Label.setText(t);
        }
        else if (task2Label.getText().isEmpty()) {
            checkBox2 = new JCheckBox(t);
            checkBox2.setBounds(5,88,20,93);
            checkBox2.setFont(new Font("Consolas", Font.PLAIN,15));
            panel.add(checkBox2);
            frame.setSize(500, 500);
            // task2Label.setText(t);
        }
        else if (task3Label.getText().isEmpty()) {
            checkBox3 = new JCheckBox(t);
            checkBox3.setBounds(5,108,20,113);
            checkBox3.setFont(new Font("Consolas", Font.PLAIN,15));
            panel.add(checkBox3);
            frame.setSize(500, 800);
            // task3Label.setText(t);
        }
        else if (task4Label.getText().isEmpty()) {
            checkBox4 = new JCheckBox(t);
            checkBox4.setBounds(5,128,20,133);
            checkBox4.setFont(new Font("Consolas", Font.PLAIN,15));
            panel.add(checkBox4);
            frame.setSize(500, 1100);
            // task4Label.setText(t);
        }
        else if (task5Label.getText().isEmpty()) {
            checkBox5 = new JCheckBox(t);
            checkBox5.setBounds(5,148,20,153);
            checkBox5.setFont(new Font("Consolas", Font.PLAIN,15));
            panel.add(checkBox5);
            frame.setSize(500, 1400);
            // task5Label.setText(t);
        }
    }

}
