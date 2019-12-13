package com.mygdx.game;

public class Constants {
    // Visible game world is 5 meters wide
    public static final float VIEWPORT_WIDTH = 18.0f;
    // Visible game world is 5 meters tall
    public static final float VIEWPORT_HEIGHT = 18.0f;
    // Location of description file for texture atlas
    public static final String HEROTANK_ATLAS_OBJECTS = "images/HeroTank.atlas";
    public static final String ENEMYTANK_ATLAS_OBJECTS = "images/EnemyTank.atlas";
    public static final String EFFECTS_ATLAS_OBJECTS = "images/effects.atlas";
    public static final String BONUS_ATLAS_OBJECTS = "images/Bonus.atlas";
    public static final String GAME_ATLAS_OBJECTS = "images/game.atlas";
    public static final String WALL_ATLAS_OBJECTS = "images/Wall.atlas";



    // 坦克管理器类别，0为英雄坦克，1为敌方坦克
    public static final int HEROTANK_MANAGER = 0;
    public static final int ENEMYTANK_MANAGER = 1;

    // 坦克类的changeStatus()参数
    public static final int DEAD = 0;
    public static final int FREEZE = 1;
    public static final int UNFREEZE = 2;

    // 玩家坦克的最大命数
    public static final int MAX_CHANCES = 4;


    //墙
    public static final float WALL_SIZE = 0.5f;

    // 默认移动速度等
    //TODO 确定移动速度
    public static final int DEFAULT_SHOOT_SPEED = 2;
    public static final int DEFAULT_MOVE_SPEED = 3;

    // 游戏窗口的设置常量
    public static final int WINDOW_WIDTH = 900;
    public static final int WINDOW_HEIGHT = 900;
    public static final String WINDOW_TITLE = "TankWar";

    //地图坐标平移
    public static final float MAP_TRANSLATION_X = -2.5f;
    public static final float MAP_TRANSLATION_Y = 0.0f;

    //方向
    public static enum DIRECT{
        NORTH,SOUTH,WEST,EAST
    }
}
