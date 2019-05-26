package com.tank;

import java.awt.*;

public abstract class GameObjects {
    protected int x,y;

    public GameObjects(int x, int y) {
        this.x = x;
        this.y = y;
    }

    abstract void paint(Graphics graphics);
//    public abstract Rectangle getRectangle();
}
