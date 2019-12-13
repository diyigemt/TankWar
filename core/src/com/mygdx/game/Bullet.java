package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.bonus.Bonus;
import com.mygdx.bonus.BonusManager;
import com.mygdx.tank.Tank;
import com.mygdx.tank.TankManager;
import com.mygdx.utils.Assets;
import com.mygdx.wall.Wall;
import com.mygdx.wall.WallManager;

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

    //
    @Override
    public boolean checkCrash()
    {
        boolean isCrash = false;
        Wall wall = WallManager.checkCrash(this);
        Bonus bonus = BonusManager.checkCrash(this);
        Tank tank = TankManager.checkCrash(this);
        return isCrash;
    }

    public ArrayList<Bullet>getBullets()
    {
        return Bullet.bullets;
    }
}
