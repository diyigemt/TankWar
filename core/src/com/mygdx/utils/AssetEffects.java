package com.mygdx.utils;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetEffects {
    public final TextureAtlas.AtlasRegion blast1;
    public final TextureAtlas.AtlasRegion blast2;
    public final TextureAtlas.AtlasRegion blast3;
    public final TextureAtlas.AtlasRegion blast4;
    public final TextureAtlas.AtlasRegion blast5;
    public final TextureAtlas.AtlasRegion blast6;
    public final TextureAtlas.AtlasRegion blast7;
    public final TextureAtlas.AtlasRegion blast8;
    public final TextureAtlas.AtlasRegion born1;
    public final TextureAtlas.AtlasRegion born2;
    public final TextureAtlas.AtlasRegion born3;
    public final TextureAtlas.AtlasRegion born4;

    public AssetEffects(TextureAtlas atlas) {
        this.blast1 = atlas.findRegion("blast1");
        this.blast2 = atlas.findRegion("blast2");
        this.blast3 = atlas.findRegion("blast3");
        this.blast4 = atlas.findRegion("blast4");
        this.blast5 = atlas.findRegion("blast5");
        this.blast6 = atlas.findRegion("blast6");
        this.blast7 = atlas.findRegion("blast7");
        this.blast8 = atlas.findRegion("blast8");
        this.born1 = atlas.findRegion("born1");
        this.born2 = atlas.findRegion("born2");
        this.born3 = atlas.findRegion("born3");
        this.born4 = atlas.findRegion("born4");
    }
}
