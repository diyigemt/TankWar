package com.mygdx.bonus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.enumeration.BonusType;
import com.mygdx.enumeration.ObjectType;
import com.mygdx.game.AbstractGameObject;
import com.mygdx.game.Constants;
import com.mygdx.tank.HeroTank;

import java.util.ArrayList;

/**
 * 这是打败特殊坦克之后随机出现在屏幕上的额外奖励，奖励类型随机，奖励出现的位置也是随机的
 */
public abstract class Bonus extends AbstractGameObject {

    public static BonusManager bonusManager = new BonusManager();
    // 额外奖励类型
    private BonusType bonusType;
    // 额外奖励是否被激活
    private boolean isActive;
    // 奖励持续时间
    private float duration;

    // 抽象的构造函数，用来初始化isActive变量
    public Bonus(TextureRegion region) {
        super(region);
        this.setType(ObjectType.BONUS);
        this.isActive = false;
        this.duration = 0;
        this.setSize(Constants.BONUS_SIZE, Constants.BONUS_SIZE);
        this.setOrigin(this.getWidth() / 2.0f, this.getHeight() / 2.0f);
    }

    public void addBuff(HeroTank heroTank) {
        // 标记为激活状态
        this.setActive(true);
        bonusManager.scheduleTask(new BuffTask( this), this.duration);
    }

    public void removeBuff() {
        // 标记为未激活状态
        this.setActive(true);
        bonusManager.deleteBonus(this);
    }

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

    /**
     * 碰撞检测之后的行为函数
     *
     * @param conflicts 与该Object碰撞的Objects
     */
    @Override
    public void isCrashed(ArrayList<AbstractGameObject> conflicts) {
        for (AbstractGameObject conflict : conflicts) {
            if (conflict.getType().equals(ObjectType.HEROTANK)) {
                this.addBuff((HeroTank)conflict);
                Bonus.bonusManager.deleteBonus(this);
                break;
            }
        }
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        this.draw(spriteBatch);
    }
}
