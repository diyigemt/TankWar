package com.mygdx.game;

import com.badlogic.gdx.utils.Timer;
import com.mygdx.enumeration.TankType;
import com.mygdx.tank.EnemyTank;

import java.util.Random;

public class EnemyTankGenerator extends Timer.Task {
    @Override
    public void run() {
        boolean hasBonus = false;
        Random random = new Random();
        int randomNum = random.nextInt(10) + 1;
        // 十分之三的概率带有额外奖励
        if (randomNum > 7) {
            hasBonus = true;
        }
        TankType tankType = TankType.getInstance(randomNum % 3 + 2);
        EnemyTank enemyTank = new EnemyTank(hasBonus, tankType);
        EnemyTank.enemyTankManager.registerTank(enemyTank);
        enemyTank.setSize(Constants.TANK_SIZE, Constants.TANK_SIZE);
        enemyTank.setPosition(0, -6.5f);
        // TODO
    }
}
