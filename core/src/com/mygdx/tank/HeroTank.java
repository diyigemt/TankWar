package com.mygdx.tank;

import com.mygdx.enumeration.ObjectType;
import com.mygdx.enumeration.TankType;
import com.mygdx.game.Constants;
import com.mygdx.utils.Assets;

public class HeroTank extends Tank {

    // 英雄坦克管理器
    public static TankManager heroTankManager = new TankManager(Constants.HEROTANK_MANAGER);
    // 描述坦克是否处于保护状态
    private boolean isProtected;
    // 记录玩家坦克的命数
    private int chances;

    public int getChances() {
        return chances;
    }

    public void setChances(int chances) {
        this.chances = chances;
    }

    public HeroTank(boolean isProtected, TankType tankType) {
        super(tankType);
        this.setType(ObjectType.HEROTANK);
        this.isProtected = isProtected;
        this.chances = Constants.MAX_CHANCES;
    }

    public void setProtected(boolean isProtected) {
        this.isProtected = isProtected;
    }

    @Override
    public boolean changeStatus(int mode) {
        switch (mode) {
            case Constants.DEAD:
                this.setAlive(false);
                break;
            default:
                return false;
        }
        return true;
    }

    public boolean isProtected() {
        return isProtected;
    }

    //坦克被攻击
    public void beenAttacked()
    {
        this.setChances(this.getChances() - 1);
        if(this.getChances() <= 0)
            this.changeStatus(Constants.DEAD);
    }


}
