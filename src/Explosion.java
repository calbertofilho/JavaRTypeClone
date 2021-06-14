import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

@SuppressWarnings("serial")
public class Explosion extends Rectangle {

	public Color color;
	public int speed;
	public int rotation;
	public double dir_x, dir_y;
	public double doub_x, doub_y;
	public int timer;

	public Explosion(int x, int y, int width, int height, Color color) {

		super(x, y, width, height);
		doub_x = x;
		doub_y = y;
		this.color = color;
		speed = 8;
		rotation = 0;
		timer = 0;
		dir_x = new Random().nextGaussian();
		dir_y = new Random().nextGaussian();

	}

	public void update() {

		doub_x += dir_x * speed;
		doub_y += dir_y * speed;
		timer++;

	}

	public void render(Graphics g) {

		g.setColor(this.color);
		g.fillRect((int) doub_x, (int) doub_y, width, height);
		
	}

}
