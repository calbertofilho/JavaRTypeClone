package rtype.game.enemies;

import java.util.Random;

import javax.swing.ImageIcon;

public class BugShip extends Enemy {

	private int speed;

	public BugShip(int x, int y) {
		super(x, y);
		speed = new Random().nextInt(8) + 1;
	}

	@Override
	public void load() {
		ImageIcon reference = new ImageIcon("res\\images\\assets\\enemies\\enemy4.gif");
		super.image = reference.getImage();
		super.width = image.getWidth(null);
		super.height = image.getHeight(null);
		super.load();
	}

	@Override
	public void update() {
		super.pos_x -= speed;
		super.update();
	}

}
