package com.colliders;

import com.tank.Bullet;
import com.tank.Explode;
import com.tank.GameObjects;

public class BulletBulletCollider implements Collider {
    @Override
    public boolean collide(GameObjects gameObjects1, GameObjects gameObjects2) {
        if (gameObjects1 instanceof Bullet && gameObjects2 instanceof Bullet) {
            if (collideWith((Bullet) gameObjects1, (Bullet) gameObjects2))
                return false;
            else return true;
        } else {
            return true;
        }
    }

    private boolean collideWith(Bullet bullet1, Bullet bullet) {
        if (bullet.getRectangle().intersects(bullet1.getRectangle())) {
            new Explode(bullet.getRectangle().x, bullet.getRectangle().y);
            bullet1.die();
            bullet.die();
            return true;
        } else
            return false;
    }
}
