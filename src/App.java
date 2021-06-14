import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
//import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class App extends Canvas implements Runnable, MouseListener {

	public static final int WIDTH = 800, HEIGHT = 600;
	public static int life;
	public static int score;
	public static int pos_x, pos_y;
	public static boolean clicked;
	public static boolean running;
	public Spawner spawner;

	public App() {

		life = 100;
		score = 0;
		clicked = false;
		running = true;
		Dimension dimension = new Dimension(WIDTH, HEIGHT);
		this.setPreferredSize(dimension);
		this.addMouseListener(this);
		spawner = new Spawner(); 

	}

	public void update() {

		if (running) {
			spawner.update();
			if (life <= 0) {
				life = 100;
				running = false;
			}
		}

	}

	public void render() {

		BufferStrategy bs = this.getBufferStrategy();

		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		if (running) {
			g.setColor(Color.white);
			g.setFont(new Font("Arial", Font.BOLD, 24));
			g.drawString("Pontos: "+score, WIDTH - 150, 20);
			g.setColor(Color.red);
			g.fillRect(App.WIDTH / 2 - 100, 20, life * 3, 30);
			g.setColor(Color.white);
			g.drawRect(App.WIDTH / 2 - 100, 20, 300, 30);
			spawner.render(g);
		} else {
			g.setColor(Color.white);
			g.setFont(new Font("Arial", Font.BOLD, 24));
			g.drawString("Pontos: "+score, WIDTH - 150, 20);
			g.setFont(new Font("Arial", Font.BOLD, 32));
			g.drawString("Game Over", WIDTH / 2, HEIGHT / 2);
		}
		bs.show();

	}

	@Override
	public void run() {

		while (true) {
			update();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

		clicked = true;
		pos_x = e.getX();
		pos_y = e.getY();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) throws Exception {

		App game = new App();
		JFrame window = new JFrame("Meu Jogo");
		window.add(game);
		window.setLocationRelativeTo(null);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

		new Thread(game).start();

	}

}
