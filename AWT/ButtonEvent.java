package AWT;
import java.awt.*;
import java.awt.event.*;

import MyFrame;
class MyFrame extends Frame implements ActionListener{
    int count=0;
    Label l;
    Button b;

    public MyFrame(){
        super("Button demo");

        l = new Label("    "+count);
        b = new Button("Click");
        b.addActionListener(this);

        setLayout(new FlowLayout());
        add(l);
        add(b);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        l.setText("    "+count);
    }
}
public class ButtonEvent {
    public static void main(String[] args) {
        MyFrame f = new MyFrame();
        f.setSize(500, 500);
        f.setVisible(true);
    }
}
