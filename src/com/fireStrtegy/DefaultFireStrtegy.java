package com.fireStrtegy;

import com.tank.Audio;
import com.tank.Bullet;
import com.tank.Group;
import com.tank.Tank;

public class DefaultFireStrtegy extends FireStrategy <Tank>{
    @Override
    public void fire(Tank tank) {
        int bX = tank.getRectangle().x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = tank.getRectangle().y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        new Bullet(bX, bY, tank.getDir(), tank.getGroup());

        if(tank.getGroup() == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
