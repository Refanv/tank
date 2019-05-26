package com.fireStrtegy;

import com.decorator.RectDecortaor;
import com.tank.*;

public class FourDirFireStrtegy extends FireStrategy<Tank> {
    @Override
    public void fire(Tank tank) {
        int bX = tank.getRectangle().x + tank.getWidth()/2 - Bullet.WIDTH/2;
        int bY = tank.getRectangle().y + tank.getHeight()/2 - Bullet.HEIGHT/2;

        for(Dir dir : Dir.values()) {
            GameModel.getInstance().add(
                    new RectDecortaor(bX, bY, new Bullet(bX, bY, dir, tank.getGroup()))
            );
        }

        new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
