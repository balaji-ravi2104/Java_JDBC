package AWT;
import java.awt.*;
class MyFrame extends Frame{
    Button b1,b2,b3,b4,b5,b6;
    public MyFrame(){
        super("FlowLayout");
        b1 = new Button("one");
        b2 = new Button("two");
        b3 = new Button("three");
        b4 = new Button("four");
        b5 = new Button("five");
        b6 = new Button("six");

        // Example for Flowlayout

        // FlowLayout fl = new FlowLayout();
        // fl.setAlignment(FlowLayout.RIGHT);
        // fl.setHgap(100);
        // setLayout(fl);
        // add(b1);
        // add(b2);
        // add(b3);
        // add(b4);
        // add(b5);
        // add(b6);

        // Example for Borderlayout

        add(b1,BorderLayout.NORTH);
        // add(b2,BorderLayout.EAST);
        add(b3,BorderLayout.SOUTH);
        add(b4,BorderLayout.WEST);
        add(b5,BorderLayout.CENTER);

        Panel p = new Panel();
        p.setLayout(new GridLayout(3,1));
        p.add(new Button("One"));
        p.add(new Button("Two"));
        p.add(new Button("Three"));
        add(p,BorderLayout.EAST);
    }
}
public class Layoutmanager {
    public static void main(String[] args) {
        MyFrame f = new MyFrame();
        f.setSize(500,500);
        f.setVisible(true);
    }
}
