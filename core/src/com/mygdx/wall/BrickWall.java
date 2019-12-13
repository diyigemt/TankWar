package com.mygdx.wall;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.WallType;
import com.mygdx.personal_interface.Destroyable;

public class BrickWall extends Wall implements Destroyable {

    public static Texture appearance = new Texture(Gdx.files.internal("images/1.jpg"));
    public BrickWall(float x, float y) {
        this();
        this.setPosition(x, y);
        this.setX(x);
        this.setY(y);
        this.setLife(100);
    }

    public BrickWall() {
        super(appearance);
        this.setWallType(WallType.BRICK_WALL);
//        Texture texture = new Texture(this.getWallType().getAppearance());
//        int srcWidth = texture.getWidth();
//        int srcHeight = texture.getHeight();
//        this.setTexture(texture);
//        this.setRegion(0, 0, srcWidth, srcHeight);
//        this.setColor(1.0F, 1.0F, 1.0F, 1.0F);
//        this.setSize((float)Math.abs(srcWidth), (float)Math.abs(srcHeight));
//        this.setOrigin(this.getRegionWidth() / 2.0F, this.getRegionHeight() / 2.0F);
//        this.setTexture(appearance);
        this.setSize(1, 1);

}

    @Override
    public void destroy() {

    }

//    @Override
//    public void render(SpriteBatch spriteBatch) {
//
//    }

    @Override
    public void beenAttacked(int hit)
    {
        return;
    }
}
