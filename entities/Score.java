package entities;

import java.awt.*;
import main.Board;

public class Score {
    private int left = 0, right = 0;
    private String score;
    private Font font;
    private Ball ball;

    public Score(Ball ball) {
        this.ball = ball;
        font = new Font("Helvetica", Font.BOLD, 20);
        score = left + " | " + right;
    }

    public void update() {
        if(ball.x + ball.BALLDIMENSION >= Board.WIDTH) {
            left++;
        } else if(ball.x <= 0) {
            right++;
        }
        score = left + " | " + right;
    }

    public void draw(Graphics2D g2d) {
        g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        FontMetrics fm = g2d.getFontMetrics();
        g2d.drawString(score, (Board.WIDTH - fm.stringWidth(score)) / 2, fm.getHeight());
    }
}
