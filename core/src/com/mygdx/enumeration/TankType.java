package com.mygdx.enumeration;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.utils.Assets;

public enum TankType {
    P1HERO(0, Assets.instance.assetHeroTank.player1Up),
    P2HERO(1, Assets.instance.assetHeroTank.player2Up),
    NORMALENEMY(2, Assets.instance.assetEnemyTank.normalTankDown),
    FASTENEMY(3, Assets.instance.assetEnemyTank.fastTankDown),
    HARDENEMY(4, Assets.instance.assetEnemyTank.hardTankRedD);

    private int index;
    private TextureRegion tankRegion;

    private TankType(int index, TextureRegion tankRegion) {
        this.index = index;
        this.tankRegion = tankRegion;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public TextureRegion getTankRegion() {
        return tankRegion;
    }

    public void setTankRegion(TextureRegion tankRegion) {
        this.tankRegion = tankRegion;
    }
}
