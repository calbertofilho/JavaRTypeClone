package rtype.game.stages;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import rtype.game.container.Window;
import rtype.game.enemies.Enemy;
import rtype.game.enemies.SpaceShip;
import rtype.game.enemies.CrabShip;
import rtype.game.enemies.JetShip;
import rtype.game.enemies.BugShip;
import rtype.game.enemies.FlyShip;
import rtype.game.player.Ship;
import rtype.game.player.Shot;
import rtype.game.sceneries.Stars;

@SuppressWarnings("serial")
public class Level extends JPanel implements ActionListener {

	private Image background;
	private Ship player;
	private int speed;
	private Timer timer;
	private boolean running;
	private Random random;
	private List<Enemy> enemies;
	private int maxEnemies;
	private List<Stars> stars;
	private int maxStars;

	public Level() {
		setFocusable(true);
		setDoubleBuffered(true);
		ImageIcon reference = new ImageIcon("res\\images\\assets\\bg\\background.png");
		background = reference.getImage();
		player = new Ship();
		player.load();
		speed = 5;
		maxEnemies = 100;
		maxStars = 250;
		addKeyListener(new KeyboardAdapter());
		timer = new Timer(speed, this);
		timer.start();
		initializeEnemies();
		initializeScenery();
		running = true;
	}

	public void initializeEnemies() {
		random = new Random();
		enemies = new ArrayList<Enemy>();
		for (int i = 0; i < maxEnemies; i++) {
			int x = (int) (random.nextInt(20000) + Window.WIDTH);
			int y = (int) (random.nextInt(Window.HEIGHT - 30));
			int enemy = random.nextInt(5) + 1;
			if (enemy == 1) {
				enemies.add(new SpaceShip(x, y));
			} else if (enemy == 2) {
				enemies.add(new CrabShip(x, y));
			} else if (enemy == 3) {
				enemies.add(new JetShip(x, y));
			} else if (enemy == 4) {
				enemies.add(new BugShip(x, y));
			} else {
				enemies.add(new FlyShip(x, y));
			}
		}
	}

	public void initializeScenery() {
		random = new Random();
		stars = new ArrayList<Stars>();
		int star;
		for (int i = 0; i < maxStars; i++) {
			int x = (int) (random.nextInt(Window.WIDTH));
			int y = (int) (random.nextInt(Window.HEIGHT - 30));
			star = random.nextInt(2) + 1;
			if (star == 1) {
				stars.add(new Stars(x, y, 4, new ImageIcon("res\\images\\assets\\sceneries\\star7.png")));
			} else {
				stars.add(new Stars(x, y, 3, new ImageIcon("res\\images\\assets\\sceneries\\star13.png")));
			}
			if (i > (int) Math.round(0.90 * maxStars)) {
				star = random.nextInt(2) + 1;
				if (star == 1) {
					stars.add(new Stars(x, y, 2, new ImageIcon("res\\images\\assets\\sceneries\\star28.png")));
				} else {
					stars.add(new Stars(x, y, 1, new ImageIcon("res\\images\\assets\\sceneries\\star35.png")));
				}				
			}
		}
	}

	public void paint(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		if (running) {
			graphics.drawImage(background, 0, 0, null);
			Stars star;
			for (int i = 0; i < stars.size(); i++) {
				star = stars.get(i);
				star.load();
				graphics.drawImage(star.getImage(), star.getPos_x(), star.getPos_y(), this);
			}
			graphics.drawImage(player.getImage(), player.getPos_x(), player.getPos_y(), this);
			List<Shot> shots = player.getShots();
			Shot current;
			for (int o = 0; o < shots.size(); o++) {
				current = shots.get(o);
				current.load();
				graphics.drawImage(current.getImage(), current.getPos_x(), current.getPos_y(), this);
			}
			Enemy enemy;
			for (int n = 0; n < enemies.size(); n++) {
				enemy = enemies.get(n);
				enemy.load();
				graphics.drawImage(enemy.getImage(), enemy.getPos_x(), enemy.getPos_y(), this);
			}
		} else {
			ImageIcon gameOver = new ImageIcon("res\\images\\assets\\messages\\game-over.png");
			graphics.drawImage(gameOver.getImage(), ((Window.WIDTH / 2) - (gameOver.getIconWidth() / 2)), ((Window.HEIGHT / 2) - (gameOver.getIconHeight() / 2)), null);
		}
		graphics.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		Stars star;
		for (int i = 0; i < stars.size(); i++) {
			star = stars.get(i);
			if (star.isVisible()) {
				star.update();
			} else {
				stars.remove(i);
			}
		}
		List<Shot> shots = player.getShots();
		Shot current;
		for (int o = 0; o < shots.size(); o++) {
			current = shots.get(o);
			if (current.isVisible()) {
				current.update();
			} else {
				shots.remove(o);
			}
		}
		Enemy enemy;
		for (int n = 0; n < enemies.size(); n++) {
			enemy = enemies.get(n);
			if (enemy.isVisible()) {
				enemy.update();
			} else {
				enemies.remove(n);
			}
		}
		testColisions();
		repaint();
	}

	public void testColisions() {
		Rectangle shipBounds = player.getBounds();
		Rectangle enemyBounds, shotBounds;
		List<Shot> shots = player.getShots();
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			enemyBounds = enemy.getBounds();
			if (shipBounds.intersects(enemyBounds)) {
				player.setVisible(false);
				enemy.setVisible(false);
				running = false;
			}
		}
		for (int n = 0; n < shots.size(); n++) {
			Shot current = shots.get(n);
			shotBounds = current.getBounds(); 
			for (int z = 0; z < enemies.size(); z++) {
				Enemy enemy = enemies.get(z);
				enemyBounds = enemy.getBounds();
				if (shotBounds.intersects(enemyBounds)) {
					enemy.setVisible(false);
					current.setVisible(false);
				}
			}
		}
	}

	private class KeyboardAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent key) {
			player.keyPressed(key);
		}

		@Override
		public void keyReleased(KeyEvent key) {
			player.keyReleased(key);
		}

	}

}
