import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spawner {

	public int timer = 0;
	public List<Object> rectangles = new ArrayList<Object>();
	public List<Explosion> explosion = new ArrayList<Explosion>();

	public void update() {

		timer++;
		if (timer % 60 == 0) {
			rectangles.add(new Object(0, new Random().nextInt(App.HEIGHT - 40), 40, 40));
		}
		for (int i = 0; i < rectangles.size(); i++) {
			Object current = rectangles.get(i);
			current.update();
			if (current.x > App.WIDTH) {
				rectangles.remove(current);
				App.life--;
			}
			if (App.clicked) {
				if (App.pos_x >= current.x && App.pos_x < current.x + current.width) {
					if (App.pos_y >= current.y && App.pos_y < current.y + current.height) {
						rectangles.remove(current);
						App.score++;
						App.clicked = false;
						for (int n = 0; n < 50; n++) {
							explosion.add(new Explosion(current.x, current.y, 8, 8, current.color));
						}
					}
				}
			}
		}
		for (int i = 0; i < explosion.size(); i++) {
			explosion.get(i).update();
			Explosion explode = explosion.get(i);
			if (explode.timer >= 60) {
				explosion.remove(explode);
			}
		}

	}

	public void render(Graphics g) {

		for (int i = 0; i < rectangles.size(); i++) {
			Object current = rectangles.get(i);
			Graphics2D g2 = (Graphics2D) g;
			g2.rotate(Math.toRadians(current.rotation), current.x + current.width / 2, current.y + current.height / 2);
			g2.setColor(current.color);
			g2.fillRect(current.x, current.y, current.width, current.height);
			g2.rotate(Math.toRadians(-current.rotation), current.x + current.width / 2, current.y + current.height / 2);
		}
		for (int i = 0; i < explosion.size(); i++) {
			explosion.get(i).render(g);
		}

	}

}
