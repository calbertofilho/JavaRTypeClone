package rtype.game.sceneries;

import java.util.Random;

import javax.swing.ImageIcon;

import rtype.game.container.Window;

public class Asteroids extends Scenery {

	private ImageIcon objectImageIcon;
	private Random random;
	private int speed;
	private int rotation;

	public Asteroids(int x, int y, int speed, int rotation, ImageIcon objectPath) {
		super(x, y);
		this.speed = speed;
		this.rotation = rotation;
		objectImageIcon = objectPath;
		random = new Random();
	}

	@Override
	public void load() {
		super.setImage(objectImageIcon.getImage());
		super.load();
	}

	@Override
	public void update() {
		setPos_x(getPos_x() - speed);
		setRotation(getRotation() - rotation);
		if (super.getPos_x() < -60) {
			super.setPos_x(Window.WIDTH + random.nextInt(500));
			super.setPos_y(random.nextInt(Window.HEIGHT));
		}
		super.update();
	}

}
