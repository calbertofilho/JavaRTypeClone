package rtype.game.enemies;

import java.util.Random;

import javax.swing.ImageIcon;

public class Enemy2 extends Enemy {

	private int speed;

	public Enemy2(int x, int y) {
		super(x, y);
		speed = new Random().nextInt(8) + 1;
	}

	@Override
	public void load() {
		ImageIcon reference = new ImageIcon("res\\assets\\enemies\\enemy2.png");
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
