package com.mashibing.tank;

public class BulletTankCollider implements Collider {

    @Override
    public void collide(GameObjects gameObjects1, GameObjects gameObjects2)
    {
        if (gameObjects1 instanceof Bullet && gameObjects2 instanceof Tank)
        {
            Bullet bullet = (Bullet)gameObjects1;
            Tank tank = (Tank)gameObjects2;
            collideWith(bullet, tank);
        } else if (gameObjects1 instanceof Tank && gameObjects2 instanceof Bullet){
//            collideWith((Bullet) gameObjects2, (Tank)gameObjects1);
            collide(gameObjects2, gameObjects1);
        }else return;
    }

    private void collideWith(Bullet bullet, Tank tank)
    {
        if (bullet.getGroup() == tank.getGroup()) return;
//        if (bullet.isAlive() || tank.isAlive())

        if (bullet.rect.intersects(tank.rect))
        {
            int eX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
			int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
			new Explode(eX, eY);
            tank.die();
            bullet.die();
        }
    }
}
