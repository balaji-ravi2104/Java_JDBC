package AWT;
import java.awt.*;


class MyFrame extends Frame{
    Label l;
    Button b;
    TextField tf;

    public MyFrame(){
        super("Second App");

        setLayout(new FlowLayout());
        l = new Label("Name");
        b = new Button("Ok");
        tf = new TextField(20);

        add(l);
        add(tf);
        add(b);
    }
}
public class MySecondApp {
    public static void main(String[] args) {
        MyFrame f = new MyFrame();
        f.setSize(400, 400);
        f.setVisible(true);
    }
}
