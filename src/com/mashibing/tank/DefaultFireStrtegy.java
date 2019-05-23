package com.mashibing.tank;

public class DefaultFireStrtegy extends FireStrategy <Tank>{
    @Override
    protected void fire(Tank tank) {
        int bX = tank.rect.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = tank.rect.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        new Bullet(bX, bY, tank.getDir(), tank.getGroup());

        if(tank.getGroup() == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
