package Swing;


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.tree.*;
import java.io.*;
import java.util.StringTokenizer;

class Tree extends JFrame implements TreeSelectionListener
{
    JTree tree;
    JLabel label;
    
    Tree()
    {
        super("Tree Demo");
        //valid path must be given
        DefaultMutableTreeNode root=new DefaultMutableTreeNode("C:\\JavaProgramms");
        File f=new File("C:\\JavaProgramms");
        
        for(File x: f.listFiles())
        {
            if(x.isDirectory())
            {
                DefaultMutableTreeNode temp=new DefaultMutableTreeNode(x.getName());
                for(File y:x.listFiles())
                {
                    temp.add(new DefaultMutableTreeNode(x.getName()));
                }
                root.add(temp);
            }
            else
                root.add(new DefaultMutableTreeNode(x.getName()));
        }
        
        tree=new JTree(root);
        label=new JLabel("No Files Selected");
        
        tree.addTreeSelectionListener(this);
        JScrollPane sp=new JScrollPane(tree);
        
        add(sp,BorderLayout.CENTER);
        add(label,BorderLayout.SOUTH);
        
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        label.setText(e.getPath().toString());
    }
    
    
    
}
public class SwingTree 
{
    public static void main(String[] args) 
    {
        Tree t = new Tree();
        t.setSize(400,400);
        t.setVisible(true);
        t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }    
}