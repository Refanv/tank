package com.tank;

import com.colliders.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private static final GameModel INSTANCE = new GameModel();
    static {
        INSTANCE.init();
    }

    private List<GameObjects> objects = new ArrayList<>();
    private ColliderChain chain = new ColliderChain();
    Tank myTank;

    private GameModel() {
    }

    private void init() {
        myTank = new Tank(500, 600, Dir.DOWN, Group.GOOD);

        //初始化敌方坦克
        int initTankCount = Integer.parseInt(PropertyMgr.get("initTankCount"));
        for (int i = 0; i < initTankCount; i++) {
            new Tank(20 + i % 8 * 140, (i / 8 + 1) * 200, Dir.DOWN, Group.BAD);
        }

        //wall
        add(new Wall(80, 120, 400, 30));
        add(new Wall(600, 100, 200, 50));
        add(new Wall(250, 300, 50, 400));
        add(new Wall(520, 300, 50, 200));
    }

    void paint(Graphics g) {
        myTank.paint(g);

        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }
        //collision detect

        List<GameObjects> temp = new ArrayList<>(objects);
        for (int i = 0; i < temp.size(); i++) {
            GameObjects object = temp.get(i);
            for (int j = i + 1; j < temp.size(); j++) {
                GameObjects object2 = temp.get(j);

                chain.collide(object, object2);
            }
        }
    }

    public static GameModel getInstance() {
        return INSTANCE;
    }

    public void add(GameObjects gameObject) {
        objects.add(gameObject);
    }

    public void remove(GameObjects gameObject) {
        objects.remove(gameObject);
    }

    public Tank getMainTank() {
        return myTank;
    }
}
