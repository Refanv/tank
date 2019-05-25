package com.colliders;

import com.tank.GameObjects;
import com.tank.Tank;

public class TankTankCollider implements Collider {

    @Override
    public boolean collide(GameObjects gameObjects1, GameObjects gameObjects2) {
        if (gameObjects1 instanceof Tank && gameObjects2 instanceof Tank)
        {
            collideWith((Tank) gameObjects1, (Tank) gameObjects2);
        }
        return true;
    }

    private void collideWith(Tank tank1, Tank tank2) {
        if (tank1.getRectangle().intersects(tank2.getRectangle()))
        {
            tank1.back();
            tank2.back();
        }
    }
}
