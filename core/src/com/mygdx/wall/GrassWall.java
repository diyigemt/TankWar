package com.mygdx.wall;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.ObjectType;
import com.mygdx.enumeration.WallType;
import com.mygdx.game.AbstractGameObject;
import com.mygdx.game.Constants;
import com.mygdx.utils.Assets;

import java.util.ArrayList;

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
        this.setSize(Constants.WALL_SIZE * 2, Constants.WALL_SIZE * 2);
    }
    //被攻击无反应
    @Override
    public void beenAttacked(int hit) {
        return ;
    }

    //无碰撞反应
    @Override
    public void isCrashed(ArrayList<AbstractGameObject> conflicts) {
    }

}
