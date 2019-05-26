package com.tank;

import java.awt.Graphics;

public class Bullet extends MoveObjects{
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();

	public Bullet(int bX, int bY, Dir dir, Group group) {
        super(bX, bY, dir, group);
        super.init_MO_Rect(WIDTH, HEIGHT);
        super.init_GO_W_H(WIDTH, HEIGHT);

        SPEED = Integer.parseInt(PropertyMgr.get("bulletSpeed"));

//		if (group == Group.BAD)GameModel.getInstance().add(this);
        GameModel.getInstance().add(this);
	}

	public void paint(Graphics g) {
        if (!living) {
            System.out.println("Bullet" + toString());
            GameModel.getInstance().remove(this);
            return;
        }

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }

        move();
	}

    @Override
    void move() {//TODO
//        GameModel.getInstance().xy(this);
        super.move();
        //update rect
        rect.x = this.x;
        rect.y = this.y;

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }
}
