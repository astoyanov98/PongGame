import java.awt.*;

public class Ball {
    private double xVel, yVel, x, y;

    public Ball(){
        this.x = 350;
        this.y = 250;
        this.xVel = -5;
        this.yVel = 3;
    }

    public void move(){
        x += xVel;
        y += yVel;

        if (y < 10){
            this.yVel = - yVel;
        }
        if (y > 490){
            this.yVel = - yVel;
        }
    }

    public void checkPaddleCollision(Paddle p1, Paddle p2){
        if (x <= 50){
            if (y >= p1.getY() && y <= p1.getY() + 80){
                xVel = - xVel;
            }
        }else if (x >= 650){
            if (y >= p2.getY() && y <= p2.getY() + 80){
                xVel = -xVel;
            }
        }
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval((int)x - 10, (int)y - 10, 20, 20);
    }

    public int getX(){
        return (int)this.x;
    }

    public int getY(){
        return (int)this.y;
    }
}
