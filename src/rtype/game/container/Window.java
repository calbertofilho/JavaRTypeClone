package rtype.game.container;

import java.awt.Dimension;

import javax.swing.JFrame;

import rtype.game.stages.Level;

@SuppressWarnings("serial")
public class Window extends JFrame {

	public static final int WIDTH = 1280, HEIGHT = 720;
	public static final Dimension DIMENSION = new Dimension(WIDTH, HEIGHT);
	public static final String TITLE = "R-Type Like v1.0";

	public Window() {
		setTitle(TITLE);
		setPreferredSize(DIMENSION);
		setSize(getPreferredSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		pack();
		add(new Level());
		setVisible(true);
	}

}
