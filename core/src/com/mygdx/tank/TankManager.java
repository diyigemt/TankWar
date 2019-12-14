package com.mygdx.tank;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.enumeration.ObjectType;
import com.mygdx.enumeration.TankType;
import com.mygdx.game.*;
import com.sun.org.apache.bcel.internal.Const;

import java.util.ArrayList;

/**
 * 用来管理Tank的Manager类
 */
public class TankManager extends Timer {

    // 坦克管理器类型，只有两种，不使用枚举，使用常量表示
    private int managerType;
    // 现已创建的坦克list
    private ArrayList<Tank> tanks;
    // 整个场景目前的冰冻状态
    private boolean isFrozen;
    // 存放现有敌方坦克数量
    private int enemyTankNum;

    public TankManager(int managerType) {
        this.managerType = managerType;
        this.tanks = new ArrayList<>();
        this.isFrozen = false;
        this.enemyTankNum = Constants.ENEMY_NUMBER;
        if (this.managerType == Constants.ENEMYTANK_MANAGER) {
            this.scheduleTask(new ShootTask(), 0, Constants.SHOOT_CD, Constants.INFINITY);
            this.generateTank();
        }
    }

    // 注册创建的坦克
    public void registerTank(Tank tank) {
        this.tanks.add(tank);
    }

    // 创建一个坦克的实例并直接注册
    public Tank createTank(TankType tankType) {
        // 创建实例
        Tank tank = Tank.getInstance(tankType);
        // 注册
        if (tank != null) {
            this.registerTank(tank);
            return tank;
        } else {
            System.err.println("未能成功创建一个指定类别的坦克实例！");
            return null;
        }
    }

    // 删除一个坦克
    public boolean deleteTank(Tank tank) {
        if (this.tanks.contains(tank)) {
            this.tanks.remove(tank);
            if (this.managerType == Constants.ENEMYTANK_MANAGER) {
                this.enemyTankNum--;
                if (this.enemyTankNum == 0) {
                    MyGdxGame.hasWon = true;
                }
            } else {
                if (this.tanks.isEmpty()) {
                    MyGdxGame.isOver = true;
                }
            }
            return true;
        }
        return false;
    }

    // 删除所有的坦克
    public void deleteAll() {
        this.tanks.clear();
    }

    // 渲染所有的坦克
    public void render(SpriteBatch spriteBatch) {
        for (Tank tank : this.tanks) {
            tank.render(spriteBatch);
        }
    }

    // 冰冻所有的坦克
    public void freezeAll() {
        for (Tank tank : this.tanks) {
            tank.changeStatus(Constants.FREEZE);
        }
        this.isFrozen = true;
    }

    // 解冻所有坦克
    public void unfreezeAll() {
        for (Tank tank : this.tanks) {
            tank.changeStatus(Constants.UNFREEZE);
        }
        this.isFrozen = false;
    }
    // 调用所有坦克的shoot函数
    public void shoot() {
        for (Tank tank : this.tanks) {
            tank.shoot();
        }
    }

    public ArrayList<Tank> getTanks() {
        return tanks;
    }

    public void setTanks(ArrayList<Tank> tanks) {
        this.tanks = tanks;
    }

    public int getManagerType() {
        return managerType;
    }

    public void setManagerType(int managerType) {
        this.managerType = managerType;
    }


    //和坦克相撞
    public static ArrayList<AbstractGameObject> checkCrash(AbstractGameObject gameObject)
    {
        //英雄坦克
        ArrayList<AbstractGameObject>crashTank = new ArrayList<AbstractGameObject>();
        if(!gameObject.getType().equals(ObjectType.HEROTANK)) {
            for (Tank tank : HeroTank.heroTankManager.getTanks()) {
                if (tank.getX() < gameObject.getX() + gameObject.getWidth() &&
                        tank.getX() + tank.getWidth() > gameObject.getX() &&
                        tank.getY() < gameObject.getY() + gameObject.getHeight() &&
                        tank.getY() + tank.getHeight() > gameObject.getY()) {
                    crashTank.add(tank);
                }
            }
        }
        //敌方坦克
        for (Tank tank : EnemyTank.enemyTankManager.getTanks()) {
            if ((!tank.equals(gameObject)) && tank.getX() < gameObject.getX() + gameObject.getWidth() &&
                    tank.getX() + tank.getWidth() > gameObject.getX() &&
                    tank.getY() < gameObject.getY() + gameObject.getHeight() &&
                    tank.getY() + tank.getHeight() > gameObject.getY()) {
                crashTank.add(tank);
            }
        }

        return crashTank;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }


    // 生成敌方坦克的函数
    public void generateTank() {
        this.enemyTankNum = Constants.ENEMY_NUMBER;
        this.scheduleTask(new EnemyTankGenerator(), 0, Constants.CREATE_ENEMY_CD, Constants.ENEMY_NUMBER);
    }
}
