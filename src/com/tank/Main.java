package com.tank;
/**
 * 用时间来记录画画过程，回退即在时间轴上回溯。可以插入标签
 */
public class Main {
	private int a = 0;//access

	public static void main(String[] args) throws InterruptedException
	{
		TankFrame tf = new TankFrame();

		new Thread(()->new Audio("audio/war1.wav").loop()).start();
		
		while(true) {//framerate
			Thread.sleep(50);
			tf.repaint();
		}
	}
}
