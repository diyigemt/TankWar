package com.mygdx.wall;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.WallType;
import com.mygdx.personal_interface.Destroyable;
import com.mygdx.utils.Assets;

public class BrickWall extends Wall implements Destroyable {

    public BrickWall(float x, float y) {
        this();
        this.setPosition(x, y);
        this.setX(x);
        this.setY(y);
        this.setLife(100);

    }
    public BrickWall()
    {
        super(Assets.instance.assetWall.brick);
        this.setWallType(WallType.BRICK_WALL);
    }

    @Override
    public void destroy() {

    }

//    @Override
//    public void render(SpriteBatch spriteBatch) {
//
//    }

    @Override
    public void beenAttacked(int hit)
    {
        return;
    }
}
