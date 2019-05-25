package com.colliders;

import com.tank.GameObjects;

import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider {
    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain(){
        add(new BulletTankCollider());
        add(new TankTankCollider());
    }

    public void add(Collider collider) {
        colliders.add(collider);
    }

    public boolean collide(GameObjects object, GameObjects object2) {
        for (int i = 0; i < colliders.size(); i++) {
            if (!colliders.get(i).collide(object, object2)) {
                return false;
            }
        }
        return true;
    }
}
