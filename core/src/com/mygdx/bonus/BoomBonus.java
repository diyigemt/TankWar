package com.mygdx.bonus;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.BonusType;
import com.mygdx.tank.EnemyTank;
import com.mygdx.tank.HeroTank;

public class BoomBonus extends Bonus {
    public BoomBonus() {
        super();
        this.setBonusType(BonusType.BOOM);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

    }

    @Override
    public void addBuff(HeroTank heroTank) {
        // 标记为激活状态
        this.setActive(true);
        EnemyTank.enemyTankManager.deleteAll();
    }

    // 因为这个Bonus的一次性，这个Bonus的removeBuff方法什么都不做
    @Override
    public void removeBuff() {
        // 标记为未激活状态
        this.setActive(true);
    }
}
