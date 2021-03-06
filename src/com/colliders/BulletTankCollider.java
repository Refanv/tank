package com.colliders;

import com.tank.*;

public class BulletTankCollider implements Collider {

    @Override
    public boolean collide(GameObjects gameObjects1, GameObjects gameObjects2)
    {
        if (gameObjects1 instanceof Bullet && gameObjects2 instanceof Tank)
        {
            Bullet bullet = (Bullet)gameObjects1;
            Tank tank = (Tank)gameObjects2;
            if (collideWith(bullet, tank)) return false;
            else return true;
        } else if (gameObjects1 instanceof Tank && gameObjects2 instanceof Bullet)
        {
//            collideWith((Bullet) gameObjects2, (Tank)gameObjects1);
            if (collide(gameObjects2, gameObjects1)) return false;
            else return true;
        }else return true;
    }

    private boolean collideWith(Bullet bullet, Tank tank) {
        if (bullet.getGroup() == tank.getGroup() | tank.getGroup() == Group.GOOD) return false;
//        if (bullet.isAlive() || tank.isAlive())

        if (bullet.getRectangle().intersects(tank.getRectangle())) {
            int eX = tank.getX() + tank.getWidth() / 2 - Explode.WIDTH / 2;
            int eY = tank.getY() + tank.getHeight() / 2 - Explode.HEIGHT / 2;
            new Explode(eX, eY);
            tank.die();
            bullet.die();
            return true;
        } else
            return false;
    }
}
