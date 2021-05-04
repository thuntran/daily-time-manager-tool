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
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); //needed layout - try to make it look nice

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

        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        checkBox3 = new JCheckBox();
        checkBox4 = new JCheckBox();
        checkBox5 = new JCheckBox();

        frame.setVisible(true); // make frame visible
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String t = taskText.getText(); // get text from the text box
        if (checkBox1.getText().isEmpty()) {
            checkBox1.setText(t);
            checkBox1.setBounds(5,68,20,73);
            checkBox1.setFont(new Font("Consolas", Font.PLAIN,15));
            panel.add(checkBox1);
            frame.setSize(500, 200);
        }
        else if (checkBox2.getText().isEmpty()) {
            checkBox2.setText(t);
            checkBox2.setBounds(5,88,20,93);
            checkBox2.setFont(new Font("Consolas", Font.PLAIN,15));
            panel.add(checkBox2);
            frame.setSize(500, 300);
        }
        else if (checkBox3.getText().isEmpty()) {
            checkBox3.setText(t);
            checkBox3.setBounds(5,108,20,113);
            checkBox3.setFont(new Font("Consolas", Font.PLAIN,15));
            panel.add(checkBox3);
            frame.setSize(500, 400);
        }
        else if (checkBox4.getText().isEmpty()) {
            checkBox4.setText(t);
            checkBox4.setBounds(5,128,20,133);
            checkBox4.setFont(new Font("Consolas", Font.PLAIN,15));
            panel.add(checkBox4);
            frame.setSize(500, 500);
        }
        else if (checkBox5.getText().isEmpty()) {
            checkBox5.setText(t);
            checkBox5.setBounds(5,148,20,153);
            checkBox5.setFont(new Font("Consolas", Font.PLAIN,15));
            panel.add(checkBox5);
            frame.setSize(500, 600);
        }
    }

}