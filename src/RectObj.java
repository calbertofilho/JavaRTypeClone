import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

@SuppressWarnings("serial")
public class RectObj extends Rectangle {

	public Color color;
	public int speed;
	public int rotation;

	public RectObj(int x, int y, int width, int height) {
		super(x, y, width, height);
		color = new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
		speed = new Random().nextInt(6-4)+4;
		rotation = 0;
	}

	public void update() {
		x += speed;
		rotation+=4;
		if (rotation >= 360) {
			rotation = 0;
		}
	}

}
