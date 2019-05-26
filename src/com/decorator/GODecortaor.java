package com.decorator;

import com.tank.GameModel;
import com.tank.GameObjects;

import java.awt.*;

public abstract class GODecortaor extends GameObjects {
    GameObjects GO;

    public GODecortaor(int x, int y) {
        super(x, y);
        //TODO GO.x OK
    }
}
