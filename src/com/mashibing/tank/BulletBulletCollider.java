package com.mashibing.tank;

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

    private boolean collideWith(Bullet gameObjects1, Bullet gameObjects2) {
        if (gameObjects1.rect.intersects(gameObjects2.rect)) {
            new Explode(gameObjects1.rect.x, gameObjects2.rect.y);
            gameObjects1.die();
            gameObjects2.die();
            return true;
        } else
            return false;
    }
}
