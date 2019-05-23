package com.mashibing.tank;

public class BulletTankCollider implements Collider {

    @Override
    public void collide(GameObjects gameObjects1, GameObjects gameObjects2)
    {
        if (gameObjects1 instanceof Bullet && gameObjects2 instanceof Tank)
        {
            collideWith((Bullet) gameObjects1, (Tank)gameObjects2);
        } else if (gameObjects1 instanceof Tank && gameObjects2 instanceof Bullet) {
            collideWith((Bullet) gameObjects2, (Tank)gameObjects1);
        }else return;
    }

    private void collideWith(Bullet bullet, Tank tank)
    {
        if (bullet.getGroup() == tank.getGroup()) return;
//        if (bullet.isAlive() || tank.isAlive())

        if (bullet.rect.intersects(tank.rect)) {
            tank.die();
            bullet.die();
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
			int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
			bullet.gameModel.add(new Explode(eX, eY, bullet.gameModel));
        }
    }
}
