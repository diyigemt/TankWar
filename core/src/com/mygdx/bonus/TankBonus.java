package com.mygdx.bonus;

import com.mygdx.enumeration.BonusType;
import com.mygdx.game.Constants;
import com.mygdx.tank.HeroTank;
import com.mygdx.utils.Assets;

public class TankBonus extends Bonus {
    public TankBonus() {
        super(Assets.instance.assetBonus.tankBonus);
        this.setBonusType(BonusType.TANK);
        this.setDuration(Constants.TANK_BUFF_DURATION);
    }
    @Override
    public void addBuff(HeroTank heroTank) {
        super.addBuff(heroTank);
        // 命数+1
        heroTank.setChances(heroTank.getChances() + 1);
    }
}
