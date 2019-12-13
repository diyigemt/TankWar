package com.mygdx.utils;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetHeroTank {
    public final TextureAtlas.AtlasRegion player1Up;
    public final TextureAtlas.AtlasRegion player1Down;
    public final TextureAtlas.AtlasRegion player1Right;
    public final TextureAtlas.AtlasRegion player1Left;
    public final TextureAtlas.AtlasRegion player2Up;
    public final TextureAtlas.AtlasRegion player2Down;
    public final TextureAtlas.AtlasRegion player2Right;
    public final TextureAtlas.AtlasRegion player2Left;

    public AssetHeroTank(TextureAtlas atlas) {
        this.player1Up = atlas.findRegion("p1tankU");
        this.player1Down = atlas.findRegion("p1tankD");
        this.player1Right = atlas.findRegion("p1tankR");
        this.player1Left = atlas.findRegion("p1tankL");
        this.player2Up = atlas.findRegion("p2tankU");
        this.player2Down = atlas.findRegion("p2tankD");
        this.player2Right = atlas.findRegion("p2tankR");
        this.player2Left = atlas.findRegion("p2tankL");
    }
}
