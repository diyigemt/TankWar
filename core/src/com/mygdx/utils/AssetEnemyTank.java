package com.mygdx.utils;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetEnemyTank {
    public final TextureAtlas.AtlasRegion normalTankUp;
    public final TextureAtlas.AtlasRegion normalTankDown;
    public final TextureAtlas.AtlasRegion normalTankRight;
    public final TextureAtlas.AtlasRegion normalTankLeft;
    public final TextureAtlas.AtlasRegion fastTankUp;
    public final TextureAtlas.AtlasRegion fastTankDown;
    public final TextureAtlas.AtlasRegion fastTankRight;
    public final TextureAtlas.AtlasRegion fastTankLeft;
    public final TextureAtlas.AtlasRegion hardTankYellowU;
    public final TextureAtlas.AtlasRegion hardTankYellowD;
    public final TextureAtlas.AtlasRegion hardTankYellowR;
    public final TextureAtlas.AtlasRegion hardTankYellowL;
    public final TextureAtlas.AtlasRegion hardTankGreyU;
    public final TextureAtlas.AtlasRegion hardTankGreyD;
    public final TextureAtlas.AtlasRegion hardTankGreyR;
    public final TextureAtlas.AtlasRegion hardTankGreyL;
    public final TextureAtlas.AtlasRegion hardTankBlueU;
    public final TextureAtlas.AtlasRegion hardTankBlueD;
    public final TextureAtlas.AtlasRegion hardTankBlueR;
    public final TextureAtlas.AtlasRegion hardTankBlueL;
    public final TextureAtlas.AtlasRegion hardTankRedU;
    public final TextureAtlas.AtlasRegion hardTankRedD;
    public final TextureAtlas.AtlasRegion hardTankRedR;
    public final TextureAtlas.AtlasRegion hardTankRedL;

    public AssetEnemyTank(TextureAtlas atlas) {
        this.normalTankUp = atlas.findRegion("enemy1U");
        this.normalTankDown = atlas.findRegion("enemy1D");
        this.normalTankRight = atlas.findRegion("enemy1R");
        this.normalTankLeft = atlas.findRegion("enemy1L");
        this.fastTankUp = atlas.findRegion("enemy2U");
        this.fastTankDown = atlas.findRegion("enemy2D");
        this.fastTankRight = atlas.findRegion("enemy2R");
        this.fastTankLeft = atlas.findRegion("enemy2L");
        this.hardTankYellowU = atlas.findRegion("enemy3U");
        this.hardTankYellowD = atlas.findRegion("enemy3D");
        this.hardTankYellowR = atlas.findRegion("enemy3R");
        this.hardTankYellowL = atlas.findRegion("enemy3L");
        this.hardTankGreyU = atlas.findRegion("enemy4U");
        this.hardTankGreyD = atlas.findRegion("enemy4D");
        this.hardTankGreyR = atlas.findRegion("enemy4R");
        this.hardTankGreyL = atlas.findRegion("enemy4L");
        this.hardTankBlueU = atlas.findRegion("enemy5U");
        this.hardTankBlueD = atlas.findRegion("enemy5D");
        this.hardTankBlueR = atlas.findRegion("enemy5R");
        this.hardTankBlueL = atlas.findRegion("enemy5L");
        this.hardTankRedU = atlas.findRegion("enemy6U");
        this.hardTankRedD = atlas.findRegion("enemy6D");
        this.hardTankRedR = atlas.findRegion("enemy6R");
        this.hardTankRedL = atlas.findRegion("enemy6L");
    }
}
