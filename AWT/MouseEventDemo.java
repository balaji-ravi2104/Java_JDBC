package AWT;
import java.awt.*;
import java.awt.event.*;

import MyFrame;
class MyFrame extends Frame implements MouseListener,MouseMotionListener{

    Label l1,l2;

    public MyFrame(){

        super("Mouse Event Demo");

        l1 = new Label("");
        l2 = new Label("");

        setLayout(null);

        l1.setBounds(10,50,100,20);
        l2.setBounds(10,80,100,20);

        add(l1);
        add(l2);

        addMouseListener(this);
        addMouseMotionListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        l1.setText("Mouse Clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        l1.setText("Mouse Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e){
        l1.setText("Mouse Released");
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        l1.setText("Mouse Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        l1.setText("Mouse Exited");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        l1.setText("Mouse Dragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        l1.setText("Mouse Move");
        l2.setText("("+e.getX()+","+e.getY()+")");
    }

}
public class MouseEventDemo {
    public static void main(String[] args) {
        MyFrame f = new MyFrame();
        f.setSize(500, 500);
        f.setVisible(true);
    }
}
