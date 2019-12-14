package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.bonus.Bonus;
import com.mygdx.bonus.BonusManager;
import com.mygdx.enumeration.TankType;
import com.mygdx.map.MapGenerator;
import com.mygdx.tank.EnemyTank;
import com.mygdx.tank.HeroTank;
import com.mygdx.tank.TankManager;
import com.mygdx.wall.Wall;
import com.mygdx.wall.WallManager;

import java.util.ArrayList;

public class WorldController extends InputAdapter {
    private static final String TAG = WorldController.class.getName();
    //地图生成器
    private final MapGenerator generator = new MapGenerator();
    public Sprite[] testSprites;
    public int selectedSprite;
    private WallManager wallManager = Wall.wallManager;
    private BonusManager bonusManager = Bonus.bonusManager;
    private TankManager heroTankManger = HeroTank.heroTankManager;
    private TankManager enemyTankManger = EnemyTank.enemyTankManager;
    private ArrayList<Bullet> bullets = Bullet.getBullets();
    private HeroTank heroTank;
    private Game game;
    private int mapId;
    //墙

    public WorldController(Game game) {
        this.game = game;
    }

    private void WallInit()
    {
        this.generator.generate(mapId);
    }


    private void TankInit()
    {
        this.heroTank = new HeroTank(false, TankType.P1HERO);
        this.heroTank.setSize(Constants.TANK_SIZE,Constants.TANK_SIZE);
        this.heroTank.setPosition(Constants.MAP_TRANSLATION_X + -2.5f, Constants.MAP_TRANSLATION_Y + -6.5f);
        HeroTank.heroTankManager.registerTank(this.heroTank);
        addEnemyTank(-9, 0);
        addEnemyTank(3,0);
    }

    private void addEnemyTank(float x, float y)
    {
        EnemyTank tank = new EnemyTank(true, TankType.HARDENEMY);
        tank.setSize(Constants.TANK_SIZE,Constants.TANK_SIZE);
        tank.setPosition(x,y);
        this.enemyTankManger.registerTank(tank);
    }
    private void init() {
        this.initTestObjects();
        this.WallInit();
        this.TankInit();
    }

    private void initTestObjects() {
        /*
        // Create new array for 5 sprites
        testSprites = new Sprite[5];
        // Create empty POT-sized Pixmap with 8 bit RGBA pixel data
        int width = 32;
        int height = 32;
        Pixmap pixmap = createProceduralPixmap(width, height);
        // Create a new texture from pixmap data
        Texture texture = new Texture(pixmap);
        // Create new sprites using the just created texture
        for (int i = 0; i < testSprites.length; i++) {
            Sprite spr = new Sprite(texture);
            // Define sprite size to be 1m x 1m in game world
            spr.setSize(1, 1);
            // Set origin to sprite's center
            spr.setOrigin(spr.getWidth() / 2.0f, spr.getHeight() / 2.0f);
            // Calculate random position for sprite
            float randomX = MathUtils.random(-2.0f, 2.0f);
            float randomY = MathUtils.random(-2.0f, 2.0f);
            spr.setPosition(randomX, randomY);
            // Put new sprite into array
            testSprites[i] = spr;
            // Set first sprite as selected one
            selectedSprite = 0;
        }
        //Bonus bonus = Bonus.bonusManager.createBonus(BonusType.BOOM, 3, 3);
        //bonus.addBuff(new HeroTank(false));
        */

    }

    // 自定义的创建以一个像素图的方法，在这里是画一个箱子
    private Pixmap createProceduralPixmap(int width, int height) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        // Fill square with red color at 50% opacity
        pixmap.setColor(1, 0, 0, 0.5f);
        pixmap.fill();
        // Draw a yellow-colored X shape on square
        pixmap.setColor(1, 1, 0, 1);
        pixmap.drawLine(0, 0, width, height);
        pixmap.drawLine(width, 0, 0, height);
        // Draw a cyan-colored border around square
        pixmap.setColor(0, 1, 1, 1);
        pixmap.drawRectangle(0, 0, width, height);
        return pixmap;
    }

    public void update(float deltaTime) {
        handleDebugInput(deltaTime);
        this.updateBullet();
        this.tankAI();
        this.updateTestObjects(deltaTime);
    }

    private void updateBullet()
    {
        int i;
        for(i=0;i<this.bullets.size();i++)
        {
            this.bullets.get(i).move();
            this.bullets.get(i).checkCrash();
        }
    }

    private void tankAI()
    {
        int i;
        for(i=0;i<this.enemyTankManger.getTanks().size();i++)
        {
            ((EnemyTank)this.enemyTankManger.getTanks().get(i)).move();
        }
    }
    private void handleDebugInput(float deltaTime) {
        if (Gdx.app.getType() != Application.ApplicationType.Desktop)
            return;
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            this.heroTankManger.getTanks().get(0).moveTank(Constants.DIRECT.WEST);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            this.heroTankManger.getTanks().get(0).moveTank(Constants.DIRECT.EAST);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            this.heroTankManger.getTanks().get(0).moveTank(Constants.DIRECT.NORTH);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            this.heroTankManger.getTanks().get(0).moveTank(Constants.DIRECT.SOUTH);
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.J)) {
            this.heroTankManger.getTanks().get(0).shoot();
        }

    }

    private void moveSelectedSprite(float x, float y) {
        testSprites[selectedSprite].translate(x, y);
    }

    private void updateTestObjects(float deltaTime) {
        // Get current rotation from selected sprite
        //float rotation = testSprites[selectedSprite].getRotation();
        // Rotate sprite by 90 degrees per second
        //rotation += 90 * deltaTime;
        // Wrap around at 360 degrees
        //rotation %= 360;
        // Set new rotation value to selected sprite
        //testSprites[selectedSprite].setRotation(rotation);
    }

    public void setMap(int mapId) {
        this.mapId = mapId;
        Wall.wallManager.deleteAll();
        HeroTank.heroTankManager.deleteAll();
        EnemyTank.enemyTankManager.deleteAll();
        EnemyTank.enemyTankManager.generateTank();
        Bonus.bonusManager.deleteAll();
        this.init();
    }

}
