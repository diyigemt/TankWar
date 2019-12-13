package com.mygdx.enumeration;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Constants;
import com.mygdx.utils.Assets;
import com.sun.org.apache.bcel.internal.Const;

public enum TankType {
    P1HERO(0, Assets.instance.assetHeroTank.player1Up, Constants.HEROTANK_LIFE, Constants.DEFAULT_MOVE_SPEED),
    P2HERO(1, Assets.instance.assetHeroTank.player2Up, Constants.HEROTANK_LIFE, Constants.DEFAULT_MOVE_SPEED),
    NORMALENEMY(2, Assets.instance.assetEnemyTank.normalTankDown, Constants.NORMAL_ENEMYTANK_LIFE, Constants.DEFAULT_MOVE_SPEED),
    FASTENEMY(3, Assets.instance.assetEnemyTank.fastTankDown, Constants.FAST_ENEMYTANK_LIFE, Constants.FAST_MOVE_SPEED),
    HARDENEMY(4, Assets.instance.assetEnemyTank.hardTankRedD, Constants.HARD_ENEMYTANK_LIFE, Constants.DEFAULT_MOVE_SPEED);

    private int index;
    private TextureRegion tankRegion;
    private int life;
    private float moveSpeed;

    TankType(int index, TextureRegion tankRegion, int life, float moveSpeed) {
        this.index = index;
        this.tankRegion = tankRegion;
        this.life = life;
        this.moveSpeed = moveSpeed;
    }

    public static TankType getInstance(int index) {
        for (TankType tankType : TankType.values()) {
            if (tankType.getIndex() == index) {
                return tankType;
            }
        }
        return null;
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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public float getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }
}
