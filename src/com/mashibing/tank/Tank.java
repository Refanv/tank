package com.mashibing.tank;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Tank extends GameObjects{
	private int SPEED = 2;
	public static int WIDTH = ResourceMgr.goodTankU.getWidth();
	public static int HEIGHT = ResourceMgr.goodTankU.getHeight();
    private Dir dir = Dir.DOWN;
    private Group group = Group.BAD;
    private boolean moving = true;
    private boolean living = true;
    private Random random = new Random();

    private int x, y;
    int oldX, oldY;

    GameModel gameModel = GameModel.getGm();
    FireStrategy<Tank> fireStrategy;
    Rectangle rect = new Rectangle();

	public Tank(int x, int y, Dir dir, Group group) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		if (group == Group.GOOD)
		{
			fireStrategy = new FourDirFireStrtegy();
			SPEED = 10;
		}
		else fireStrategy = new DefaultFireStrtegy();

		rect.x = this.x;
		rect.y = this.y;
		rect.width = WIDTH;
		rect.height = HEIGHT;
	}

	public void fire() {
	    fireStrategy.fire(this);
	}
	
	Dir getDir() {
		return dir;
	}
	
	int getX() {
		return x;
	}
	
	
	Group getGroup() {
		return group;
	}
	void setGroup(Group group) {
		this.group = group;
	}
	int getY() {
		return y;
	}

	boolean isMoving() {
		return moving;
	}

	private void move() {
		
		if(!moving) return ;

		oldX = x;
		oldY = y;
		
		switch (dir)
		{
			case LEFT:
				x -= SPEED;
				break;
			case UP:
				y -= SPEED;
				break;
			case RIGHT:
				x += SPEED;
				break;
			case DOWN:
				y += SPEED;
				break;
		}
		
		if(this.group == Group.BAD && random.nextInt(100) > 97)
			this.fire();
		
		if(this.group == Group.BAD && random.nextInt(100) > 95)
			randomDir();

		boundsCheck();
		//update rect
		rect.x = this.x;
		rect.y = this.y;
	}

	private void boundsCheck()
	{
		if (this.x < 2) x = 2;
		if (this.y < 28) y = 28;
//		if (this.x > TankFrame.GAME_WIDTH- Tank.WIDTH -2) x = TankFrame.GAME_WIDTH - Tank.WIDTH -2;
		if (this.x > TankFrame.GAME_WIDTH- Tank.WIDTH -2) x = oldX;
//		if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT -2 ) y = TankFrame.GAME_HEIGHT -Tank.HEIGHT -2;
		if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT -2 ) y = oldY;
	}
	
	private void randomDir() { this.dir = Dir.values()[random.nextInt(4)]; }
	
	public void paint(Graphics g)
	{
		if (!living) {
			GameModel.getGm().remove(this);
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


	void setDir(Dir dir) {
		this.dir = dir;
	}

	void setMoving(boolean moving) {
		this.moving = moving;
	}

	void setX(int x) {
		this.x = x;
	}

	void setY(int y) {
		this.y = y;
	}
	void die() {
		this.living = false;
	}
	
	

}
