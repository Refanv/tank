package com.mashibing.tank;

public class FourDirFireStrtegy extends FireStrategy<Tank> {
    @Override
    protected void fire(Tank tank) {
        int bX = tank.rect.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY = tank.rect.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;

        for(Dir dir : Dir.values())
        {
            new Bullet(bX, bY, dir, tank.getGroup(), GameModel.getGm());
        }

        new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
