package rtype.game;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {

	private int speed;
	private int pos_x, pos_y;
	private int dir_x, dir_y;
	private int width, height;
	private Image image;

	public Player() {
		speed = 6;
		this.pos_x = 100;
		this.pos_y = 100;
	}

	public void load() {
		ImageIcon reference = new ImageIcon("res\\assets\\player\\ship_normal_00.png");
		image = reference.getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);
	}

	public void update() {
		pos_x += dir_x;
		pos_y += dir_y;
	}

	public void keyPressed(KeyEvent key) {
		int code = key.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			dir_y = -speed;
		}
		if (code == KeyEvent.VK_DOWN) {
			dir_y = speed;
		}
		if (code == KeyEvent.VK_LEFT) {
			dir_x = -speed;
		}
		if (code == KeyEvent.VK_RIGHT) {
			dir_x = speed;
		}
	}

	public void keyReleased(KeyEvent key) {
		int code = key.getKeyCode();
		if (code == KeyEvent.VK_UP) {
			dir_y = 0;
		}
		if (code == KeyEvent.VK_DOWN) {
			dir_y = 0;
		}
		if (code == KeyEvent.VK_LEFT) {
			dir_x = 0;
		}
		if (code == KeyEvent.VK_RIGHT) {
			dir_x = 0;
		}
	}

	public int getPos_x() {
		return pos_x;
	}

	public int getPos_y() {
		return pos_y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Image getImage() {
		return image;
	}

}
