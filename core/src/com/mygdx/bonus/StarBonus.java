package com.mygdx.bonus;

import com.mygdx.enumeration.BonusType;
import com.mygdx.game.Constants;
import com.mygdx.tank.HeroTank;
import com.mygdx.utils.Assets;

/**
 * 这个bonus是用来使英雄坦克的子弹射速增加一段时间
 * 直接采用双倍射速方法
 * TODO 或者采用其他规则，确定持续时间
 */
public class StarBonus extends Bonus {

    // 因为这个buff的对象性，需要记录被加上刚帽的坦克
    private HeroTank acceptorTank;
    public StarBonus() {
        super(Assets.instance.assetBonus.star);
        this.setBonusType(BonusType.STAR);
        this.setDuration(Constants.STAR_BUFF_DURATION);
    }
    @Override
    public void addBuff(HeroTank heroTank) {
        super.addBuff(heroTank);
        // TODO 暂时采用直接双倍射速方法
        this.acceptorTank = heroTank;
        heroTank.setShootSpeed(2 * heroTank.getShootSpeed());
    }

    @Override
    public void removeBuff() {
        this.acceptorTank.setShootSpeed(this.acceptorTank.getMoveSpeed() / 2);
        super.removeBuff();
    }
}
