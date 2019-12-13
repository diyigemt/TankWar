package com.mygdx.wall;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.WallType;
import com.mygdx.utils.Assets;

public class WaterWall extends Wall {


    public WaterWall(float x, float y) {
        this();
        this.setPosition(x, y);
        this.setX(x);
        this.setY(y);
        this.setLife(1);
    }
    public WaterWall() {
        super(Assets.instance.assetWall.water);
        this.setWallType(WallType.WATER_WALL);
        this.setTexture(new Texture(this.getWallType().getAppearance()));
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
