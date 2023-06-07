package AWT;
import java.awt.*;
import java.awt.event.*;

import MyFrame;
class MyFrame extends Frame implements TextListener,ActionListener{
    
    Label l1,l2;
    TextField tf;

    public MyFrame(){
        super("TextField Demo");

        l1 = new Label("No Text Entered yet..");
        l2 = new Label("Enter Key is not yet hit");
        tf = new TextField(20); 
        // This EchoChar For PassWord Using Purpose
        // tf.setEchoChar('*');

        tf.addTextListener(this);
        tf.addActionListener(this);

        setLayout(new FlowLayout());
        add(l1);
        add(tf);
        add(l2);
    }

    @Override
    public void textValueChanged(TextEvent e) {
        l1.setText(tf.getText());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        l2.setText(tf.getText());
    }
} 
public class TextFieldDemo {
    public static void main(String[] args) {
        MyFrame f = new MyFrame();
        f.setSize(300, 300);
        f.setVisible(true);    
    }
}
