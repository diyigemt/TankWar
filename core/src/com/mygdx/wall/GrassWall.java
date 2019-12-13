package com.mygdx.wall;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.WallType;
import com.mygdx.game.Constants;
import com.mygdx.utils.Assets;

public class GrassWall extends Wall {

    public GrassWall(float x, float y) {
        this();
        this.setPosition(x, y);
        this.setX(x);
        this.setY(y);
        this.setLife(1);
    }

    public GrassWall() {
        super(Assets.instance.assetWall.grass);
        this.setWallType(WallType.GRASS_WALL);
        this.setTexture(new Texture(this.getWallType().getAppearance()));
        this.setSize(Constants.WALL_SIZE * 2, Constants.WALL_SIZE * 2);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

    }

    @Override
    public void beenAttacked(int hit) {
        return ;
    }

}
