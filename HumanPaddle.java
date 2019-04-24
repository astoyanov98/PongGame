import java.awt.*;

public class HumanPaddle implements Paddle{
    private static final double GRAVITY = 0.94;
    private double y, yVel;
    private boolean upAccel, downAccel;
    private int player, x;

    public HumanPaddle(int player) {
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

    public void setUpAccel(boolean input){
        this.upAccel = input;
    }

    public void setDownAccel(boolean input){
        this.downAccel = input;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, (int)y, 20, 80);
    }

    @Override
    public void move() {
        if (upAccel){
            this.yVel -= 4;
        }else if(downAccel){
            this.yVel += 4;
        } else if(!upAccel && !downAccel){
            this.yVel *= GRAVITY;
        }

        if (this.yVel >= 5){
            this.yVel = 5;
        } else if (this.yVel <= -5) {
           this.yVel = -5;
       }

        this.y += this.yVel;

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
