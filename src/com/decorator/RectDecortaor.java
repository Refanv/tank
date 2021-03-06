package com.decorator;

import com.tank.Bullet;
import com.tank.GameModel;
import com.tank.GameObjects;
import com.tank.MoveObjects;

import java.awt.*;

public class RectDecortaor extends GODecortaor {

    public RectDecortaor(int x, int y, GameObjects gameObject) {
        super(x, y, gameObject);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
//        if (GO == null){ GO也在指向子弹，子弹永远不会被GC
        //TODO 直接子类对象可见，子类的子类对象不可见;
//        this.x = GO.x;

        if (!display) {
            GameModel.getInstance().remove(this);
            return;
        }
        update_x_y();
//        GO.paint(graphics); 因为子弹被两次添加进objects。子弹构造方法一次，坦克开火方法里，给子弹增加装饰模式时，手动添加了一次
        Color c = graphics.getColor();
        graphics.setColor(Color.WHITE);
        graphics.drawRect(x, y, GO.getWidth() + 2, GO.getHeight() + 2);
        graphics.setColor(c);
    }
}
