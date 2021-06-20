package rtype.game.stages;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
import rtype.game.enemies.Enemy1;
import rtype.game.enemies.Enemy2;
import rtype.game.enemies.Enemy3;
import rtype.game.enemies.Enemy4;
import rtype.game.enemies.Enemy5;
import rtype.game.player.Ship;
import rtype.game.player.Shot;

@SuppressWarnings("serial")
public class Level extends JPanel implements ActionListener {

	private Image background;
	private Ship player;
	private int speed;
	private Timer timer;
	private List<Enemy> enemies;
	private int maxEnemies;

	public Level() {
		setFocusable(true);
		setDoubleBuffered(true);
		ImageIcon reference = new ImageIcon("res\\images\\assets\\bg\\background.png");
		background = reference.getImage();
		player = new Ship();
		player.load();
		speed = 5;
		maxEnemies = 100;
		addKeyListener(new KeyboardAdapter());
		timer = new Timer(speed, this);
		timer.start();
		initializeEnemies();
	}

	public void initializeEnemies() {
		Random tmp = new Random();
		enemies = new ArrayList<Enemy>();
		System.out.println(maxEnemies);
		for (int i = 0; i < maxEnemies; i++) {
			int x = (int) (tmp.nextInt(20000) + Window.WIDTH);
			int y = (int) (tmp.nextInt(Window.HEIGHT - 30));
			int enemy = tmp.nextInt(5) + 1;
			if (enemy == 1) {
				enemies.add(new Enemy1(x, y));
			} else if (enemy == 2) {
				enemies.add(new Enemy2(x, y));
			} else if (enemy == 3) {
				enemies.add(new Enemy3(x, y));
			} else if (enemy == 4) {
				enemies.add(new Enemy4(x, y));
			} else {
				enemies.add(new Enemy5(x, y));
			}
		}
	}

	public void paint(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		graphics.drawImage(background, 0, 0, null);
		graphics.drawImage(player.getImage(), player.getPos_x(), player.getPos_y(), this);
		List<Shot> shots = player.getShots();
		for (int i = 0; i < shots.size(); i++) {
			Shot current = shots.get(i);
			current.load();
			graphics.drawImage(current.getImage(), current.getPos_x(), current.getPos_y(), this);
		}
		for (int n = 0; n < enemies.size(); n++) {
			Enemy enemy = enemies.get(n);
			enemy.load();
			graphics.drawImage(enemy.getImage(), enemy.getPos_x(), enemy.getPos_y(), this);
		}
		graphics.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
		List<Shot> shots = player.getShots();
		for (int i = 0; i < shots.size(); i++) {
			Shot current = shots.get(i);
			if (current.isVisible()) {
				current.update();
			} else {
				shots.remove(i);
			}
		}
		for (int n = 0; n < enemies.size(); n++) {
			Enemy enemy = enemies.get(n);
			if (enemy.isVisible()) {
				enemy.update();
			} else {
				enemies.remove(n);
				System.out.println(enemies.size());
			}
		}
		repaint();
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
