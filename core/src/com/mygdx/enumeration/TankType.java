package com.mygdx.enumeration;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;

public enum TankType {
    P1HERO(new Pixmap(new FileHandle(""))),
    P2HERO(new Pixmap(new FileHandle(""))),
    NORMALENEMY(new Pixmap(new FileHandle(""))),
    FASTENEMY(new Pixmap(new FileHandle(""))),
    HARDENEMY(new Pixmap(new FileHandle("")));

    private Pixmap appearance;
    private TankType(Pixmap appearance) {
        this.appearance = appearance;
    }

    public Pixmap getAppearance() {
        return this.appearance;
    }

    public void setAppearance(Pixmap appearance) {
        this.appearance = appearance;
    }
}
