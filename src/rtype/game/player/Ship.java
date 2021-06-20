package rtype.game.player;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Ship {

	private int speed;
	private int pos_x, pos_y;
	private int dir_x, dir_y;
	private int width, height;
	private Image image;
	private List<Shot> shots;

	public Ship() {
		speed = 6;
		pos_x = 100;
		pos_y = 100;
		shots = new ArrayList<Shot>();
	}

	public void load() {
		ImageIcon reference = new ImageIcon("res\\images\\assets\\player\\player_ship-normal_flight.gif");
		image = reference.getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);
	}

	public void update() {
		pos_x += dir_x;
		pos_y += dir_y;
	}

	public void shoot() {
		shots.add(new Shot(pos_x + (width / 2), (pos_y + (height / 2))));
	}

	public void keyPressed(KeyEvent key) {
		int code = key.getKeyCode();
		if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
			dir_y = -speed;
		}
		if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
			dir_y = speed;
		}
		if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
			dir_x = -speed;
		}
		if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
			dir_x = speed;
		}
		if (code == KeyEvent.VK_SPACE) {
			shoot();
		}
	}

	public void keyReleased(KeyEvent key) {
		int code = key.getKeyCode();
		if (code == KeyEvent.VK_UP || code == KeyEvent.VK_W) {
			dir_y = 0;
		}
		if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
			dir_y = 0;
		}
		if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_A) {
			dir_x = 0;
		}
		if (code == KeyEvent.VK_RIGHT || code == KeyEvent.VK_D) {
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

	public List<Shot> getShots() {
		return shots;
	}

}
