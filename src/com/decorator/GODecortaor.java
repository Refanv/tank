package com.decorator;

import com.tank.Bullet;
import com.tank.GameModel;
import com.tank.GameObjects;

import java.awt.*;

public abstract class GODecortaor extends GameObjects {
    GameObjects GO;

    public GODecortaor(int x, int y, GameObjects gameObject) {
        super(x, y);
        GO = gameObject;
//        GO.x;
        //TODO GO.x OK
    }

    public void paint(Graphics graphics) {
        if (!GO.isDisplay()) {
            display = false;
            GameModel.getInstance().remove(this);
        }else if(GO instanceof Bullet) return;
        else
            GO.paint(graphics);
    }

    void update_x_y() {
//     TODO   this.x = GO.x;
//        super.
        x = GO.getX();
        y = GO.getY();
    }
}
