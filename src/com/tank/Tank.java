package com.tank;

import com.fireStrtegy.DefaultFireStrtegy;
import com.fireStrtegy.FireStrategy;
import com.fireStrtegy.FourDirFireStrtegy;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Tank extends MoveObjects {
	public static int WIDTH = ResourceMgr.goodTankU.getWidth();
	public static int HEIGHT = ResourceMgr.goodTankU.getHeight();
    private Dir dir = Dir.DOWN;
    private Group group = Group.BAD;
    private boolean moving = true;
    private boolean living = true;
    private Random random = new Random();

    private int x, y;
    int oldX, oldY;

    FireStrategy<Tank> fireStrategy;

	Rectangle rect = new Rectangle();

	public Tank(int x, int y, Dir dir, Group group) {
		super(5);
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		if (group == Group.GOOD) {
			fireStrategy = new FourDirFireStrtegy();
			SPEED = 10;
			moving = false;
		} else fireStrategy = new DefaultFireStrtegy();

		rect.x = x;
		rect.y = y;
		rect.width = WIDTH;
		rect.height = HEIGHT;

		GameModel.getInstance().add(this);
	}

	public void paint(Graphics g)
	{
		if (!living) {
			GameModel.getInstance().remove(this);
			return;
		}

		switch (dir) {
			case LEFT:
				g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
				break;
			case UP:
				g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
				break;
			case RIGHT:
				g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
				break;
			case DOWN:
				g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
				break;
		}

		move();

	}

	void fire() {
	    fireStrategy.fire(this);
	}

	private void move() {
		if(!moving) return;

		oldX = x;
		oldY = y;

		GameModel.getInstance().xy(this);
		boundsCheck();

		if(this.group == Group.BAD && random.nextInt(100) > 97)
			this.fire();

		if(this.group == Group.BAD && random.nextInt(100) < 2)
			randomDir();
//		dir = Dir.values()[random.nextInt(4)];

		//update rect
		rect.x = this.x;
		rect.y = this.y;
	}

	private void boundsCheck()
	{
		if (this.x < 2) {
			x = 2;
			randomDir();
		}
		if (this.y < 28) {
			y = 28;
			randomDir();
		}
		if (this.x > TankFrame.GAME_WIDTH- Tank.WIDTH -2 | y > TankFrame.GAME_HEIGHT - Tank.HEIGHT -2) {
			x = oldX;
			y = oldY;
			randomDir();
//			if (group == Group.BAD) randomDir();
		}
	}

	public void back()
	{
		x = oldX;
		y = oldY;
		randomDir();
	}

	private void randomDir() {
		if (group == Group.GOOD) return;
		Dir temp = dir;

		do {
			dir = Dir.values()[random.nextInt(4)];
		} while (temp == dir);
	}

	public Dir getDir() {return dir;}

	public int getX() {
		return x;
	}

	public Group getGroup() {
		return group;
	}

	void setGroup(Group group) {
		this.group = group;
	}

	public int getY() {
		return y;
	}

	void setDir(Dir dir) {
		this.dir = dir;
	}

	void setMoving(boolean moving) {
		this.moving = moving;
	}

	@Override
	void setX(int x) {
		this.x = x;
	}

	@Override
	void setY(int y) {
		this.y = y;
	}

	public void die() {this.living = false;}

	boolean isMoving() {
		return moving;
	}

	public Rectangle getRectangle() {
		return rect;
	}
}
