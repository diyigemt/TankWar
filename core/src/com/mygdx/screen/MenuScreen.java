package com.mygdx.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyGdxGame;
import com.mygdx.utils.Assets;

public class MenuScreen implements Screen {
	private Stage stage;
	private MyGdxGame game;

	public MenuScreen(MyGdxGame game) {
		this.game = game;
		stage = new Stage();
		stage.clear();
		TextButton button = new TextButton("start", new Skin(Gdx.files.internal("skin/uiskin.json")));
		button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				onButtonClicked();
			}
		});
		stage.addActor(button);
	}
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
		stage.draw();
	}

	private void onButtonClicked() {
		game.setPaused(false);
		Gdx.input.setInputProcessor(game.getWorldController());
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
