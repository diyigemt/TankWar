package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.bonus.Bonus;
import com.mygdx.bonus.BonusManager;
import com.mygdx.enumeration.ObjectType;
import com.mygdx.enumeration.WallType;
import com.mygdx.tank.Tank;
import com.mygdx.tank.TankManager;
import com.mygdx.utils.Assets;
import com.mygdx.wall.BrickWall;
import com.mygdx.wall.Wall;
import com.mygdx.wall.WallManager;
import com.sun.org.apache.bcel.internal.Const;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bullet extends AbstractGameObject {
    //子弹方向
    private Constants.DIRECT direct;
    //子弹集合
    static private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
    //
    public boolean isHeroTank;
    //子弹速度
    private float speed = 0.06f;

    public Bullet() {
        super(Assets.instance.assetGame.bullet);
        this.setType(ObjectType.BULLET);
    }

    public void setIsHeroTank(boolean isHeroTank)
    {
        this.isHeroTank = isHeroTank;
    }

    public Bullet(float x, float y, Constants.DIRECT direct)
    {
        this();
        this.setSize(0.5f, 0.5f);
        this.setOrigin(this.getWidth() / 2.0f, this.getHeight() / 2.0f);
        this.direct = direct;
    }

    public void registerBullet(Bullet bullet)
    {
        this.bullets.add(bullet);
    }

    public void setDirect(Constants.DIRECT direct)
    {
        this.direct = direct;
    }
    //移动函数
    public void move()
    {
        switch (this.direct)
        {
            case NORTH:
                this.translateY(this.speed);
                break;
            case SOUTH:
                this.setY(this.getY() - this.speed);
                break;
            case EAST:
                this.setX(this.getX() + this.speed);
                break;
            case WEST:
                this.setX(this.getX() - this.speed);
                break;
            default:
                break;
        }
    }

    @Override
    //子弹的碰撞检测
    public boolean checkCrash()
    {
        //和墙
        boolean isCrash = false;
        ArrayList<AbstractGameObject> walls = WallManager.checkCrash(this);
        if(walls.isEmpty() == false)
        {
            ArrayList<AbstractGameObject> temp = new ArrayList<AbstractGameObject>();
            for(AbstractGameObject gameObject:walls)
            {
                temp.clear();
                temp.add(this);
                Wall wall = (Wall)gameObject;
                if(wall.getWallType().equals(WallType.BRICK_WALL))
                {
                    ((BrickWall)wall).isCrashed(temp);
                }
            }
            this.isCrashed(walls);
            isCrash = true;
        }
        //和buff
        ArrayList<AbstractGameObject> bonus = BonusManager.checkCrash(this);
        if(bonus.isEmpty() == false)
        {
            isCrash = true;
            this.isCrashed(bonus);
            ArrayList<AbstractGameObject> temp = new ArrayList<AbstractGameObject>();
            for(AbstractGameObject gameObject : bonus)
            {
                temp.clear();
                temp.add(this);
                gameObject.isCrashed(temp);
            }
        }
        //和坦克
        ArrayList<AbstractGameObject> tanks = TankManager.checkCrash(this);
        if(tanks.isEmpty() == false)
        {
            isCrash = true;
            this.isCrashed(tanks);
            ArrayList<AbstractGameObject> temp = new ArrayList<AbstractGameObject>();
            for(AbstractGameObject gameObject : tanks)
            {
                temp.clear();
                temp.add(this);
                gameObject.isCrashed(temp);
            }
        }
        //和边界碰撞
        if(this.getX() < -Constants.VIEWPORT_WIDTH/2 ||
                this.getX() + this.getWidth() > Constants.VIEWPORT_WIDTH/2 + Constants.MAP_TRANSLATION_X*2 ||
                this.getY() < -Constants.VIEWPORT_HEIGHT/2 ||
                this.getY() + this.getHeight() > Constants.VIEWPORT_HEIGHT
        )
        {
            //和边界碰撞
            this.isCrashed(null);
            isCrash = true;
        }
        return isCrash;
    }

    //碰撞反应函数
    @Override
    public void isCrashed(ArrayList<AbstractGameObject> conflicts) {
        if(conflicts == null)
            Bullet.bullets.remove(this);
        else if(conflicts.isEmpty() == false)
        {
            if(conflicts.get(0).getType().equals(ObjectType.HEROTANK) || conflicts.get(0).getType().equals(ObjectType.ENEMYTANK))
            {
                Bullet.bullets.remove(this);
            }
            if(conflicts.get(0).getType().equals(ObjectType.WALL))
            {
                if(((Wall)conflicts.get(0)).getWallType().equals(WallType.BRICK_WALL) ||
                        ((Wall)conflicts.get(0)).getWallType().equals(WallType.IRON_WALL)
                )
                    Bullet.bullets.remove(this);
            }
        }
    }

    static public ArrayList<Bullet> getBullets()
    {
        return Bullet.bullets;
    }

    @Override
    public void render(SpriteBatch spriteBatch)
    {
        for(Bullet bullet : bullets) {
            bullet.draw(spriteBatch);
        }
    }

    static public void renderCopy(SpriteBatch spriteBatch)
    {
        for(Bullet bullet : bullets) {
            bullet.draw(spriteBatch);
        }
    }

}
