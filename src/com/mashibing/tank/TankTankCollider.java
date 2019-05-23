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

    private void collideWith(Tank gameObjects1, Tank gameObjects2) {
        if (gameObjects1.rect.intersects(gameObjects2.rect))
        {
            gameObjects1.setX(gameObjects1.oldX);
            gameObjects1.setY(gameObjects1.oldY);
            gameObjects2.setX(gameObjects2.oldX);
            gameObjects2.setY(gameObjects2.oldY);
        }
    }
}
