package com.mygdx.utils;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetWall {
    public final TextureAtlas.AtlasRegion grass;
    public final TextureAtlas.AtlasRegion iron;
    public final TextureAtlas.AtlasRegion brick;
    public final TextureAtlas.AtlasRegion water;

    public AssetWall(TextureAtlas atlas) {
        this.grass = atlas.findRegion("grass");
        this.iron = atlas.findRegion("steel");
        this.brick = atlas.findRegion("walls");
        this.water = atlas.findRegion("water");
    }
}
