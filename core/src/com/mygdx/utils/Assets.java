package com.mygdx.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.game.Constants;

public class Assets implements Disposable, AssetErrorListener {
    public static final String TAG = Assets.class.getName();
    // 创建一个自己的静态实例变量
    public static final Assets instance = new Assets();
    // 用来管理内部资源的实例
    private AssetManager assetManager;
    public AssetHeroTank assetHeroTank;
    public AssetEnemyTank assetEnemyTank;
    public AssetEffects assetEffects;
    public AssetGame assetGame;
    public AssetWall assetWall;
    public AssetBonus assetBonus;

    public Assets() {}

    public void init(AssetManager assetManager) {
        this.assetManager = assetManager;
        // 设置资源管理器错误处理
        this.assetManager.setErrorListener(this);
        // 加载纹理图块
        this.assetManager.load(Constants.HEROTANK_ATLAS_OBJECTS, TextureAtlas.class);
        this.assetManager.load(Constants.ENEMYTANK_ATLAS_OBJECTS, TextureAtlas.class);
        this.assetManager.load(Constants.EFFECTS_ATLAS_OBJECTS, TextureAtlas.class);
        this.assetManager.load(Constants.GAME_ATLAS_OBJECTS, TextureAtlas.class);
        this.assetManager.load(Constants.WALL_ATLAS_OBJECTS, TextureAtlas.class);
        this.assetManager.load(Constants.BONUS_ATLAS_OBJECTS, TextureAtlas.class);
        this.assetManager.finishLoading();
        Gdx.app.debug(TAG,
                "# of assets loaded: " + this.assetManager.getAssetNames().size);
        for (String a : this.assetManager.getAssetNames()) {
            Gdx.app.debug(TAG, "asset: " + a);
        }

        TextureAtlas heroTankAtlas = this.assetManager.get(Constants.HEROTANK_ATLAS_OBJECTS);
        TextureAtlas enemyTankAtlas = this.assetManager.get(Constants.ENEMYTANK_ATLAS_OBJECTS);
        TextureAtlas effectsAtlas = this.assetManager.get(Constants.EFFECTS_ATLAS_OBJECTS);
        TextureAtlas gameAtlas = this.assetManager.get(Constants.GAME_ATLAS_OBJECTS);
        TextureAtlas wallAtlas = this.assetManager.get(Constants.WALL_ATLAS_OBJECTS);
        TextureAtlas bonusAtlas = this.assetManager.get(Constants.BONUS_ATLAS_OBJECTS);
        for (Texture t : heroTankAtlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }
        for (Texture t : enemyTankAtlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }
        for (Texture t : effectsAtlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }
        for (Texture t : gameAtlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }
        for (Texture t : wallAtlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }
        for (Texture t : bonusAtlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }

        this.assetHeroTank = new AssetHeroTank(heroTankAtlas);
        this.assetEnemyTank = new AssetEnemyTank(enemyTankAtlas);
        this.assetEffects = new AssetEffects(effectsAtlas);
        this.assetGame = new AssetGame(gameAtlas);
        this.assetWall = new AssetWall(wallAtlas);
        this.assetBonus = new AssetBonus(bonusAtlas);
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

