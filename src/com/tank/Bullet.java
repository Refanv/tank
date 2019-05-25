package com.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends MoveObjects{
	public static int WIDTH = ResourceMgr.bulletD.getWidth();
	public static int HEIGHT = ResourceMgr.bulletD.getHeight();

	private Dir dir;
	private boolean living = true;
	private Group group = Group.BAD;

	Rectangle rect = new Rectangle();
	private int x, y;

	public Bullet(int bX, int bY, Dir dir, Group group) {
        super(6);
        this.x = bX;
		this.y = bY;
		this.dir = dir;
		this.group = group;

		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;

		GameModel.getInstance().add(this);
	}

	public void paint(Graphics g) {
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


    private void move()
	{//TODO
//        switch (dir) {
        GameModel.getInstance().xy(this);
		//update rect
		rect.x = this.x;
		rect.y = this.y;
		
		if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
	}

    public void die() {
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public Rectangle getRectangle() {
        return rect;
    }

    @Override
    int getX() {
        return x;
    }

    @Override
    int getY() {
        return y;
    }

    @Override
    Dir getDir() {
        return dir;
    }

    @Override
    void setX(int x) {
        this.x = x;
    }

    @Override
    void setY(int y) {
	    this.y = y;
    }
}
