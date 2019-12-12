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

    public class AssetBunny {
        public final TextureAtlas.AtlasRegion head;

        public AssetBunny(TextureAtlas.AtlasRegion head) {
            this.head = head;
        }
    }
}
