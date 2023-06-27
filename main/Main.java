package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String args[]) {
        JFrame window = new JFrame();
		Board board = new Board();
		
		window.add(board);
		
		window.setResizable(false);
		window.pack();
		
		window.setTitle("2D Pong");
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

        board.init();
    }
}
