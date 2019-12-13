package com.mygdx.enumeration;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;

public enum TankType {
    P1HERO(0),
    P2HERO(1),
    NORMALENEMY(2),
    FASTENEMY(3),
    HARDENEMY(4);

    private int index;
    private TankType(int index) {
        this.index = index;
    }

}
