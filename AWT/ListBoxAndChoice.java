package AWT;
import java.awt.*;
import java.awt.event.*;

import MyFrame;
class MyFrame extends Frame implements ItemListener,ActionListener{
    List l;
    Choice c;
    TextArea ta;
    
    public MyFrame(){
        super("ListBox And Choice Demo");
        l = new List(4,true);
        c = new Choice();
        ta = new TextArea(20, 30);

        l.add("Monday");
        l.add("Tuesday");
        l.add("Wednesday");
        l.add("Thursday");
        l.add("Friday");
        l.add("Saturday");
        l.add("sunday");

        c.add("Junauary");
        c.add("Februray");
        c.add("March");
        c.add("April");

        setLayout(new FlowLayout());
        add(l);
        add(c);
        add(ta);

        l.addItemListener(this);
        c.addItemListener(this);
        l.addActionListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==l)
            ta.setText(l.getSelectedItem());
        else
            ta.setText(c.getSelectedItem());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] list = l.getSelectedItems();
        String str="";

        for(String x:list){
            str+=x+"\n";
        }
        ta.setText(str);
    }
}
public class ListBoxAndChoice {
    public static void main(String[] args) {
        MyFrame f = new MyFrame();
        f.setSize(500, 500);
        f.setVisible(true);
    }
}
