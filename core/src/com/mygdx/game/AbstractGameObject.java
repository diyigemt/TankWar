package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class AbstractGameObject extends Sprite {
    public AbstractGameObject() {
        super();
    }

    public void update() {

    }

    public abstract void render(SpriteBatch spriteBatch);

    /**
     * 碰撞检测函数
     * @return true表示和其他物体碰撞，false表示没有碰撞
     */
    public boolean checkCrash() {
        return false;
    }

    /**
     * 碰撞检测之后的行为函数
     */
    public void isCrashed() {}

}
