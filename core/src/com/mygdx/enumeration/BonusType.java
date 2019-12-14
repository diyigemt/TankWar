package com.mygdx.enumeration;


/**
 * 这是用来表示Buff种类的枚举类
 */
public enum BonusType {
    TANK(0),
    STAR(1),
    SHOVEL(2),
    HELMET(3),
    BOOM(4),
    CLOCK(5);
    private int index;

    /**
     *
     * @param index 用来为不同种类的Buff设置图片
     */
    BonusType(int index) {
        this.index = index;
    }

    public static BonusType getInstance(int index) {
        for (BonusType bonusType : BonusType.values()) {
            if (bonusType.getIndex() == index) {
                return bonusType;
            }
        }
        return null;
    }

    public int getIndex() {
        return index;
    }

}
