package com.mygdx.enumeration;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;

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
    private BonusType(int index) {
        this.index = index;
    }


}
