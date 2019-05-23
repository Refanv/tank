package com.mashibing.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private static final GameModel gm = new GameModel();

    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD, this);

    private List<GameObjects> objects = new ArrayList<>();
    private Collider collider = new BulletTankCollider();

    private GameModel() {
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            objects.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, this));
        }

    }

    public static GameModel getGm() {
        return gm;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.white);
//        g.drawString("子弹的数量:" + objects.size(), 10, 60);
//        g.drawString("敌人的数量:" + objects.size(), 10, 80);
//        g.drawString("爆炸的数量:" + objects.size(), 10, 100);
        g.setColor(c);

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
                collider.collide(object, object2);
            }
        }
    }

    public void add(GameObjects gameObject) {
        objects.add(gameObject);
    }

    public void delete(GameObjects gameObject) {
        objects.remove(gameObject);
    }

    public Tank getMainTank() {
        return myTank;
    }
}
