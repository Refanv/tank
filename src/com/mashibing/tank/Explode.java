package com.mashibing.tank;

import sun.management.GarbageCollectionNotifInfoCompositeData;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Explode extends GameObjects{
	public static int WIDTH = ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
	
	private int x, y;
	private int step = 0;

	GameModel gameModel;

	public Explode(int x, int y, GameModel gameModel) {
		this.x = x;
		this.y = y;
		this.gameModel = gameModel;

		new Thread(()->new Audio("audio/explode.wav").play()).start();
	}

	public void paint(Graphics g)
    {
		g.drawImage(ResourceMgr.explodes[step++], x, y, null);
		
		if(step >= ResourceMgr.explodes.length) 
			gameModel.add(this);
	}
}
