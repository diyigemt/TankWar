package com.mygdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.Constants;
import com.mygdx.game.MyGdxGame;

public class MenuScreen implements Screen {
	private Stage menuStage;
	private MyGdxGame game;
	private boolean pause;

	public MenuScreen(MyGdxGame game) {
		this.game = game;
		this.pause = false;
		menuStage = new Stage();
		Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		TextButton button = new TextButton("start", skin);
		button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				onStartButtonClicked();
			}
		});
		button.setSize(100,50);
		button.setPosition((Constants.WINDOW_WIDTH - button.getWidth()) / 2, (Constants.WINDOW_HEIGHT - button.getHeight()) / 2);
		Image image = new Image(new Texture(Gdx.files.internal("images/title.png")));
		image.setPosition((Constants.WINDOW_WIDTH - image.getWidth()) / 2, (Constants.WINDOW_HEIGHT - image.getHeight()) / 2 + 200);
		menuStage.addActor(image);
		menuStage.addActor(button);
		Gdx.input.setInputProcessor(menuStage);
	}
	@Override
	public void show() {
		menuStage.draw();
	}

	private void onStartButtonClicked() {
//		game.setMenu(false);
//		game.setPaused(false);
//		game.setMapId(1);
		Screen mapChooseScreen = new MapChooseScreen(this.game);
		game.setScreen(mapChooseScreen);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		menuStage.draw();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {
		this.pause = true;
	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {
		this.pause();
		menuStage.dispose();
	}

	@Override
	public void dispose() {

	}
}
