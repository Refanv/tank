package com.tank;

import java.awt.*;

public abstract class MoveObjects extends GameObjects {

    Dir dir;
    Group group;
    Rectangle rect = new Rectangle();
    boolean living = true;
    int SPEED;

    public MoveObjects(int speed) {
        this.SPEED = speed;
    }

    void initRect(int width, int height){
        rect.x = x;
        rect.y = y;
        rect.width = width;
        rect.height = height;
    }

    void move()
    {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
    }

    public Rectangle getRectangle() {
        return rect;
    }

    public Dir getDir() {
        return dir;
    }

    public void die() {
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
