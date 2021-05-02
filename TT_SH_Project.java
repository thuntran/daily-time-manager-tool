import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TT_SH_Project {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Todo> toDoList = new ArrayList<>();
        // Stopwatch stopwatch = new Stopwatch();

        JFrame frame = new JFrame();
        frame.setTitle("To-Do List"); // title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit
        frame.setResizable(true); 
        frame.setSize(600,500); // frame size x,y
        frame.getContentPane().setBackground(Color.DARK_GRAY); // change background color
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel taskLabel = new JLabel("Enter task here");
        taskLabel.setBounds(10,20,150,25);
        panel.add(taskLabel);

        JTextField taskText = new JTextField(20);
        taskText.setBounds(120,20,250,25);
        panel.add(taskText);

        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBounds(400,20,100,25);
        panel.add(confirmButton);

        JLabel taskListLabel = new JLabel("Tasks:");
        taskListLabel.setBounds(10,40,150,45);
        panel.add(taskListLabel);

        // JLabel toDoLabel = new JLabel("To-do:");
        // toDoLabel.setBounds(10,40,150,45);
        // panel.add(toDoLabel);

        // JLabel completedLabel = new JLabel("Completed:");
        // completedLabel.setBounds(10,150,150,155);
        // panel.add(completedLabel);

        frame.setVisible(true); // make frame visible
        
        // ImageIcon image = new ImageIcon("stem.png");
        
        
        //label.setText("hello"); //set text
        //label.setIcon(image); // set pic icons
        // label.setHorizontalTextPosition(JLabel.CENTER); //set text Left, center, right of imageicon
        // label.setVerticalTextPosition(JLabel.TOP); //set text top, center, bottom of imageicon
        // label.setForeground(new Color(0,0,0)); //set font color of text
        // label.setFont(new Font("font", Font.PLAIN, 20)); //set font
        // label.setIconTextGap(-25); //set gap of text to image
        // //label.setBackground(Color.black);//set bg color
        // label.setOpaque(true);//display bg color
        // label.setVerticalAlignment(JLabel.CENTER);
        // label.setHorizontalAlignment(JLabel.CENTER);

        //ImageIcon icon = new ImageIcon("logo.png");//create an Imageicon
        //frame.setIconImage(icon.getImage()); //change icon of frame
        char op;
        do {
            System.out.print("\nMENU\n1. Enter a task\n2. View added tasks\n3. Total time\n0. Quit\nChoose an option (0 - 3): ");
            op = scan.next().charAt(0);
            switch (op) {
                case '1':
                    enterTask(toDoList);
                    break;
                case '2':
                    print(toDoList);
                    break;
                case '3':
                    totalTime(toDoList);
                    break;
                case '0':
                    System.out.println("Goodbye!");
                    break;
                default: System.out.println("Invalid input, please try again.");
            }
        } while (op != '0');
        // toDoList.add(new Todo("Doing CSC homework", 2, 30, 34));
        // System.out.println(toDoList);
        // Stopwatch stopwatch = new Stopwatch();
    } // main
    
    

    static void enterTask(ArrayList<Todo> toDoList) {
        System.out.print("Enter a task: ");
        scan.nextLine();
        String task = scan.nextLine();
        toDoList.add(new Todo(task, 0, 0, 0));
        // toDoList.add(new Todo("Doing CSC homework", 2, 30, 34)); // test
        // toDoList.add(new Todo("Doing MTH homework", 4, 43, 21)); // test
        // toDoList.add(new Todo("Doing FRN homework", 5, 23, 22)); // test
    } // enterTask

    static void print(ArrayList<Todo> toDoList) {
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println((i+1) + ". " + toDoList.get(i).printTask());
        }
    } // print

    static void totalTime(ArrayList<Todo> toDoList) {
        int total = 0; // in seconds
        for (int i = 0; i < toDoList.size(); i++) {
            total += toDoList.get(i).getHours() * 3600; 
            total += toDoList.get(i).getMinutes() * 60;
            total += toDoList.get(i).getSeconds();
        }
        int totalHours = total / 3600;
        int residue1 = total % 3600;
        int totalMinutes = residue1 / 60;
        int residue2 = residue1 % 60;
        int totalSeconds = residue2;
        System.out.println("Total time: " + totalHours + ":" + totalMinutes + ":" + totalSeconds);
        // System.out.println("Total time: " + total); // test
    } // totalTime
} // class


