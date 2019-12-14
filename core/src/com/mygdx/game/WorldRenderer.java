package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.bonus.Bonus;
import com.mygdx.tank.EnemyTank;
import com.mygdx.tank.HeroTank;
import com.mygdx.wall.Wall;

public class WorldRenderer implements Disposable {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private WorldController worldController;

    private Screen startMenu;

    public WorldRenderer(WorldController worldController) {
        this.worldController = worldController;
        this.init();
    }

    private void init(){
        this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(0, 0, 0);
        camera.update();
    }
    public void render() {

        this.batch.setProjectionMatrix(camera.combined);
        this.batch.begin();
        Wall.wallManager.render(this.batch);
        Bonus.bonusManager.render(this.batch);
        HeroTank.heroTankManager.render(this.batch);
        EnemyTank.enemyTankManager.render(this.batch);
        Bullet.renderCopy(this.batch);
        Stage stage = new Stage();
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        TextButton button = new TextButton("start", skin);
        stage.addActor(button);
        stage.draw();
        this.batch.end();

    }


    public void resize(int width, int height) {
        camera.viewportWidth = (Constants.VIEWPORT_HEIGHT / height) * width;
        camera.update();
    }

    @Override
    public void dispose() {
        this.batch.dispose();
    }
}
