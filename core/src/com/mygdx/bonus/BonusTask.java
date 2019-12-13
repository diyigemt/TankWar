package com.mygdx.bonus;

import com.badlogic.gdx.utils.Timer;

public class BonusTask extends Timer.Task {

    // 要设置为Task的Bonus
    private Bonus bonus;
    public BonusTask(Bonus bonus) {
        this.bonus = bonus;
    }

    @Override
    public void run() {
        this.bonus.removeBuff();
    }
}
