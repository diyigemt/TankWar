package com.mygdx.enumeration;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;

import java.io.File;

/**
 * 用来表示墙类别的枚举类
 */
public enum WallType {
    BRICK_WALL(0),
    GRASS_WALL(1),
    IRON_WALL(2),
     //这里等之后填上正确的文件路径或者被资源类的方法替代
    WATER_WALL(3);

    private int index;

    private WallType(int index) {
        this.index = index;
    }

    public static WallType getInstance(int index) {
        for (WallType wallType : WallType.values()) {
            if (wallType.getIndex() == index) {
                return wallType;
            }
        }
        return null;
    }

    public int getIndex() {
        return this.index;
    }
}
