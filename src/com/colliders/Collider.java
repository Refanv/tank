package com.colliders;

import com.tank.GameObjects;

public interface Collider{
     boolean collide(GameObjects gameObjects1, GameObjects gameObjects2);
}
