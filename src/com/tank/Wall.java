package com.tank;

import java.awt.*;

public class Wall extends GameObjects {
    int w, h;
    public Rectangle rectangle;

    public Wall(int x, int y, int w, int h) {
        super(x, y);
        this.w = w;
        this.h = h;

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
