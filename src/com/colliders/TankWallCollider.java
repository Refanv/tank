package com.colliders;

import com.tank.Bullet;
import com.tank.GameObjects;
import com.tank.Tank;
import com.tank.Wall;

public class TankWallCollider implements Collider {

    @Override
    public boolean collide(GameObjects o1, GameObjects o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank tank = (Tank) o1;
            Wall wall = (Wall) o2;
            collideWith(tank, wall);
        } else if (o1 instanceof Wall && o2 instanceof Tank) {
            collide(o2, o1);
        }
        return true;
    }

    private void collideWith(Tank tank, Wall wall) {
        if (tank.getRectangle().intersects(wall.getRectangle()))
            tank.back();
    }
}
