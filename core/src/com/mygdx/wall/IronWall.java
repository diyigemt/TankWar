package com.mygdx.wall;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.ObjectType;
import com.mygdx.enumeration.WallType;
import com.mygdx.game.AbstractGameObject;
import com.mygdx.utils.Assets;

import java.util.ArrayList;

public class IronWall extends Wall {

    public IronWall(float x, float y) {
        this();
        this.setPosition(x, y);
        this.setX(x);
        this.setY(y);
        this.setLife(1);
    }

    public IronWall() {
        super(Assets.instance.assetWall.iron);
        this.setWallType(WallType.IRON_WALL);
    }


    @Override
    public void render(SpriteBatch spriteBatch) {

    }

    //攻击无效
    @Override
    public void beenAttacked(int hit)
    {
        return;
    }

    //碰撞反应,碰到子弹后生命值减少
    @Override
    public void isCrashed(ArrayList<AbstractGameObject> conflicts) {
    }
}
