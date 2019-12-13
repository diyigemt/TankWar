package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.enumeration.ObjectType;
import com.mygdx.wall.WallManager;

import java.util.ArrayList;

public abstract class AbstractGameObject extends Sprite {

    private ObjectType type;

    public AbstractGameObject() {
        super();
    }

    public AbstractGameObject(Texture texture) {
        super(texture);
    }

    public AbstractGameObject(TextureRegion region) {
        super(region);
    }

    public void update() {

    }

    public abstract void render(SpriteBatch spriteBatch);

    /**
     * 碰撞检测函数
     * @return true表示和其他物体碰撞，false表示没有碰撞
     */
    public boolean checkCrash()
    {
        return true;
    }

    /**
     * 碰撞检测之后的行为函数
     * @param conflicts 与该Object碰撞的Objects
     */
    public void isCrashed(ArrayList<AbstractGameObject> conflicts) {}

    public ObjectType getType() {
        return type;
    }

    public void setType(ObjectType type) {
        this.type = type;
    }
}
