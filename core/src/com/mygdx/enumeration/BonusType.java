package com.mygdx.enumeration;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;

/**
 * 这是用来表示Buff种类的枚举类
 */
public enum BonusType {
    TANK(new Pixmap(new FileHandle(""))),
    STAR(new Pixmap(new FileHandle(""))),
    SHOVEL(new Pixmap(new FileHandle(""))),
    HELMET(new Pixmap(new FileHandle(""))),
    BOOM(new Pixmap(new FileHandle(""))),
    CLOCK(new Pixmap(new FileHandle("")));
    private Pixmap appearance;

    /**
     *
     * @param pixmap 用来为不同种类的Buff设置图片
     */
    private BonusType(Pixmap pixmap) {
        this.appearance = pixmap;
    }

    public Pixmap getAppearance() {
        return this.appearance;
    }
}
