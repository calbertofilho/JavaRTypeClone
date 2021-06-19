package rtype.game.enemies;

import java.util.Random;

import javax.swing.ImageIcon;

public class Enemy3 extends Enemy {

	private int speed;

	public Enemy3(int x, int y) {
		super(x, y);
		speed = new Random().nextInt(8) + 1;
	}

	@Override
	public void load() {
		ImageIcon reference = new ImageIcon("res\\assets\\enemies\\enemy3.png");
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