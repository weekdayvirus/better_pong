package utils;

import java.awt.event.KeyEvent;
import java.awt.event.*;

public class KeyHandler implements KeyListener {

	public boolean up;
	public boolean down;
		
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		
		if(k == KeyEvent.VK_UP) {
			up = true;
		}
		if(k == KeyEvent.VK_DOWN) {
			down = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();
		
		if(k == KeyEvent.VK_UP) {
			up = false;
		}
		if(k == KeyEvent.VK_DOWN) {
			down = false;
		}
	}
}
