package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.bonus.Bonus;
import com.mygdx.bonus.BonusManager;
import com.mygdx.tank.Tank;
import com.mygdx.tank.TankManager;
import com.mygdx.utils.Assets;
import com.mygdx.wall.Wall;
import com.mygdx.wall.WallManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bullet extends AbstractGameObject {
    //子弹集合
    static private ArrayList<Bullet> bullets = new ArrayList<Bullet>();

    public Bullet() {
        super(Assets.instance.assetGame.bullet);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

    }

    @Override
    //子弹的碰撞检测
    public boolean checkCrash()
    {
        boolean isCrash = false;
        ArrayList<AbstractGameObject> walls = WallManager.checkCrash(this);
        if(walls.isEmpty() == false)
        {
            this.isCrashed(walls);
            ArrayList<AbstractGameObject> temp = new ArrayList<AbstractGameObject>();
            for(AbstractGameObject gameObject:walls)
            {
                temp.clear();
                temp.add(gameObject);
                gameObject.isCrashed(temp);
            }
            isCrash = true;
        }
        ArrayList<AbstractGameObject> bonus = BonusManager.checkCrash(this);
        if(bonus.isEmpty() == false)
        {
            isCrash = true;
            this.isCrashed(bonus);
            ArrayList<AbstractGameObject> temp = new ArrayList<AbstractGameObject>();
            for(AbstractGameObject gameObject : bonus)
            {
                temp.clear();
                temp.add(gameObject);
                gameObject.isCrashed(temp);
            }
        }
        ArrayList<AbstractGameObject> tanks = TankManager.checkCrash(this);
        if(tanks.isEmpty() == false)
        {
            isCrash = true;
            this.isCrashed(tanks);
            ArrayList<AbstractGameObject> temp = new ArrayList<AbstractGameObject>();
            for(AbstractGameObject gameObject : tanks)
            {
                temp.clear();
                temp.add(gameObject);
                gameObject.isCrashed(temp);
            }
        }
        return isCrash;
    }

    public ArrayList<Bullet>getBullets()
    {
        return Bullet.bullets;
    }
}
