package com.mygdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.Constants;
import com.mygdx.game.MyGdxGame;

public class GameOverScreen implements Screen {
    private MyGdxGame gdxGame;
    private Stage gameOverScreen;

    public GameOverScreen(MyGdxGame gdxGame) {
        this.gdxGame = gdxGame;
        gameOverScreen = new Stage();
        Image image = new Image(new Texture(Gdx.files.internal("images/gameOver.png")));
        image.setPosition((Constants.WINDOW_WIDTH - image.getImageWidth()) / 2 - 300, (Constants.WINDOW_HEIGHT - image.getHeight()) / 2);
        gameOverScreen.addActor(image);
    }
    @Override
    public void show() {
        gameOverScreen.draw();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameOverScreen.draw();
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
        this.pause();
        gameOverScreen.dispose();
    }

    @Override
    public void dispose() {

    }
}
