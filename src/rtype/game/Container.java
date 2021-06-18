package rtype.game;

import java.awt.Dimension;

import javax.swing.JFrame;

import rtype.game.stages.Level;

@SuppressWarnings("serial")
public class Container extends JFrame {

	public static int WIDTH, HEIGHT;
	public static Dimension dimension;
	public static String TITLE;

	public Container() {
		WIDTH = 1280;
		HEIGHT = 800;
		dimension = new Dimension(WIDTH, HEIGHT);
		TITLE = "R-Type Like v1.0";
		setTitle(TITLE);
		setPreferredSize(dimension);
		setSize(getPreferredSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		pack();
		add(new Level());
		setVisible(true);
	}

	public static int getWIDTH() {
		return WIDTH;
	}

	public static int getHEIGHT() {
		return HEIGHT;
	}

}
