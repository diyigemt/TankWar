package com.mygdx.tank;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.TankType;
import com.mygdx.game.AbstractGameObject;
import com.mygdx.game.Constants;
import com.mygdx.wall.Wall;

import java.util.ArrayList;

/**
 * 用来管理Tank的Manager类
 */
public class TankManager {

    // 坦克管理器类型，只有两种，不使用枚举，使用常量表示
    private int managerType;
    // 现已创建的坦克list
    private ArrayList<Tank> tanks;

    public TankManager(int managerType) {
        this.managerType = managerType;
        this.tanks = new ArrayList<>();
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
    }

    // 解冻所有坦克
    public void unfreezeAll() {
        for (Tank tank : this.tanks) {
            tank.changeStatus(Constants.UNFREEZE);
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


    public static boolean checkCrash(AbstractGameObject gameObject)
    {
        //Wall i;
        boolean isCrashed = false;
        for(Tank i : Tank.tankManager.getTanks())
        {
            if(i.getX() < gameObject.getX() + gameObject.getWidth() &&
                    i.getX() + i.getWidth() > gameObject.getX() &&
                    i.getY() < gameObject.getY() + gameObject.getHeight() &&
                    i.getY() + i.getHeight() > gameObject.getHeight())
            {
                i.isCrashed();
                gameObject.isCrashed();
                isCrashed = true;
            }
        }
        return isCrashed;
    }

}
