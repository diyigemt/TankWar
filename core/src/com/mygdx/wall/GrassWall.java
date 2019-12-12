package com.mygdx.wall;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.WallType;

public class GrassWall extends Wall {

    public GrassWall(float x, float y) {
        super(x, y, 1);
    }

    public GrassWall() {
        super();
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

    }

    @Override
    public void beenAttacked(int hit) {
        return ;
    }

}
