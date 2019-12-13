package com.mygdx.bonus;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.BonusType;
import com.mygdx.tank.EnemyTank;
import com.mygdx.tank.HeroTank;

/**
 * 冻住屏幕上的所有坦克
 * 这个冻住有时间限制，要注意的是新生成的坦克也应该被冻住
 * TODO 确定冻住的时间，这个时间目前计划由BonusManager来控制
 */
public class ClockBonus extends Bonus {
    public ClockBonus() {
        super();
        this.setBonusType(BonusType.CLOCK);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

    }

    @Override
    public void addBuff(HeroTank heroTank) {
        // 标记为激活状态
        this.setActive(true);
        EnemyTank.enemyTankManager.freezeAll();
    }

    @Override
    public void removeBuff() {
        EnemyTank.enemyTankManager.unfreezeAll();
        // 标记为未激活状态
        this.setActive(true);
    }
}