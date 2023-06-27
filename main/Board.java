package main;

import java.awt.*;
import javax.swing.JPanel;

import entities.*;
import utils.KeyHandler;

public class Board extends JPanel implements Runnable {
    public static final int WIDTH = 600, HEIGHT = 400;
    private KeyHandler keyH = new KeyHandler();
    private Ball ball = new Ball();
    private Paddle player = new Paddle(keyH);
    private Paddle robot = new Paddle(ball);
    private Score score = new Score(ball);
    private Thread gt;

    public Board() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setDoubleBuffered(true);
        addKeyListener(keyH);
		setFocusable(true);
    }

    public void init() {
        gt = new Thread(this);
        gt.start();
    }

    @Override
    public void run() {
		double drawInterval = 1000000000 / 60.0;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		while(gt != null) {		
			update();
			repaint();
            
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime /= 1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}    
    }
    
    public boolean checkCollision(Paddle paddle, Ball ball) {
        if(paddle.x < ball.x + ball.BALLDIMENSION && paddle.x + paddle.PADDLEWIDTH > ball.x && 
            paddle.y < ball.y + ball.BALLDIMENSION && paddle.y + paddle.PADDLEHEIGHT > ball.y) {
            return true;
        }

        return false;
    }

    private void update() {
        boolean check = checkCollision(player, ball);
        if(!check) { check = checkCollision(robot, ball); };
        if(check) {
            ball.xSpeed *= -1;
        } 

        ball.update();
        score.update();
        player.update();
        robot.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D)g;

        score.draw(g2d);
        player.draw(g2d);
        robot.draw(g2d);
        ball.draw(g2d);
        
        g2d.dispose();
    }
}
