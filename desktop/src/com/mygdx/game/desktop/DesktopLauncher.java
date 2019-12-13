package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Constants;
import com.mygdx.game.MyGdxGame;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = Constants.WINDOW_TITLE;
		config.width = Constants.WINDOW_WIDTH;
		config.height = Constants.WINDOW_HEIGHT;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
