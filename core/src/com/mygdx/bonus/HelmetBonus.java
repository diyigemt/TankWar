package com.mygdx.bonus;

import com.mygdx.enumeration.BonusType;
import com.mygdx.game.Constants;
import com.mygdx.tank.HeroTank;
import com.mygdx.utils.Assets;

/**
 * 这个用来将坦克设为保护状态，这个保护状态也是有持续时间的
 * TODO 确定保护状态的持续时间，这个持续时间目前计划由BonusManager来控制
 */
public class HelmetBonus extends Bonus {

    // 因为这个buff的对象性，需要记录被加上刚帽的坦克
    private HeroTank acceptorTank;
    public HelmetBonus () {
        super(Assets.instance.assetBonus.helmet);
        this.setBonusType(BonusType.HELMET);
        this.setDuration(Constants.HELMET_BUFF_DURATION);
    }
    @Override
    public void addBuff(HeroTank heroTank) {
        super.addBuff(heroTank);
        // 给坦克加上阻挡一次子弹的Buff
        heroTank.setProtected(true);
        this.acceptorTank = heroTank;
    }

    @Override
    public void removeBuff() {
        this.acceptorTank.setProtected(false);
        super.removeBuff();
    }
}
