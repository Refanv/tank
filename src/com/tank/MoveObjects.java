package com.tank;

import java.awt.*;

public abstract class MoveObjects extends GameObjects {

    Dir dir;
    Group group;
    Rectangle rect = new Rectangle();
    int SPEED;

    public MoveObjects(int x, int y,Dir dir, Group group_) {
        super(x, y);
        this.dir = dir;
        group = group_;
    }

    void init_MO_Rect(int width, int height){
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
        display = false;
    }

    public Group getGroup() {
        return group;
    }
}
