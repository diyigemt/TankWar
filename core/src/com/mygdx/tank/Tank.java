package com.mygdx.tank;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.bonus.Bonus;
import com.mygdx.bonus.BonusManager;
import com.mygdx.bonus.TankBonus;
import com.mygdx.enumeration.ObjectType;
import com.mygdx.enumeration.TankType;
import com.mygdx.enumeration.WallType;
import com.mygdx.game.AbstractGameObject;
import com.mygdx.game.Bullet;
import com.mygdx.game.Constants;
import com.mygdx.wall.Wall;
import com.mygdx.wall.WallManager;

import java.util.ArrayList;

public class Tank extends AbstractGameObject {

    // 描述坦克是否还存活
    private boolean isAlive;
    // 描述坦克的种类
    private TankType tankType;
    // 坦克的移动速度
    private float moveSpeed;
    // 坦克的射速
    private float shootSpeed;
    //坦克方向
    private Constants.DIRECT direct;
    //方向是否堵塞
    private boolean north = true;
    private boolean south = true;
    private boolean east = true;
    private boolean west = true;


    public Tank(TankType tankType) {
        super(tankType.getTankRegion());
        this.isAlive = true;
        this.tankType = tankType;
        this.moveSpeed = 0.1f;//Constants.DEFAULT_MOVE_SPEED;
        this.shootSpeed = Constants.DEFAULT_SHOOT_SPEED;
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        this.draw(spriteBatch);
    }

    public void setDirect(Constants.DIRECT direct)
    {
        this.direct = direct;
    }
    // 根据类别得到一个坦克的实例
    public static Tank getInstance(TankType tankType) {
        Tank tank = null;
        // TODO
        return null;
    }

    public boolean changeStatus(int mode) {
        return false;
    }


    public TankType getTankType() {
        return this.tankType;
    }

    public void setTankType(TankType tankType) {
        this.tankType = tankType;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    public float getShootSpeed() {
        return shootSpeed;
    }

    public void setShootSpeed(float shootSpeed) {
        this.shootSpeed = shootSpeed;
    }

    public float getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    //坦克移动
    public void moveTank(Constants.DIRECT direct)
    {
        this.direct = direct;
        //改变图片
        switch(direct)
        {
            case SOUTH:
                if(this.south) {
                    this.translate(0,this.getY() - this.moveSpeed);
                    this.north = true;
                }
                break;
            case NORTH:
                if(this.north) {
                    this.translate(0,this.getY() + this.moveSpeed);
                    this.south = true;
                }
                break;
            case WEST:
                if(this.west) {
                    this.translate(this.getX() - this.moveSpeed, 0);
                    this.east = true;
                }
                break;
            case EAST:
                if(this.east) {
                    this.translate(this.getX() + this.moveSpeed,0);
                    this.west = true;
                }
                break;
        }
        this.checkCrash();
    }
    //射击
    public Bullet shoot()
    {
        Bullet bullet = new Bullet();
        if(this.direct == Constants.DIRECT.EAST)
        {
            bullet.setPosition(this.getX() + this.getWidth(), this.getY() + this.getHeight()/2);
            bullet.setOrigin(bullet.getWidth()/2,bullet.getHeight()/2);
        }
        else if(this.direct == Constants.DIRECT.WEST)
        {
            bullet.setPosition(this.getX(), this.getY() + this.getHeight());
            bullet.setOrigin(bullet.getWidth()/2,bullet.getHeight()/2);
        }
        else if(this.direct == Constants.DIRECT.NORTH)
        {
            bullet.setPosition(this.getX() + this.getWidth()/2, this.getY() + this.getHeight());
            bullet.setOrigin(bullet.getWidth()/2,bullet.getHeight()/2);
        }
        else if(this.direct == Constants.DIRECT.SOUTH)
        {
            bullet.setPosition(this.getX() + this.getWidth()/2, this.getY());
            bullet.setOrigin(bullet.getWidth()/2,bullet.getHeight()/2);
        }
        return bullet;
    }
    //碰撞检测
    @Override
    public boolean checkCrash()
    {
        boolean isCrash = false;
        //和墙碰撞
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
                temp.add(gameObject);
                gameObject.isCrashed(temp);
            }
        }
        //和坦克
        ArrayList<AbstractGameObject> tanks = TankManager.checkCrash(this);
        if(tanks.isEmpty() == false)
        {
            this.isCrashed(tanks);
            ArrayList<AbstractGameObject> temp = new ArrayList<AbstractGameObject>();
            for(AbstractGameObject gameObject : tanks)
            {
                temp.clear();
                temp.add(gameObject);
                gameObject.isCrashed(temp);
            }
            isCrash = true;
        }
        //和边界碰撞
        if(this.getX() < -Constants.VIEWPORT_WIDTH/2 ||
                this.getX() + this.getWidth() > Constants.VIEWPORT_WIDTH/2 ||
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


    public void beenAttacked()
    {

    }

    public void blockForward()
    {
        switch(this.direct)
        {
            case NORTH:
                this.north = false;
                break;
            case SOUTH:
                this.south = false;
                break;
            case WEST:
                this.west = false;
                break;
            case EAST:
                this.east = false;
                break;
        }
    }
    //碰撞反应,碰到子弹后生命值减少
    @Override
    public void isCrashed(ArrayList<AbstractGameObject> conflicts) {
        if(conflicts == null)
        {
            switch(this.direct)
            {
                case WEST:
                    this.setX(-Constants.VIEWPORT_WIDTH/2);
                    break;
                case NORTH:
                    this.setY(Constants.VIEWPORT_HEIGHT/2);
                    break;
                case EAST:
                    this.setX(Constants.VIEWPORT_WIDTH/2);
                    break;
                case SOUTH:
                    this.setY(-Constants.VIEWPORT_HEIGHT/2);
                    break;
            }
            this.blockForward();
        }
        else
        {
            for(AbstractGameObject gameObject : conflicts)
            {
                if(gameObject.getType() == ObjectType.BULLET)
                {
                    this.beenAttacked();
                }
                else if(gameObject.getType() == ObjectType.WALL)
                {
                    Wall wall = (Wall)gameObject;
                    if(wall.getType().equals(WallType.BRICK_WALL) ||
                            wall.getType().equals(WallType.IRON_WALL) ||
                            wall.getType().equals(WallType.WATER_WALL)
                    )
                    {
                        this.blockForward();
                    }
                }
            }
        }
    }

}
