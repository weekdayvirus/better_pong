package entities;

import main.Board;
import utils.KeyHandler;
import java.awt.*;

public class Paddle {
    public final int PADDLEWIDTH = 20, PADDLEHEIGHT = 100, SPEED = 3;
    public int x, y = (Board.HEIGHT - PADDLEHEIGHT) / 2;
    private boolean keyHolder;
    private KeyHandler keyH;
    private Ball ball;

    public Paddle(Ball ball) {
        keyHolder = false;
        this.ball = ball;
        x = Board.WIDTH - 120;
    }

    public Paddle(KeyHandler keyH) {
        keyHolder = true;
        this.keyH = keyH;
        x = 100;
    }

    public void update() {
        if(keyHolder) {
            if(keyH.up == true || keyH.down == true) {
                if(keyH.up == true && !(y < 0)) {
                    y -= SPEED;
                } else if(keyH.down == true && !(y + PADDLEHEIGHT > Board.HEIGHT)) {
                    y += SPEED;
                }
            }
        } else {
            if(ball.x < x) {
                if(ball.y > y) {
                    y += SPEED;
                } else if(ball.y < y) {
                    y -= SPEED;
                }
            } else if(ball.x > x + PADDLEWIDTH && y < Board.HEIGHT) {
                y += SPEED;
            }
        }
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillRect(x, y, PADDLEWIDTH, PADDLEHEIGHT);
    }
}
