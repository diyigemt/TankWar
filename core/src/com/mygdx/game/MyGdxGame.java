package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.screen.GameOverScreen;
import com.mygdx.screen.MenuScreen;
import com.mygdx.utils.Assets;

public class MyGdxGame extends Game {

	public static final String TAG = MyGdxGame.class.getName();
	private WorldController worldController;
	private WorldRenderer worldRenderer;
	private Screen screen;
	private static boolean paused;
	private boolean isMenu;
	public static boolean isOver = false;
	public static boolean hasWon = false;
	@Override
	public void create () {
		// Set libgdx log level to DEBUG
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		// 初始化资源
		Assets.instance.init(new AssetManager());
		// 初始化controller和renderer
		this.worldController = new WorldController(this);
		this.worldRenderer = new WorldRenderer(this.worldController);
		this.paused = true;
		this.isMenu = true;
		isOver = false;
		this.setScreen(new MenuScreen(this));
	}

	@Override
	public void resize(int width, int height) {
//		worldRenderer.resize(width, height);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (isOver) {
			setGameOver();
			this.screen.render(Gdx.graphics.getDeltaTime());
			return;
		}
		if (this.isMenu) {
			this.screen.render(Gdx.graphics.getDeltaTime());
		}
		if (!this.paused) {
			worldController.update(Gdx.graphics.getDeltaTime());
			Gdx.gl.glClearColor(0x64 / 255.0f, 0x95 / 255.0f, 0xed / 255.0f, 0xff / 255.0f);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			this.worldRenderer.render();
		}
	}

	@Override
	public void pause() {
		this.paused = true;
	}

	@Override
	public void resume() {
		this.paused = false;
	}
	
	@Override
	public void dispose () {
		this.worldRenderer.dispose();
		Assets.instance.dispose();
		System.exit(0);
	}

	/** Sets the current screen. {@link Screen#hide()} is called on any old screen, and {@link Screen#show()} is called on the new
	 * screen, if any.
	 * @param screen may be {@code null} */
	public void setScreen (Screen screen) {
		if (this.screen != null) this.screen.hide();
		this.screen = screen;
		if (this.screen != null) {
			this.screen.show();
			this.screen.resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		}
	}

	/** @return the currently active {@link Screen}. */
	public Screen getScreen () {
		return screen;
	}

	public boolean isPaused() {
		return paused;
	}

	public boolean isMenu() {
		return isMenu;
	}

	public void setMenu(boolean menu) {
		isMenu = menu;
	}

	public void setMapId(int id) {
		worldController.setMap(id);
	}
	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public WorldController getWorldController() {
		return worldController;
	}

	public void setGameOver() {
		if (GameOverScreen.class.isInstance(screen)) {
			paused = true;
			return;
		}
		this.setScreen(new GameOverScreen(this));
		paused = true;
	}
}
