package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;

 
class Combo extends JFrame implements ActionListener 
{
                          
    JLabel l;
    
    public Combo() 
    {
 
        String[] cities = { "New York", "Delhi", "Paris", "Berlin" };
        
        
        JComboBox cb = new JComboBox(cities);
        cb.setSelectedIndex(0);
        cb.setEditable(true);
        cb.addActionListener(this);
 
        l = new JLabel();
        
       setLayout(new FlowLayout());
        add(cb);
        add(l);
       
    }
 
    
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String name = (String)cb.getSelectedItem();

        
        String s=(String)cb.getSelectedItem();
        for(int i=0;i<cb.getItemCount();i++)
        {
            if(s.equals(cb.getItemAt(i)))
                return;
        }
        cb.addItem(s);
    }
 
}

public class SwingCombo 
{
    public static void main(String[] args) 
    {
        Combo f=new Combo();
        f.setSize(500,500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   
}