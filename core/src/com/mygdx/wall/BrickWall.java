package com.mygdx.wall;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.WallType;
import com.mygdx.personal_interface.Destroyable;

public class BrickWall extends Wall implements Destroyable {

    public BrickWall(float x, float y) {
        super(x, y, 100);
    }
    public BrickWall() {
        super();
    }

    @Override
    public void destroy() {

    }

    @Override
    public void render(SpriteBatch spriteBatch) {

    }

    @Override
    public void beenAttacked(int hit)
    {
        return;
    }
}
