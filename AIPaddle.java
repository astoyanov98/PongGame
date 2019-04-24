import java.awt.*;

public class AIPaddle implements Paddle{
    private static final double GRAVITY = 0.94;
    private double y, yVel;
    private boolean upAccel, downAccel;
    private int player, x;
    Ball b1;

    public AIPaddle(int player, Ball b1) {
        this.b1 = b1;
        this.upAccel = false;
        this.downAccel = false;
        this.y = 210;
        this.yVel = 0;

        if (player == 1) {
            x = 20;
        } else {
            x = 660;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, (int)y, 20, 80);
    }

    @Override
    public void move() {
        this.y = b1.getY() - 40;

        if (this.y < 0){
            this.y = 0;
        } else if (this.y > 420){
            this.y = 420;
        }
    }

    @Override
    public int getY() {
        return (int)this.y;
    }
}
