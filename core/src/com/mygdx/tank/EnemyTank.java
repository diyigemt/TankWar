package com.mygdx.tank;

import com.mygdx.game.Constants;

public class EnemyTank extends Tank {

    // 敌方坦克管理器，负责注册，查找，删除现有的敌方坦克
    public static TankManager enemyTankManager = new TankManager(Constants.ENEMYTANK_MANAGER);
    // 描述该敌方坦克是否携带有bonus
    private boolean hasBonus;
    // 描述敌方坦克是否被冰冻住
    private boolean isFrozen;

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

    public EnemyTank(boolean hasBonus) {
        super();
        this.hasBonus = hasBonus;
    }
}
