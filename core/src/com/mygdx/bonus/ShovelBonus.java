package com.mygdx.bonus;

import com.mygdx.enumeration.BonusType;
import com.mygdx.game.Constants;
import com.mygdx.tank.HeroTank;
import com.mygdx.utils.Assets;
import com.mygdx.wall.Wall;

/**
 * 这个bonus使用来将基地周围还没有被打掉的墙转换成钢墙，钢墙不能够被打破
 * TODO 确定变成钢墙的持续时间，这个持续时间目前暂定由BonusManager来掌控
 */
    public class ShovelBonus extends Bonus {
        public ShovelBonus() {
            super(Assets.instance.assetBonus.shovel);
            this.setBonusType(BonusType.SHOVEL);
            this.setDuration(Constants.SHOVEL_BUFF_DURATION);
        }
    @Override
    public void addBuff(HeroTank heroTank) {
        super.addBuff(heroTank);
        // TODO 保护基地，目前定用WallManager进行逻辑上的保护
        Wall.wallManager.protectBase(true);
    }

    @Override
    public void removeBuff() {
        Wall.wallManager.protectBase(false);
        super.removeBuff();
    }
}
