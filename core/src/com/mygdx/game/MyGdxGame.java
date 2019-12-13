package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.utils.Assets;

public class MyGdxGame extends ApplicationAdapter {

	public static final String TAG = MyGdxGame.class.getName();
	private WorldController worldController;
	private WorldRenderer worldRenderer;
	private boolean paused;
	
	@Override
	public void create () {
		// Set libgdx log level to DEBUG
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		// 初始化资源
		Assets.instance.init(new AssetManager());
		// 初始化controller和renderer
		this.worldController = new WorldController();
		this.worldRenderer = new WorldRenderer(this.worldController);
		this.paused = false;
	}

	@Override
	public void resize(int width, int height) {
		worldRenderer.resize(width, height);
	}

	@Override
	public void render () {
		if (!this.paused) {
			worldController.update(Gdx.graphics.getDeltaTime());
		}
		Gdx.gl.glClearColor(0x64 / 255.0f, 0x95 / 255.0f, 0xed / 255.0f, 0xff / 255.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.worldRenderer.render();
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
	}
}
