package com.mygdx.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.mygdx.game.Constants;
import com.mygdx.game.MyGdxGame;
import com.mygdx.utils.Assets;

public class MenuScreen implements Screen {
	private Stage menuStage;
	private MyGdxGame game;

	public MenuScreen(MyGdxGame game) {
		this.game = game;
		menuStage = new Stage();
		Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

		TextButton button = new TextButton("start", skin);
		button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				onStartButtonClicked();
			}
		});
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
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0F, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Image image = new Image(new Texture(Gdx.files.internal("images/title.png")));
		image.setPosition(0f,0f);
		menuStage.addActor(image);
		game.setMenu(false);
		game.setPaused(false);
		//Screen mapChooseScreen = new MapChooseScreen(this.game);
		//game.setScreen(mapChooseScreen);
	}

	@Override
	public void render(float delta) {
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {

	}
}
