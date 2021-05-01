import java.awt.*;
import javax.swing.*;


public class TodoLabel extends JLabel {

    TodoLabel(){
        ImageIcon image = new ImageIcon("");
        this.setText("hello"); //set text
        this.setIcon(image); // set pic icons
        this.setHorizontalTextPosition(JLabel.CENTER); //set text Left, center, right of imageicon
        this.setVerticalTextPosition(JLabel.TOP); //set text top, center, bottom of imageicon
        this.setForeground(new Color(0,0,0)); //set font color of text
        this.setFont(new Font("font", Font.PLAIN, 20)); //set font
        this.setIconTextGap(-25); //set gap of text to image
        this.setBackground(Color.black);//set bg color
        this.setOpaque(true);//display bg color
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);
    }
}
