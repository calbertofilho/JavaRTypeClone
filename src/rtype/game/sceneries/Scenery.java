package rtype.game.sceneries;

import java.awt.Image;

public class Scenery {

	private static int speed;
	private int pos_x, pos_y;
	private int width, height;
	public int rotation;
	protected boolean isVisible;
	private Image image;

	public Scenery(int x, int y) {
		pos_x = x;
		pos_y = y;
		rotation = 0;
		isVisible = true;
	}

	public void load() {
		width = image.getWidth(null);
		height = image.getHeight(null);
	}

	public void update() {}

	public static int getSpeed() {
		return speed;
	}

	public static void setSpeed(int speed) {
		Scenery.speed = speed;
	}

	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}

	public int getPos_x() {
		return pos_x;
	}

	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
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

	public int getRotation() {
		return rotation;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Image getImage() {
		return image;
	}

}
