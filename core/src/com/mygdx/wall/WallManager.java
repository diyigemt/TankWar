package com.mygdx.wall;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.ObjectType;
import com.mygdx.enumeration.WallType;
import com.mygdx.game.AbstractGameObject;
import com.mygdx.game.Constants;
import com.mygdx.game.MyGdxGame;
import com.mygdx.utils.Assets;

import java.util.ArrayList;

/**
 * 这是用来管理Wall的Manager类，目前只设置一种，整个游戏也只会有一个静态实例
 */
public class WallManager {
    // 基地
    private BrickWall base;
    // 被管理的普通Wall的list
    private ArrayList<Wall> walls;
    // 基地周围的8块特殊的墙
    private ArrayList<Wall> baseWalls;

    private static boolean baseState;

    public WallManager() {
        this.walls = new ArrayList<>();
        this.baseWalls = new ArrayList<>(8);
        //初始化基地
        this.base = new BrickWall(Assets.instance.assetGame.symbol, -0.5f + Constants.MAP_TRANSLATION_X, -6.5f + Constants.MAP_TRANSLATION_Y);
        this.base.setSize(Constants.WALL_SIZE * 2,Constants.WALL_SIZE * 2);
        this.baseState = true;
        this.initBaseWall(WallType.BRICK_WALL);
    }

    // 注册创建的普通墙
    public void registerWall(Wall wall) {
        this.walls.add(wall);
    }

    // 根据类别创建一个墙的实例并进行注册
    public Wall createWall(WallType wallType) {
        // 创建实例
        Wall wall = Wall.getInstance(wallType);
        // 如果不为空，注册
        if (wall != null) {
            this.registerWall(wall);
            return wall;
        } else {
            System.err.println("未能成功创建一个指定类别的墙实例！");
            return null;
        }
    }

    public Wall createWall(WallType wallType, float x, float y) {
        // 创建实例
        Wall wall = Wall.getInstance(wallType);
        wall.setX(x);
        wall.setY(y);
        // 如果不为空，注册
        if (wall != null) {
            this.registerWall(wall);
            return wall;
        } else {
            System.err.println("未能成功创建一个指定类别的墙实例！");
            return null;
        }
    }

    public ArrayList<Wall> getBaseWalls()
    {
        return this.baseWalls;
    }
    // 删除一个普通墙
    public boolean deleteWall(Wall wall) {
        if (this.walls.contains(wall)) {
            this.walls.remove(wall);
            return true;
        } else {
            return false;
        }
    }

    // 删除所有的墙
    public void deleteAll() {
        this.walls.clear();
    }

    // 渲染所有的墙
    public void render(SpriteBatch spriteBatch) {
        //渲染基地
        this.base.render(spriteBatch);
        // 渲染基地部分的墙
        for (Wall wall : this.baseWalls) {
            wall.render(spriteBatch);
        }
        // 渲染普通的墙
        for (Wall wall : this.walls) {
            wall.render(spriteBatch);
        }
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }

    public void setWalls(ArrayList<Wall> walls) {
        this.walls = walls;
    }

    // 创建基地部分的墙
    public void initBaseWall(WallType wallType) {
        if (wallType == WallType.BRICK_WALL) {
            this.baseWalls.add(new BrickWall(-1.0f + Constants.MAP_TRANSLATION_X, -6.5f + Constants.MAP_TRANSLATION_Y));
            this.baseWalls.add(new BrickWall(-1.0f + Constants.MAP_TRANSLATION_X, -6.0f + Constants.MAP_TRANSLATION_Y));
            this.baseWalls.add(new BrickWall(-1.0f + Constants.MAP_TRANSLATION_X, -5.5f + Constants.MAP_TRANSLATION_Y));
            this.baseWalls.add(new BrickWall(-0.5f + Constants.MAP_TRANSLATION_X, -5.5f + Constants.MAP_TRANSLATION_Y));
            this.baseWalls.add(new BrickWall(0.0f + Constants.MAP_TRANSLATION_X, -5.5f + Constants.MAP_TRANSLATION_Y));
            this.baseWalls.add(new BrickWall(0.5f + Constants.MAP_TRANSLATION_X, -5.5f + Constants.MAP_TRANSLATION_Y));
            this.baseWalls.add(new BrickWall(0.5f + Constants.MAP_TRANSLATION_X, -6.0f + Constants.MAP_TRANSLATION_Y));
            this.baseWalls.add(new BrickWall(0.5f + Constants.MAP_TRANSLATION_X, -6.5f + Constants.MAP_TRANSLATION_Y));
        }
        if (wallType == WallType.IRON_WALL) {
            this.baseWalls.add(new IronWall(-1.0f + Constants.MAP_TRANSLATION_X, -6.5f + Constants.MAP_TRANSLATION_Y));
            this.baseWalls.add(new IronWall(-1.0f + Constants.MAP_TRANSLATION_X, -6.0f + Constants.MAP_TRANSLATION_Y));
            this.baseWalls.add(new IronWall(-1.0f + Constants.MAP_TRANSLATION_X, -5.5f + Constants.MAP_TRANSLATION_Y));
            this.baseWalls.add(new IronWall(-0.5f + Constants.MAP_TRANSLATION_X, -5.5f + Constants.MAP_TRANSLATION_Y));
            this.baseWalls.add(new IronWall(0.0f + Constants.MAP_TRANSLATION_X, -5.5f + Constants.MAP_TRANSLATION_Y));
            this.baseWalls.add(new IronWall(0.5f + Constants.MAP_TRANSLATION_X, -5.5f + Constants.MAP_TRANSLATION_Y));
            this.baseWalls.add(new IronWall(0.5f + Constants.MAP_TRANSLATION_X, -6.0f + Constants.MAP_TRANSLATION_Y));
            this.baseWalls.add(new IronWall(0.5f + Constants.MAP_TRANSLATION_X, -6.5f + Constants.MAP_TRANSLATION_Y));
        }
    }

    // 改变基地部分的墙的状态，用于ShovelBonus的调用
    public void protectBase(boolean isProtected) {
        if (isProtected) {
            this.baseWalls.clear();
            initBaseWall(WallType.IRON_WALL);
        } else {
            this.baseWalls.clear();
            initBaseWall(WallType.BRICK_WALL);
        }
    }

    //返回和东西相撞的墙
    public static ArrayList<AbstractGameObject> checkCrash(AbstractGameObject gameObject)
    {
        ArrayList<AbstractGameObject>crashWall = new ArrayList<AbstractGameObject>();
        for(Wall wall : Wall.wallManager.getWalls())
        {
            if(wall.getX() < gameObject.getX() + gameObject.getWidth() &&
                    wall.getX() + wall.getWidth() > gameObject.getX() &&
                    wall.getY() < gameObject.getY() + gameObject.getHeight() &&
                    wall.getY() + wall.getHeight() > gameObject.getY())
            {
                crashWall.add(wall);
            }
        }
        for(Wall wall : Wall.wallManager.getBaseWalls())
        {
            if(wall.getX() < gameObject.getX() + gameObject.getWidth() &&
                    wall.getX() + wall.getWidth() > gameObject.getX() &&
                    wall.getY() < gameObject.getY() + gameObject.getHeight() &&
                    wall.getY() + wall.getHeight() > gameObject.getY())
            {
                crashWall.add(wall);
            }
        }
        Wall wall = Wall.wallManager.base;
        if(wall.getX() < gameObject.getX() + gameObject.getWidth() &&
                wall.getX() + wall.getWidth() > gameObject.getX() &&
                wall.getY() < gameObject.getY() + gameObject.getHeight() &&
                wall.getY() + wall.getHeight() > gameObject.getY())
        {
            if(gameObject.getType().equals(ObjectType.BULLET))
                MyGdxGame.isOver=true;
        }

        if (Wall.wallManager.getBaseWalls().contains(crashWall)) {
            baseState = false;
        }
        return crashWall;
    }

    public static boolean getBaseState() {
        return baseState;
    }

    public static void setBaseState(boolean newState) {
        baseState = newState;
    }
}
