package rtype.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Level extends JPanel implements ActionListener {

	private Image background;
	private Player player;
	private int speed;
	private Timer timer;

	public Level() {
		setFocusable(true);
		setDoubleBuffered(true);
		ImageIcon reference = new ImageIcon("res\\assets\\bg\\background.png");
		background = reference.getImage();
		player = new Player();
		player.load();
		speed = 5;
		addKeyListener(new KeyboardAdapter());
		timer = new Timer(speed, this);
		timer.start();
	}

	public void paint(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		graphics.drawImage(background, 0, 0, null);
		graphics.drawImage(player.getImage(), player.getPos_x(), player.getPos_y(), this);
		graphics.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		player.update();
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
