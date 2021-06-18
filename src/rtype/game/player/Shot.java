package rtype.game.player;

import rtype.game.Container;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Shot {

	private static int speed;
	private int pos_x, pos_y;
	private int width, height;
	private boolean isVisible;
	private Image image;

	public Shot(int x, int y) {
		speed = 5;
		pos_x = x;
		pos_y = y;
		isVisible = true;
	}

	public void load() {
		ImageIcon reference = new ImageIcon("res\\assets\\player\\shot-red.png");
		image = reference.getImage();
		width = image.getWidth(null);
		height = image.getHeight(null);
	}

	public void update() {
		pos_x += speed;
		if (pos_x > (Container.getWIDTH() - (this.width / 2))) {
			isVisible = false;
		}
	}

	public static int getSpeed() {
		return speed;
	}

	public static void setSpeed(int speed) {
		Shot.speed = speed;
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
