package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame implements ActionListener{
    JLabel l;
    JButton b;
    int count=0;

    public MyFrame(){
        super("Swing Demo");
        setLayout(new FlowLayout());

        l = new JLabel("Clicked "+count+"Times");
        b = new JButton("Click");

        add(l);
        add(b);
        add(new JButton("Cancel"));

        b.addActionListener(this);

        // For setting default Button
        getRootPane().setDefaultButton(b);

        // For setting button as image
        // b.setIcon(new ImageIcon(null));

        // for setting toolitip text
        l.setToolTipText("Counter");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        l.setText("Clicked "+count+"Times");
    }
}
public class SwingComponents{
    public static void main(String[] args) {
        MyFrame f = new MyFrame();
        f.setSize(400, 400);
        f.setVisible(true);
        
        // This is for stopping the application
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}