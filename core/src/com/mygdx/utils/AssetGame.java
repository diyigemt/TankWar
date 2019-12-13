package com.mygdx.utils;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetGame {
    public final TextureAtlas.AtlasRegion symbol;
    public final TextureAtlas.AtlasRegion bullet;
    public final TextureAtlas.AtlasRegion over;
    public final TextureAtlas.AtlasRegion selectTank;
    public final TextureAtlas.AtlasRegion destroy;

    public AssetGame(TextureAtlas atlas) {
        this.symbol = atlas.findRegion("symbol");
        this.bullet = atlas.findRegion("tankmissile");
        this.over = atlas.findRegion("over");
        this.selectTank = atlas.findRegion("selecttank");
        this.destroy = atlas.findRegion("destroy");
    }
}
