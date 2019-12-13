package com.mygdx.bonus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.BonusType;
import com.mygdx.tank.HeroTank;
import com.mygdx.tank.Tank;

/**
 * 这个用来将坦克设为保护状态，这个保护状态也是有持续时间的
 * TODO 确定保护状态的持续时间，这个持续时间目前计划由BonusManager来控制
 */
public class HelmetBonus extends Bonus {

    // 因为这个buff的对象性，需要记录被加上刚帽的坦克
    private HeroTank acceptorTank;
    public HelmetBonus () {
        super();
        this.setBonusType(BonusType.HELMET);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

    }

    @Override
    public void addBuff(HeroTank heroTank) {
        // 标记为激活状态
        this.setActive(true);
        // 给坦克加上阻挡一次子弹的Buff
        heroTank.setProtected(true);
        this.acceptorTank = heroTank;
    }

    @Override
    public void removeBuff() {
        this.acceptorTank.setProtected(false);
        // 标记为未激活状态
        this.setActive(false);
    }
}