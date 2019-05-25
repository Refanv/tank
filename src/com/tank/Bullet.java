package com.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends MoveObjects{
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();

//	Rectangle rect = new Rectangle();

	public Bullet(int bX, int bY, Dir dir, Group group) {
        super(6);
        this.x = bX;
		this.y = bY;
		this.dir = dir;
		this.group = group;

        super.initRect(WIDTH, HEIGHT);

		GameModel.getInstance().add(this);
	}

	void paint(Graphics g) {
        if (!living) {
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


    void move()
	{//TODO
//        switch (dir) {
//        GameModel.getInstance().xy(this);
        super.move();
		//update rect
		rect.x = this.x;
		rect.y = this.y;
		
		if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
	}
}
