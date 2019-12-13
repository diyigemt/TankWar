package com.mygdx.wall;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.WallType;

public class GrassWall extends Wall {

    public GrassWall(float x, float y) {
        this();
        this.setPosition(x, y);
        this.setX(x);
        this.setY(y);
        this.setLife(1);
    }

    public GrassWall() {
        super();
        this.setWallType(WallType.GRASS_WALL);
        this.setTexture(new Texture(this.getWallType().getAppearance()));
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

    }

    @Override
    public void beenAttacked(int hit) {
        return ;
    }

}
