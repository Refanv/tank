package com.mashibing.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel
{
    private static final GameModel gm = new GameModel();

    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD, this);

    private List<GameObjects> gameObjects = new ArrayList<>();

    private GameModel()
    {
        int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
        //初始化敌方坦克
        for(int i=0; i<initTankCount; i++) {
            gameObjects.add(new Tank(50 + i*80, 200, Dir.DOWN, Group.BAD, this));
        }

    }

    public static GameModel getGm()
    {
        return gm;
    }

    public void paint(Graphics g)
    {
        Color c = g.getColor();
        g.setColor(Color.white);
//        g.drawString("子弹的数量:" + gameObjects.size(), 10, 60);
//        g.drawString("敌人的数量:" + gameObjects.size(), 10, 80);
//        g.drawString("爆炸的数量:" + gameObjects.size(), 10, 100);
        g.setColor(c);

        myTank.paint(g);

        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
        }
        //collision detect

//        for(int i=0; i<bullets.size(); i++) {
//            for(int j = 0; j<tanks.size(); j++)
//                bullets.get(i).collideWith(tanks.get(j));
//        }
    }

    public void add(GameObjects gameObject)
    {
        gameObjects.add(gameObject);
    }

    public void delete(GameObjects gameObject)
    {
        gameObjects.remove(gameObject);
    }

    public Tank getMainTank() {
        return myTank;
    }
}
