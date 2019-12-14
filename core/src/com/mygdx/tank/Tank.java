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
    //
    private int Life = 2;
    //方向是否堵塞
    private boolean north = true;
    private boolean south = true;
    private boolean east = true;
    private boolean west = true;


    public Tank(TankType tankType) {
        super(tankType.getTankRegion());
        this.isAlive = true;
        this.tankType = tankType;
        this.moveSpeed = Constants.DEFAULT_MOVE_SPEED;
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
        if(this.getType().equals(ObjectType.HEROTANK))
        {
            this.north = true;
            this.west = true;
            this.east = true;
            this.south = true;
        }
        switch(direct)
        {
            case SOUTH:
                if(this.south) {
                    this.translate(0,-this.moveSpeed);
                    this.north = true;
                    this.west = true;
                    this.east = true;
                }
                break;
            case NORTH:
                if(this.north) {
                    this.translate(0,this.moveSpeed);
                    this.south = true;
                    this.west = true;
                    this.east = true;
                }
                break;
            case WEST:
                if(this.west) {
                    this.translate(-this.moveSpeed, 0);
                    this.east = true;
                    this.north = true;
                    this.south = true;
                }
                break;
            case EAST:
                if(this.east) {
                    this.translate(this.moveSpeed,0);
                    this.west = true;
                    this.south = true;
                    this.north = true;
                }
                break;
        }
        this.checkCrash();
    }

    //射击
    public Bullet shoot()
    {
        Bullet bullet = new Bullet();
        bullet.registerBullet(bullet);
        bullet.setSize(0.1f, 0.1f);
        if(this.getType().equals(ObjectType.HEROTANK))
        {
            bullet.setIsHeroTank(true);
        }
        else
        {
            bullet.setIsHeroTank(false);
        }

        if(this.direct == Constants.DIRECT.EAST)
        {
            bullet.setPosition(this.getX() + this.getWidth() + 0.1f, this.getY() + this.getHeight()/2);
            bullet.setOrigin(bullet.getWidth()/2,bullet.getHeight()/2);
            bullet.setDirect(Constants.DIRECT.EAST);
            this.setEast(true);
        }
        else if(this.direct == Constants.DIRECT.WEST)
        {
            bullet.setPosition(this.getX() - 0.1f, this.getY() + this.getHeight()/2);
            bullet.setOrigin(bullet.getWidth()/2,bullet.getHeight()/2);
            bullet.setDirect(Constants.DIRECT.WEST);
            this.setWest(true);
        }
        else if(this.direct == Constants.DIRECT.NORTH)
        {
            bullet.setPosition(this.getX() + this.getWidth()/2, this.getY() + this.getHeight() + 0.1f);
            bullet.setOrigin(bullet.getWidth()/2,bullet.getHeight()/2);
            bullet.setDirect(Constants.DIRECT.NORTH);
            this.setNorth(true);
        }
        else if(this.direct == Constants.DIRECT.SOUTH)
        {
            bullet.setPosition(this.getX() + this.getWidth()/2, this.getY() - 0.1f);
            bullet.setOrigin(bullet.getWidth()/2,bullet.getHeight()/2);
            bullet.setDirect(Constants.DIRECT.SOUTH);
            this.setSouth(true);
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
                temp.add(this);
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
                temp.add(this);
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
                temp.add(this);
            }
            isCrash = true;
        }
        //和边界碰撞
        if(this.getX() < -Constants.VIEWPORT_WIDTH/2 ||
                this.getX() + this.getWidth() > Constants.VIEWPORT_WIDTH/2 + Constants.MAP_TRANSLATION_X*2||
                this.getY() < -Constants.VIEWPORT_HEIGHT/2 ||
                this.getY() + this.getHeight() > Constants.VIEWPORT_HEIGHT/2
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
        /*switch(this.direct) {
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
        }*/
    }

    //碰撞反应,碰到子弹后生命值减少
    @Override
    public void isCrashed(ArrayList<AbstractGameObject> conflicts) {
        //撞到边界
        if(conflicts == null)
        {
            switch(this.direct)
            {
                case WEST:
                    this.setX(-Constants.VIEWPORT_WIDTH/2);
                    break;
                case NORTH:
                    this.setY(Constants.VIEWPORT_HEIGHT/2 - this.getHeight());
                    break;
                case EAST:
                    this.setX(Constants.VIEWPORT_WIDTH/2 + Constants.MAP_TRANSLATION_X*2 - this.getWidth());
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
                //子弹
                if(gameObject.getType() == ObjectType.BULLET)
                {
                    if(this.getType().equals(ObjectType.HEROTANK) && (!(((Bullet)gameObject).isHeroTank))) {
                        this.beenAttacked();
                    }
                    else if(this.getType().equals(ObjectType.ENEMYTANK) && (((Bullet)gameObject).isHeroTank)) {
                        this.beenAttacked();
                    }
                }
                //墙
                else if(gameObject.getType() == ObjectType.WALL)
                {
                    Wall wall = (Wall)gameObject;
                    if(wall.getWallType().equals(WallType.BRICK_WALL) ||
                            wall.getWallType().equals(WallType.IRON_WALL) ||
                            wall.getWallType().equals(WallType.WATER_WALL)
                    )
                    {
                        switch (this.direct)
                        {
                            case NORTH:
                                this.setY(wall.getY() - this.getHeight());
                                this.north = false;
                                break;
                            case SOUTH:
                                this.setY(wall.getY() + wall.getHeight());
                                this.south = false;
                                break;
                            case EAST:
                                this.setX(wall.getX() - this.getWidth());
                                this.east = false;
                                break;
                            case WEST:
                                this.setX(wall.getX() + wall.getWidth());
                                this.west = false;
                                break;
                        }
                    }
                }
                //和坦克相撞
                else if(gameObject.getType().equals(ObjectType.ENEMYTANK) ||
                        gameObject.getType().equals(ObjectType.HEROTANK))
                {
                    switch (this.direct) {
                        case NORTH:
                            this.setY(gameObject.getY() - this.getHeight());
                            this.north = false;
                            break;
                        case SOUTH:
                            this.setY(gameObject.getY() + gameObject.getHeight());
                            this.south = false;
                            break;
                        case EAST:
                            this.setX(gameObject.getX() - this.getWidth());
                            this.east = false;
                            break;
                        case WEST:
                            this.setX(gameObject.getX() + gameObject.getWidth());
                            this.west = false;
                            break;
                    }
                }
                else
                {
                    return;
                }
            }
        }
    }

    public void setMoveSpeed(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public Constants.DIRECT getDirect() {
        return direct;
    }

    public boolean isNorth() {
        return north;
    }

    public void setNorth(boolean north) {
        this.north = north;
    }

    public boolean isSouth() {
        return south;
    }

    public void setSouth(boolean south) {
        this.south = south;
    }

    public boolean isEast() {
        return east;
    }

    public void setEast(boolean east) {
        this.east = east;
    }

    public boolean isWest() {
        return west;
    }

    public void setWest(boolean west) {
        this.west = west;
    }

    public int getLife() {
        return Life;
    }

    public void setLife(int life) {
        Life = life;
    }
}
