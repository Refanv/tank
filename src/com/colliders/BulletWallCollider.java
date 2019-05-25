package com.colliders;

import com.tank.*;

public class BulletWallCollider implements Collider {

    @Override
    public boolean collide(GameObjects o1, GameObjects o2)
    {
        if (o1 instanceof Bullet && o2 instanceof Wall)
        {
            Bullet bullet = (Bullet)o1;
            Wall wall = (Wall) o2;
            if (collideWith(bullet, wall)) return false;
            else return true;
        } else if (o1 instanceof Wall && o2 instanceof Bullet)
        {
            if (collide(o2, o1)) return false;
            else return true;
        }else return true;
    }

    private boolean collideWith(Bullet bullet, Wall wall)
    {
        if (bullet.getRectangle().intersects(wall.getRectangle())) {
            bullet.die();
            return true;
        } else
            return false;
    }
}
