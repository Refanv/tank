package com.tank;

import com.fireStrtegy.DefaultFireStrtegy;
import com.fireStrtegy.FireStrategy;
import com.fireStrtegy.FourDirFireStrtegy;

import java.awt.Graphics;
import java.util.Random;

/**耦合度：当修改来一个类之后，另一个类也要随之改变
 * 级别： 1.继承 2.聚合（属性） 3.a类不是b类的属性，但是在a类的方法里，方法当参数，或者方法的返回值 4.耦合度为0，互相没有关系
 */
public class Tank extends MoveObjects {
    int oldX, oldY;
    private boolean moving = true;
    private Random random = new Random();

    FireStrategy<Tank> fireStrategy;

	public Tank(int x, int y, Dir dir, Group group) {
		super(x, y, dir, group);

		width = ResourceMgr.goodTankU.getWidth();
		height = ResourceMgr.goodTankU.getHeight();
		super.init_MO_Rect(width, height);

		SPEED = Integer.parseInt(PropertyMgr.get("tankSpeed"));
		if (group == Group.GOOD)
		{
			fireStrategy = new FourDirFireStrtegy();
			SPEED = 10;
			moving = false;
		} else fireStrategy = new DefaultFireStrtegy();

		oldX = x;
		oldY = y;

		GameModel.getInstance().add(this);
	}

	public void paint(Graphics g)
	{
		if (!display) {
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

	@Override
	void move() {
		if(!moving) return;

		oldX = x;
		oldY = y;

		super.move();
		boundsCheck();

		//update rect
		rect.x = this.x;
		rect.y = this.y;

		if(this.group == Group.BAD && random.nextInt(100) > 97)
			this.fire();

		if(this.group == Group.BAD && random.nextInt(100) < 2)
			dir = Dir.values()[random.nextInt(4)];
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
		if (this.x > TankFrame.GAME_WIDTH- width -2 | y > TankFrame.GAME_HEIGHT - height -2) {
			x = oldX;
			y = oldY;
			randomDir();
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

	void setDir(Dir dir) {
		this.dir = dir;
	}

	void setMoving(boolean moving) {
		this.moving = moving;
	}
}
