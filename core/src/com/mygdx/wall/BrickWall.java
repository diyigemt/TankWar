package com.mygdx.wall;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.enumeration.ObjectType;
import com.mygdx.enumeration.WallType;
import com.mygdx.game.AbstractGameObject;
import com.mygdx.personal_interface.Destroyable;
import com.mygdx.utils.Assets;

import java.util.ArrayList;

public class BrickWall extends Wall implements Destroyable {

    public BrickWall(float x, float y) {
        this();
        this.setPosition(x, y);
        this.setX(x);
        this.setY(y);
        this.setLife(2);

    }
    public BrickWall(TextureRegion region, float x, float y) {
        this(x, y);
        this.setRegion(region);
    }
    public BrickWall()
    {
        super(Assets.instance.assetWall.brick);
        this.setWallType(WallType.BRICK_WALL);
    }

    @Override
    public void destroy() {

    }

    //碰撞反应,碰到子弹后生命值减少
    @Override
    public void isCrashed(ArrayList<AbstractGameObject> conflicts) {
        if(conflicts.isEmpty() == false)
        {
            for(AbstractGameObject gameObject : conflicts)
            {
                System.out.println(gameObject.getType());
                System.out.println(ObjectType.BULLET);
                if(gameObject.getType().equals(ObjectType.BULLET))
                {
                    this.beenAttacked(1);
                    if(this.getLife() <= 0) {
                        Wall.wallManager.getWalls().remove(this);
                        Wall.wallManager.getBaseWalls().remove(this);
                    }
                }
            }
        }
    }


    @Override
    public void beenAttacked(int hit)
    {
        this.setLife(this.getLife() - hit);
        return;
    }
}
