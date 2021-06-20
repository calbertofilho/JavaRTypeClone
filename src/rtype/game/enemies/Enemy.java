package rtype.game.enemies;

import java.awt.Image;

public class Enemy {

	private static int speed;
	protected int pos_x, pos_y;
	protected int width;
	protected int height;
	private boolean isVisible;
	protected Image image;

	public Enemy(int x, int y) {
		pos_x = x;
		pos_y = y;
		isVisible = true;
	}

	public void load() {}

	public void update() {
		if (pos_x < -50) {
			isVisible = false;
		}
	}

	public static int getSpeed() {
		return speed;
	}

	public static void setSpeed(int speed) {
		Enemy.speed = speed;
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

	public boolean isVisible() {
		return isVisible;
	}

	public Image getImage() {
		return image;
	}

}
