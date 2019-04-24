import com.sun.media.sound.AiffFileReader;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends Applet implements Runnable, KeyListener {
    private static final int WIDTH = 800, HEIGHT = 500;
    Thread thread;
    HumanPaddle p1;
    HumanPaddle p2;
    AIPaddle AI1;
    Ball b1;
    private boolean gameStarted;

    public void init(){
        this.resize(WIDTH, HEIGHT);
        this.gameStarted = false;
        thread = new Thread(this);
        p1 = new HumanPaddle(1);
        b1 = new Ball();
        AI1 = new AIPaddle(2, b1);
        this.addKeyListener(this);
        thread.start();
    }

    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        if (b1.getX() < -10 || b1.getX() > 710) {
            g.setColor(Color.red);
            g.drawString("Game Over!", 350, 250);
        } else {
            p1.draw(g);
            b1.draw(g);
            AI1.draw(g);
        }
    }

    public void update(Graphics g){
        paint(g);
    }

    @Override
    public void run() {
        for (;;) {
            if (this.gameStarted) {
                p1.move();
                b1.move();
                AI1.move();
                b1.checkPaddleCollision(p1, AI1);
                repaint();
            }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            p1.setUpAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            p1.setDownAccel(true);
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER){
            this.gameStarted = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP){
            p1.setUpAccel(false);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            p1.setDownAccel(false);
        }
    }
}
