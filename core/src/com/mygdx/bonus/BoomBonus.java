package com.mygdx.bonus;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.BonusType;
import com.mygdx.tank.EnemyTank;
import com.mygdx.tank.HeroTank;
import com.mygdx.utils.Assets;

public class BoomBonus extends Bonus {
    public BoomBonus() {
        super(Assets.instance.assetBonus.boom);
        this.setBonusType(BonusType.BOOM);
    }

    @Override
    public void addBuff(HeroTank heroTank) {
        super.addBuff(heroTank);
        EnemyTank.enemyTankManager.deleteAll();
    }

}
