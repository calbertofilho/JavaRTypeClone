package rtype.container;

import java.awt.Dimension;

import javax.swing.JFrame;

import rtype.game.Level;

@SuppressWarnings("serial")
public class Window extends JFrame {

	public static int WIDTH, HEIGHT;
	public static Dimension dimension;
	public static String TITLE;

	public Window() {
		WIDTH = 1024;
		HEIGHT = 768;
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

}
