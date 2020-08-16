import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import static java.awt.event.KeyEvent.*;

public class MyPanel extends JPanel implements ActionListener, KeyListener {

    public enum Direction{
        UP, DOWN
    }


    class Coordinate {
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Coordinate other = (Coordinate) obj;
            if (this.x == other.x && this.y == other.y) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return "x = " + Integer.toString(x) + ", y = " + Integer.toString(y);
        }

        int x;
        int y;
    }

    private final int width = 500;
    private final int height = 500;
    private final int stepSize = 10;

    private BufferedImage apple_image;
    private BufferedImage paddle_image;
    private Timer timer;
    private Coordinate apple_loc;
    private Direction direction;
    private Direction direction2;
    private LinkedList<Coordinate> paddle = new LinkedList<>();
    private LinkedList<Coordinate> paddle2 = new LinkedList<>();

    // constructor
    public MyPanel() {


        // init the location of the apple
        apple_loc = new Coordinate(250, 250);


        // init the location of 2 paddles
        paddle.add(new Coordinate(100,150));
        paddle2.add(new Coordinate(400,300));




        // load images
        try {
            apple_image = ImageIO.read(new File("src/apple.png"));
            paddle_image = ImageIO.read(new File("src/paddle.jpeg"));
            System.out.println("read images");
        } catch (IOException e) {
            System.out.println("IO error -- file not found");
        }

        // set up the timer
        timer = new Timer(100, this);
        timer.start();

        this.setPreferredSize(new Dimension(500, 500));

        // !!! have to be focusable in order to receive keyboard events
        this.setFocusable(true);
        // register outselve as the keyboard listner
        addKeyListener(this);
    }

    // helper methods
    void relocateApple() {
        int newAppleX = ((int)(Math.random() * width) / stepSize) * stepSize; // 0 - 500
        int newAppleY = ((int)(Math.random() * height) / stepSize) * stepSize;

        apple_loc = new Coordinate(newAppleX, newAppleY);
    }

    // methods for actionListner
    @Override
    public void actionPerformed(ActionEvent e) {
        // when the timer that we're listening to fires,
        // this method will get invoked

        Coordinate paddleBoard = paddle.getFirst();
        int paddle_x = paddleBoard.x;
        int paddle_y = paddleBoard.y;

        if (direction == Direction.UP) {
            paddle_y -= stepSize;
        } else if (direction == Direction.DOWN) {
            paddle_y += stepSize;
        }

        Coordinate paddleBoard2 = paddle2.getFirst();
        int paddle2_x = paddleBoard2.x;
        int paddle2_y = paddleBoard2.y;

        if (direction2 == Direction.UP) {
            paddle2_y -= stepSize;
        } else if (direction2 == Direction.DOWN) {
            paddle2_y += stepSize;
        }



        Coordinate newHead = new Coordinate(paddle_x, paddle_y);
        Coordinate newHead2 = new Coordinate(paddle2_x, paddle2_y);


        paddle.addFirst(newHead);
        paddle2.addFirst(newHead2);

        // repaint the apple (actually everything)
        repaint();
    }

    // methods for JPanel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


            g.drawImage(apple_image, apple_loc.x, apple_loc.y, this);

            //draw 2 paddles
            Coordinate paddleB = paddle.getFirst();
            g.drawImage(paddle_image, paddleB.x, paddleB.y, this);
            Coordinate paddleB2 = paddle2.getFirst();
            g.drawImage(paddle_image, paddleB2.x, paddleB2.y, this);



    }

    // methods for keylistenr

    @Override
    public void keyTyped(KeyEvent e) {
        return;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // invoked when keyboard is pressed simultaenously
        int code = e.getKeyCode();

        if (code == VK_UP ) {
            direction = Direction.UP;
        }
        if (code == VK_DOWN) {
            direction = Direction.DOWN;
        }
        if (code == VK_W) {
            direction2 = Direction.UP;
        }
        if (code == VK_S) {
            direction2 = Direction.DOWN;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        return;
    }
}
