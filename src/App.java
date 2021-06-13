import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
//import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class App extends Canvas implements Runnable {

	public static final int WIDTH = 1366, HEIGHT = 768;
	public static int life = 100;
	public Spawner spawner;

	public App() {
		Dimension dimension = new Dimension(WIDTH, HEIGHT);
		this.setPreferredSize(dimension);
		spawner = new Spawner(); 
	}

	public void update() {
		spawner.update();
		if (life <= 0) {
			life = 100;
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
/*
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 24));
		g.drawString("Pontos: "+score, WIDTH/2, 20);
*/
		g.setColor(Color.red);
		g.fillRect(App.WIDTH / 2 - 100, 20, life * 3, 30);
		g.setColor(Color.white);
		g.drawRect(App.WIDTH / 2 - 100, 20, 300, 30);
		spawner.render(g);
		bs.show();
	}

	@Override
	public void run() {
		while(true) {
			update();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
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
