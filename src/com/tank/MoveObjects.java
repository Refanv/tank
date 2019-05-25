package com.tank;

import java.awt.*;

public abstract class MoveObjects extends GameObjects {

    int x, y;
    Dir dir;
    Rectangle rectangle;
    int SPEED;

    public MoveObjects(int speed) {
        this.SPEED = speed;
    }

    public abstract Rectangle getRectangle();

    abstract int getX();

    abstract int getY();

    abstract Dir getDir();

    abstract void setX(int x);

    abstract void setY(int y);
}
