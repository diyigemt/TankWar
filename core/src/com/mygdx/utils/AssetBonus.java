package com.mygdx.utils;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetBonus {
    public final TextureAtlas.AtlasRegion boom;
    public final TextureAtlas.AtlasRegion clock;
    public final TextureAtlas.AtlasRegion helmet;
    public final TextureAtlas.AtlasRegion shovel;
    public final TextureAtlas.AtlasRegion star;
    public final TextureAtlas.AtlasRegion tankBonus;

    public AssetBonus(TextureAtlas atlas) {
        this.boom = atlas.findRegion("boom");
        this.clock = atlas.findRegion("clock");
        this.helmet = atlas.findRegion("helmet");
        this.shovel = atlas.findRegion("shovel");
        this.star = atlas.findRegion("star");
        this.tankBonus = atlas.findRegion("tank");
    }

}
