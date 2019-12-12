package com.mygdx.wall;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.WallType;
import com.mygdx.game.AbstractGameObject;
import com.mygdx.game.Constants;

public abstract class Wall extends AbstractGameObject {

    // 静态墙管理器实例
    public static WallManager wallManager = new WallManager();
    // 墙的类型
    private WallType wallType;
    // 墙的生命值
    private int life;

    public Wall() {

    }

    public Wall(float x, float y, int life) {
        //x、y左上角坐标
        super();
        //this.setTexture(Wall.texture);
        this.setSize(Constants.WALL_SIZE,Constants.WALL_SIZE);
        this.setOrigin(this.getWidth() / 2.0f, this.getHeight() / 2.0f);
        this.setPosition(x, y);
        this.setX(x);
        this.setY(y);
        this.life = life;
    }

    /**
     * 碰撞检测函数
     *
     * @return true表示和其他物体碰撞，false表示没有碰撞
     */
    @Override
    public boolean checkCrash() {
        return super.checkCrash();
    }

    void beenAttacked(int hit)
    {
        this.life -= hit;
    }

    static Pixmap createProceduralPixmap(int width, int height)
    {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.GREEN);
        pixmap.drawRectangle(0, 0, width, height);
        return pixmap;
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        OrthographicCamera camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(0, 0, 0);
        camera.update();

        spriteBatch.setProjectionMatrix(camera.combined);
        spriteBatch.begin();
        this.draw(spriteBatch);
        spriteBatch.end();

    }


    public static Wall getInstance(WallType wallType){
        // TODO 得到实例类
        return null;
    }
}
