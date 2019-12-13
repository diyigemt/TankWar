package com.mygdx.tank;

import com.mygdx.enumeration.ObjectType;
import com.mygdx.enumeration.TankType;
import com.mygdx.game.Constants;
import java.util.Random;

public class EnemyTank extends Tank {

    // 敌方坦克管理器，负责注册，查找，删除现有的敌方坦克
    public static TankManager enemyTankManager = new TankManager(Constants.ENEMYTANK_MANAGER);
    // 描述该敌方坦克是否携带有bonus
    private boolean hasBonus;
    // 描述敌方坦克是否被冰冻住
    private boolean isFrozen;

    public EnemyTank(boolean hasBonus, TankType tankType) {
        super(tankType);
        this.setType(ObjectType.ENEMYTANK);
        this.hasBonus = hasBonus;
    }

    @Override
    public boolean changeStatus(int mode) {
        switch (mode) {
            case Constants.DEAD:
                this.setAlive(false);
                break;
            case Constants.FREEZE:
                this.isFrozen = true;
                break;
            case Constants.UNFREEZE:
                this.isFrozen = false;
                break;
            default:
                return false;
        }
        return true;
    }

    public void move() {

        //目标
        float targetX = -2f + Constants.MAP_TRANSLATION_X;
        float targetY = -2f + Constants.MAP_TRANSLATION_Y;

        //方向随机
        Random r = new Random();
        int rInt = r.nextInt(10);
        if (rInt > 7) {
            if (this.getX() > targetX) this.setDirect(Constants.DIRECT.EAST);
            if (this.getX() < targetX) this.setDirect(Constants.DIRECT.WEST);
        } else if (rInt > 6) this.setDirect(Constants.DIRECT.EAST);
        else if (rInt > 5) this.setDirect(Constants.DIRECT.WEST);
        else if (rInt > 2) this.setDirect(Constants.DIRECT.SOUTH);
        else if (rInt > 0) this.setDirect(Constants.DIRECT.NORTH);

        //前进，遇到障碍重新回到原位
        this.move(this.getDirect());
        this.checkCrash();
    }

    //坦克移动
    public void move(Constants.DIRECT direct) {
        this.setDirect(direct);
        //改变图片
        switch (direct) {
            case SOUTH:
                if (this.isSouth()) {
                    this.translate(0, -this.getMoveSpeed());
                    this.setNorth(true);
                    this.setEast(true);
                    this.setWest(true);
                }
                break;
            case NORTH:
                if (this.isNorth()) {
                    this.translate(0, this.getMoveSpeed());
                    this.setSouth(true);
                    this.setWest(true);
                    this.setEast(true);
                    ;
                }
                break;
            case WEST:
                if (this.isWest()) {
                    this.translate(-this.getMoveSpeed(), 0);
                    this.setEast(true);
                    this.setNorth(true);
                    ;this.setSouth(true);
                }
                break;
            case EAST:
                if (this.isEast()) {
                    this.translate(this.getMoveSpeed(), 0);
                    this.setWest(true);
                    this.setNorth(true);
                    this.setSouth(true);
                }
                break;
        }
        this.checkCrash();
    }

    @Override
    //停车调整方向
    public void blockForward() {
        //调头
        switch (this.getDirect()) {
            case NORTH:
                this.setDirect(Constants.DIRECT.SOUTH);
                break;
            case SOUTH:
                this.setDirect(Constants.DIRECT.NORTH);
                break;
            case WEST:
                this.setDirect(Constants.DIRECT.EAST);
                break;
            case EAST:
                this.setDirect(Constants.DIRECT.WEST);
                break;
        }

        this.moveTank(this.getDirect());

        switch (this.getDirect()) {
            case NORTH:
                this.setDirect(Constants.DIRECT.SOUTH);
                break;
            case SOUTH:
                this.setDirect(Constants.DIRECT.NORTH);
                break;
            case WEST:
                this.setDirect(Constants.DIRECT.EAST);
                break;
            case EAST:
                this.setDirect(Constants.DIRECT.WEST);
                break;
        }

    }

    private Constants.DIRECT int2direct(int direct)
    {
        switch (direct)
        {
            case 1:
                return Constants.DIRECT.NORTH;
            case 2:
                return Constants.DIRECT.SOUTH;
            case 3:
                return Constants.DIRECT.WEST;
            case 4:
                return Constants.DIRECT.EAST;
        }
        return  Constants.DIRECT.NORTH;
    }


    public boolean isHasBonus() {
        return hasBonus;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }

    public void setHasBonus(boolean hasBonus) {
        this.hasBonus = hasBonus;
    }


}
