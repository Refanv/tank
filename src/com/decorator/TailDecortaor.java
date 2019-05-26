package com.decorator;

import com.tank.Bullet;
import com.tank.GameModel;
import com.tank.GameObjects;

import java.awt.*;

public class TailDecortaor extends GODecortaor {
    public TailDecortaor(int x, int y, GameObjects gameObject) {
        super(x, y, gameObject);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        if (!display) {
            return;
        }
        update_x_y();

        Color c = graphics.getColor();
        graphics.setColor(Color.WHITE);
        graphics.drawLine(x, y, x + Bullet.WIDTH, y + Bullet.HEIGHT);
        graphics.setColor(c);
    }
}
