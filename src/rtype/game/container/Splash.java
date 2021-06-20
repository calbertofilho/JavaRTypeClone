package rtype.game.container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Splash extends JFrame {

	private static JLabel imgSplash;

	public Splash() {
		setPreferredSize(Window.DIMENSION);
		setSize(getPreferredSize());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setLayout(null);
	    setLocationRelativeTo(null);
		this.load();
		add(imgSplash);
		pack();
	    setVisible(true);
	}

	public void load() {
		ImageIcon reference = new ImageIcon("res\\images\\assets\\bg\\splash-screen.png");
		imgSplash = new JLabel(reference);
		imgSplash.setBounds(0, 0, Window.WIDTH, Window.HEIGHT);
	}

	public void dispose() {
		new Window();
		super.dispose();
	}

}
