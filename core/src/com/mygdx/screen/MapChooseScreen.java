package com.mygdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
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
		image.setPosition(Constants.WINDOW_WIDTH / 2 - 350, Constants.WINDOW_HEIGHT / 2 - 100);
		image.setSize(150,150);
		mapChooseStage.addActor(image);
		image = new Image(new Texture(Gdx.files.internal("map/2.png")));
		image.setPosition(Constants.WINDOW_WIDTH / 2 - 50, Constants.WINDOW_HEIGHT / 2 - 100);
		image.setSize(150,150);
		mapChooseStage.addActor(image);
		image = new Image(new Texture(Gdx.files.internal("map/3.png")));
		image.setPosition(Constants.WINDOW_WIDTH / 2 + 250, Constants.WINDOW_HEIGHT / 2 - 100);
		image.setSize(150,150);
		mapChooseStage.addActor(image);
		Gdx.input.setInputProcessor(mapChooseStage);
	}


	private void onMapButtonClicked(int id) {
		game.setPaused(false);
		game.setMenu(false);
		game.setMapId(id);
		MyGdxGame.isOver = false;
		Gdx.input.setInputProcessor(game.getWorldController());
	}
	@Override
	public void show() {
		mapChooseStage.draw();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			int x = Gdx.input.getX();
			int y = Gdx.input.getY();
			if (x >= Constants.WINDOW_WIDTH / 2 - 350 && x <= Constants.WINDOW_WIDTH / 2 - 350 + 150 && y >= Constants.WINDOW_HEIGHT / 2 - 100 && y <= Constants.WINDOW_HEIGHT / 2 - 100 + 150) {
				onMapButtonClicked(1);
			}
			if (x >= Constants.WINDOW_WIDTH / 2 - 50 && x <= Constants.WINDOW_WIDTH / 2 - 50 + 150 && y >= Constants.WINDOW_HEIGHT / 2 - 100 && y <= Constants.WINDOW_HEIGHT / 2 - 100 + 150) {
				onMapButtonClicked(2);
			}
			if (x >= Constants.WINDOW_WIDTH / 2 + 250 && x <= Constants.WINDOW_WIDTH / 2 + 250 + 150 && y >= Constants.WINDOW_HEIGHT / 2 - 100 && y <= Constants.WINDOW_HEIGHT / 2 - 100 + 150) {
				onMapButtonClicked(3);
			}
		}
		mapChooseStage.draw();
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
