package com.mygdx.bonus;


import com.mygdx.enumeration.BonusType;
import com.mygdx.game.Constants;
import com.mygdx.tank.EnemyTank;
import com.mygdx.tank.HeroTank;
import com.mygdx.utils.Assets;

/**
 * 冻住屏幕上的所有坦克
 * 这个冻住有时间限制，要注意的是新生成的坦克也应该被冻住
 * TODO 确定冻住的时间，这个时间目前计划由BonusManager来控制
 */
public class ClockBonus extends Bonus {
    public ClockBonus() {
        super(Assets.instance.assetBonus.clock);
        this.setBonusType(BonusType.CLOCK);
        this.setDuration(Constants.CLOCK_BUFF_DURATION);
    }
    @Override
    public void addBuff(HeroTank heroTank) {
        super.addBuff(heroTank);
        EnemyTank.enemyTankManager.freezeAll();
    }

    @Override
    public void removeBuff() {
        EnemyTank.enemyTankManager.unfreezeAll();
        super.removeBuff();
    }
}
