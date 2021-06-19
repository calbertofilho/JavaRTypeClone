package rtype.game;

import rtype.game.container.Splash;

public class App {

	private static Splash splash;

	public static void main(String[] args) {
		splash = new Splash();
		try {
			Thread.sleep (2000);
		} catch (InterruptedException ex) {}
		splash.dispose();
	}

}
