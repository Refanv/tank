package com.mashibing.tank;

import java.awt.*;

public abstract class MoveObjects extends GameObjects {

    Dir dir;
    int SPEED;

    public MoveObjects(Dir dir, int SPEED) {
        this.dir = dir;
        this.SPEED = SPEED;
    }
    public MoveObjects(int SPEED)
    {
        this.SPEED = SPEED;
    }

    abstract int getX();
    abstract int getY();
    abstract Dir getDir();
    abstract void setX(int x);
    abstract void setY(int y);
}
