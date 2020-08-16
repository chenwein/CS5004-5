import javax.swing.*;
import java.awt.*;

public class Pong {
    public static void main(String[] args) {
        JFrame window = new JFrame("lab11 pingpong");

        MyPanel panel = new MyPanel();
        panel.setPreferredSize(new Dimension(500, 500));

        window.add(panel);
        window.pack();

        window.setVisible(true);
    }
}
