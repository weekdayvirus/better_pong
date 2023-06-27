package entities;

import java.awt.*;
import main.Board;
import utils.Sound;

public class Ball {
    public final int BALLDIMENSION = 20;
    public int xSpeed = 4, ySpeed = 4, x, y;   
    private Sound sound = new Sound();

    public Ball() {
        x = (Board.WIDTH - BALLDIMENSION) / 2;
        y = (Board.HEIGHT - BALLDIMENSION) / 2;
    }

    private void checkBounds() {
        if(y <= 0 || y + BALLDIMENSION >= Board.HEIGHT) {
            ySpeed *= -1;
            sound.play("/res/wall.wav");
        }
        if(x + BALLDIMENSION >= Board.WIDTH) {
            xSpeed *= -1;
            sound.play("/res/pScore.wav");
        } else if(x <= 0) {
            xSpeed *= -1;
            sound.play("/res/oScore.wav");
        }
    }

    public void update() {
        checkBounds();
        x += xSpeed;
        y += ySpeed;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.fillOval(x, y, BALLDIMENSION, BALLDIMENSION);
    }
}
