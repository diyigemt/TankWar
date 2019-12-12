package com.mygdx.bonus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.BonusType;
import com.mygdx.tank.HeroTank;

public class TankBonus extends Bonus {
    public TankBonus() {
        super();
        this.setBonusType(BonusType.TANK);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

    }

    @Override
    public void addBuff(HeroTank heroTank) {
        // 标记为激活状态
        this.setActive(true);
        // 命数+1
        heroTank.setChances(heroTank.getChances() + 1);
    }

    @Override
    public void removeBuff() {
        // 标记为未激活状态
        this.setActive(true);
    }
}
