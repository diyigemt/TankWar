package com.mygdx.game;

public class Constants {
    // Visible game world is 5 meters wide
    public static final float VIEWPORT_WIDTH = 5.0f;
    // Visible game world is 5 meters tall
    public static final float VIEWPORT_HEIGHT = 5.0f;
    // Location of description file for texture atlas
    public static final String TEXTURE_ATLAS_OBJECTS =
            "images/tank.atlas";


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
    public static final float WALL_SIZE = 0.2f;

    // 默认移动速度等
    //TODO 确定移动速度
    public static final int DEFAULT_SHOOT_SPEED = 2;
    public static final int DEFAULT_MOVE_SPEED = 3;

}
