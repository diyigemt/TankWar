package com.mygdx.bonus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.BonusType;
import com.mygdx.game.AbstractGameObject;
import com.mygdx.tank.Tank;
import com.mygdx.wall.Wall;

import java.util.ArrayList;

public class BonusManager {

    // 记录的有效的Bonus的list
    private ArrayList<Bonus> bonuses;
    // 构造函数
    public BonusManager() {

    }

    // 注册创建的Bonus
    public void registerBonus(Bonus bonus) {
        this.bonuses.add(bonus);
    }

    // 创建一个Bonus实例并且注册
    public Bonus createBonus(BonusType bonusType) {
        Bonus bonus = Bonus.getInstance(bonusType);
        if (bonus != null) {
            this.registerBonus(bonus);
            return bonus;
        } else {
            System.err.println("未能成功创建一个指定类别的Bonus！");
            return null;
        }
    }

    // 删除一个Bonus
    public boolean deleteBonus(Bonus bonus) {
        if (this.bonuses.contains(bonus)) {
            this.bonuses.remove(bonus);
            return true;
        } else {
            return false;
        }
    }

    // 删除所有的bonus
    public void deleteAll() {
        this.bonuses.clear();
    }

    // 渲染所有不是活跃状态的bonus
    public void render(SpriteBatch spriteBatch) {
        for (Bonus bonus : this.bonuses) {
            if (!bonus.isActive()) {
                bonus.render(spriteBatch);
            }
        }
    }

    public ArrayList<Bonus> getBonuses() {
        return bonuses;
    }

    public void setBonuses(ArrayList<Bonus> bonuses) {
        this.bonuses = bonuses;
    }


    //坦克和buff相撞
    public static boolean checkCrash(Tank gameObject)
    {
        boolean isCrashed = false;
        for(Bonus i : Bonus.bonusManager.getBonuses())
        {
            if(i.getX() < gameObject.getX() + gameObject.getWidth() &&
                    i.getX() + i.getWidth() > gameObject.getX() &&
                    i.getY() < gameObject.getY() + gameObject.getHeight() &&
                    i.getY() + i.getHeight() > gameObject.getHeight())
            {
                i.isCrashed();
                gameObject.isCrashed();
                isCrashed = true;
            }
        }
        return isCrashed;
    }
}
