package com.mygdx.wall;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.enumeration.WallType;
import com.mygdx.game.AbstractGameObject;

import java.util.ArrayList;

/**
 * 这是用来管理Wall的Manager类，目前只设置一种，整个游戏也只会有一个静态实例
 */
public class WallManager {

    // 被管理的普通Wall的list
    private ArrayList<Wall> walls;
    // 基地周围的8块特殊的墙
    private ArrayList<Wall> baseWalls;

    public WallManager() {
        this.walls = new ArrayList<>();
    }

    // 注册创建的普通墙
    public void registerWall(Wall wall) {
        this.walls.add(wall);
        this.baseWalls = new ArrayList<>(8);
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
    public void initBase() {
        for (int i = 0; i < 8; i++) {
            Wall wall = new BrickWall();
            this.baseWalls.add(wall);
        }
    }

    // 改变基地部分的墙的状态，用于ShovelBonus的调用
    public void protectBase(boolean isProtected) {
        if (isProtected) {
            this.baseWalls.clear();
            for (int i = 0; i < 8; i++) {
                Wall wall = new IronWall();
                this.baseWalls.add(wall);
            }
        } else {
            this.baseWalls.clear();
            for (int i = 0; i < 8; i++) {
                Wall wall = new BrickWall();
                this.baseWalls.add(wall);
            }
        }
    }

    public static boolean checkCrash(AbstractGameObject gameObject)
    {
        //Wall i;
        boolean isCrashed = false;
        for(Wall i : Wall.wallManager.getWalls())
        {
            if(i.getX() < gameObject.getX() + gameObject.getWidth() &&
               i.getX() + i.getWidth() > gameObject.getX() &&
               i.getY() < gameObject.getY() + gameObject.getHeight() &&
               i.getY() + i.getHeight() > gameObject.getHeight())
            {
                i.isCrashed();
                gameObject.isCrashed();
                isCrashed = true;
            }
        }
        return isCrashed;
    }
}
