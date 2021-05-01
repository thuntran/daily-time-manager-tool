import java.awt.*;
import javax.swing.*;


public class TodoFrame extends JFrame {

    TodoFrame(){

        this.setTitle("To Do List"); //title of this
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit
        this.setResizable(true); 
        this.setSize(420,420);//frame size x,y
        this.setVisible(true);//make frame visible

        ImageIcon icon = new ImageIcon("logo.png");//create an Imageicon
        this.setIconImage(icon.getImage()); //change icon of frame
        this.getContentPane().setBackground(new Color(255,255,255));//change backgroud color
    }
}
