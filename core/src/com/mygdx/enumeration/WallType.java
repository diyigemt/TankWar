package com.mygdx.enumeration;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;

import java.io.File;

/**
 * 用来表示墙类别的枚举类
 */
public enum WallType {
    GRASS_WALL(new Pixmap(new FileHandle(""))),
    IRON_WALL(new Pixmap(new FileHandle(""))),
    BRICK_WALL(new Pixmap(new FileHandle(""))), //这里等之后填上正确的文件路径或者被资源类的方法替代
    WATER_WALL(new Pixmap(new FileHandle("")));

    private Pixmap appearance;
    /**
     * @param pixmap 不同的墙类别的图片
     */
    private WallType(Pixmap pixmap) {
        this.appearance = pixmap;
    }

    public Pixmap getAppearance() {
        return this.appearance;
    }
}
