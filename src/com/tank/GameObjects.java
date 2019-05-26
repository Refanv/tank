package com.tank;

import java.awt.*;

public abstract class GameObjects {
    protected int x,y;
    protected int width, height;
    protected boolean display = true;

    public GameObjects(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void init_GO_W_H(int w, int h){
        width = w;
        height = h;
    }

    public abstract void paint(Graphics graphics);

    public boolean isDisplay() {
        return display;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight() {
        return height;
    }
}
