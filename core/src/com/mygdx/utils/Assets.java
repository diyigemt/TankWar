package com.mygdx.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.Constants;

public class Assets implements Disposable, AssetErrorListener {
    public static final String TAG = Assets.class.getName();
    // 创建一个自己的静态实例变量
    public static final Assets instance = new Assets();
    // 用来管理内部资源的实例
    private AssetManager assetManager;

    public Assets() {
    }

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        // 设置资源管理器错误处理
        this.assetManager.setErrorListener(this);
        // 加载纹理图块
        this.assetManager.load(Constants.TEXTURE_ATLAS_OBJECTS, TextureAtlas.class);
        this.assetManager.finishLoading();
        Gdx.app.debug(TAG,
                "# of assets loaded: " + this.assetManager.getAssetNames().size);
        for (String a : this.assetManager.getAssetNames()) {
            Gdx.app.debug(TAG, "asset: " + a);
        }
    }

    @Override
    public void error(AssetDescriptor assetDescriptor, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset '" + assetDescriptor.fileName + "'",
                (Exception) throwable);
    }

    @Override
    public void dispose() {
        this.assetManager.dispose();
    }






}

class AssetHeroTank {
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

class AssetBonus {
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

class AssetEnemyTank {
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

class AssetWall {
    public final TextureAtlas.AtlasRegion grass;
    public final TextureAtlas.AtlasRegion iron;
    public final TextureAtlas.AtlasRegion brick;
    public final TextureAtlas.AtlasRegion water;

    public AssetWall(TextureAtlas atlas) {
        this.grass = atlas.findRegion("grass");
        this.iron = atlas.findRegion("steel");
        this.brick = atlas.findRegion("mud");
        this.water = atlas.findRegion("water");
    }
}

class AssetEffects {
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

class AssetGame {
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
