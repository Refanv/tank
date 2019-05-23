package com.mashibing.tank;

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
        if (tank1.rect.intersects(tank2.rect))
        {
            tank1.back();
            tank2.back();
        }
    }
}
