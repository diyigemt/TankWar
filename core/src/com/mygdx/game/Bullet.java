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
        ArrayList<Wall>walls = WallManager.checkCrash(this);
        if(walls != null)
        {
            for(Wall wall : walls)
            {
                wall.isCrashed();
            }
        }
        ArrayList<Bonus> bonus = BonusManager.checkCrash(this);
        if(bonus != null)
        {

        }
        ArrayList<Tank> tanks = TankManager.checkCrash(this);
        return isCrash;
    }

    public ArrayList<Bullet>getBullets()
    {
        return Bullet.bullets;
    }
}
