package com.tank;

public class Main {
	private int a = 0;//access

	public static void main(String[] args) throws InterruptedException
	{
		TankFrame tf = new TankFrame();

		new Thread(()->new Audio("audio/war1.wav").loop()).start();
		
		while(true) {
			Thread.sleep(25);
			tf.repaint();
		}
	}
}
