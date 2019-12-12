package com.mygdx.wall;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.WallType;

public class WaterWall extends Wall {


    public WaterWall(float x, float y) {
        super(x, y, 1);
    }
    public WaterWall() {
        super();
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
