package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.utils.Assets;

public class Bullet extends AbstractGameObject {


    public Bullet() {
        super(Assets.instance.assetGame.bullet);
    }

    @Override
    public void render(SpriteBatch spriteBatch) {

    }
}
