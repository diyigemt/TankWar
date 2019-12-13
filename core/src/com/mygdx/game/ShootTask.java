package com.mygdx.game;

import com.badlogic.gdx.utils.Timer;
import com.mygdx.tank.EnemyTank;

public class ShootTask extends Timer.Task {
    @Override
    public void run() {
        EnemyTank.enemyTankManager.shoot();
    }
}
