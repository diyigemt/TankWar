package com.mygdx.bonus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.BonusType;
import com.mygdx.tank.HeroTank;
import com.mygdx.utils.Assets;

public class TankBonus extends Bonus {
    public TankBonus() {
        super(Assets.instance.assetBonus.tankBonus);
        this.setBonusType(BonusType.TANK);
    }
    @Override
    public void addBuff(HeroTank heroTank) {
        super.addBuff(heroTank);
        // 命数+1
        heroTank.setChances(heroTank.getChances() + 1);
    }
}
