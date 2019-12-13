package com.mygdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.Constants;
import com.mygdx.game.MyGdxGame;

public class MapChooseScreen implements Screen {
	private Stage mapChooseStage;
	private MyGdxGame game;

	public MapChooseScreen(final MyGdxGame game) {
		this.game = game;
		this.mapChooseStage = new Stage();
		Gdx.input.setInputProcessor(mapChooseStage);
		Image image = new Image(new Texture(Gdx.files.internal("images/select.png")));
		image.setPosition((Constants.WINDOW_WIDTH - image.getWidth()) / 2, (Constants.WINDOW_HEIGHT - image.getHeight()) / 2 + 200);
		mapChooseStage.addActor(image);
		image = new Image(new Texture(Gdx.files.internal("map/1.png")));
		image.setPosition((Constants.WINDOW_WIDTH - image.getWidth()) / 2 - 200, (Constants.WINDOW_HEIGHT - image.getHeight()) / 2);
		image.setSize(150,150);
		image.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setMapId(1);
				onMapButtonClicked();
				System.err.println("111");
			}
		});
		mapChooseStage.addActor(image);
		image = new Image(new Texture(Gdx.files.internal("map/2.png")));
		image.setPosition((Constants.WINDOW_WIDTH - image.getWidth()) / 2, (Constants.WINDOW_HEIGHT - image.getHeight()) / 2);
		image.setSize(150,150);
		image.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setMapId(2);
				onMapButtonClicked();
			}
		});
		mapChooseStage.addActor(image);
		image = new Image(new Texture(Gdx.files.internal("map/3.png")));
		image.setPosition((Constants.WINDOW_WIDTH - image.getWidth()) / 2 + 200, (Constants.WINDOW_HEIGHT - image.getHeight()) / 2);
		image.setSize(150,150);
		image.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setMapId(3);
				onMapButtonClicked();
			}
		});
		mapChooseStage.addActor(image);
	}


	private void onMapButtonClicked() {
		game.setPaused(false);
		game.setMenu(false);
		Gdx.input.setInputProcessor(game.getWorldController());
	}
	@Override
	public void show() {
		Gdx.input.setInputProcessor(mapChooseStage);
		mapChooseStage.draw();
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
