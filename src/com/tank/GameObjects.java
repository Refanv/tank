package com.tank;

import java.awt.*;

public abstract class GameObjects {
    protected int x,y;
    protected int width, height;

    public GameObjects(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void initGO_rect(int w, int h){
        width = w;
        height = h;
    }
    abstract void paint(Graphics graphics);
    public int getWidth(){
        return width;
    }

    public int getHeight() {
        return height;
    }
//    public abstract Rectangle getRectangle();
}
