package com.mygdx.bonus;

import com.badlogic.gdx.utils.Timer;

public class BuffTask extends Timer.Task {
    // 要设置为Task的Bonus
    private Bonus bonus;
    public BuffTask(Bonus bonus) {
        this.bonus = bonus;
    }

    @Override
    public void run() {
        this.bonus.removeBuff();
    }
}
