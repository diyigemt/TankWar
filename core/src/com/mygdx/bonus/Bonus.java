package com.mygdx.bonus;

import com.mygdx.enumeration.BonusType;
import com.mygdx.game.AbstractGameObject;
import com.mygdx.tank.HeroTank;

/**
 * 这是打败特殊坦克之后随机出现在屏幕上的额外奖励，奖励类型随机，奖励出现的位置也是随机的
 */
public abstract class Bonus extends AbstractGameObject {

    // 额外奖励类型
    private BonusType bonusType;
    // 额外奖励是否被激活
    private boolean isActive;

    // 抽象的构造函数，用来初始化isActive变量
    public Bonus() {
        this.isActive = false;
    }

    abstract public void addBuff(HeroTank heroTank);

    abstract public void removeBuff();

    public BonusType getBonusType() {
        return this.bonusType;
    }

    public void setBonusType(BonusType bonusType) {
        this.bonusType = bonusType;
    }

    /**
     * 这个是用来根据奖励类型得到奖励实例，可以实现随机得到
     * @param bonusType
     * @return Bonus 一个额外奖励实例
     */
    public static Bonus getInstance(BonusType bonusType) {
        Bonus bonus = null;
        switch (bonusType) {
            case TANK:
                bonus = new TankBonus();
                break;
            case STAR:
                bonus = new StarBonus();
                break;
            case SHOVEL:
                bonus = new ShovelBonus();
                break;
            case HELMET:
                bonus = new HelmetBonus();
                break;
            case BOOM:
                bonus = new BoomBonus();
                break;
            case CLOCK:
                bonus = new ClockBonus();
                break;
        }
        return bonus;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
