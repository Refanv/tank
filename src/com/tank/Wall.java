package com.tank;

import java.awt.*;

public class Wall extends GameObjects {
    int w, h;
    int x, y;
    public Rectangle rectangle;

    public Wall(int x, int y, int w, int h) {
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;

        rectangle = new Rectangle(x, y, w, h);
    }

    @Override
    public void paint(Graphics graphics) {
        Color c = graphics.getColor();
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(x, y, w, h);
        graphics.setColor(c);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
