package com.chinasoft.main;

import java.awt.Graphics;


/**
 * 背景图案处理类，包括了bg.png和fg.png的处理
 * 
 * @author Administrator
 *
 */
public class Background {
	
	public static final int FG_X = 50;//次背景左上角x坐标
	public static final int FG_Y = 120;//y坐标
	public static final int SIZE = 100;//里面的格子的大小
	
	/*
	 * 提供外部访问的 画背景功能
	 */
	public void drwBackground(Graphics g){
		g.drawImage(Resource.img_bg, 0, 0, null);//画背景
		g.drawImage(Resource.img_fg, FG_X, FG_Y, null);
	}
	
	/*
	 * 提供画  次背景图上的方块图案功能 
	 * 需要传入方块图案的x和y坐标值，画笔，哪个方块图案（图案的对应的编号）
	 */
	public void drawBlock(Graphics g,int x,int y,int blockIndex){
		switch(blockIndex){
		case 1:
			g.drawImage(Resource.img_2, FG_X+x*SIZE, FG_Y+y*SIZE, null);
			break;
		case 2:
			g.drawImage(Resource.img_4,FG_X+x*SIZE,FG_Y+y*SIZE,null);break;
		case 3:
			g.drawImage(Resource.img_8,FG_X+x*SIZE,FG_Y+y*SIZE,null);break;
		case 4:
			g.drawImage(Resource.img_16,FG_X+x*SIZE,FG_Y+y*SIZE,null);break;
		case 5:
			g.drawImage(Resource.img_32,FG_X+x*SIZE,FG_Y+y*SIZE,null);break;
		case 6:
			g.drawImage(Resource.img_64,FG_X+x*SIZE,FG_Y+y*SIZE,null);break;
		case 7:
			g.drawImage(Resource.img_128,FG_X+x*SIZE,FG_Y+y*SIZE,null);break;
		case 8:
			g.drawImage(Resource.img_256,FG_X+x*SIZE,FG_Y+y*SIZE,null);break;
		case 9:
			g.drawImage(Resource.img_512,FG_X+x*SIZE,FG_Y+y*SIZE,null);break;
		case 10:
			g.drawImage(Resource.img_1024,FG_X+x*SIZE,FG_Y+y*SIZE,null);break;
		case 11:
			g.drawImage(Resource.img_2048,FG_X+x*SIZE,FG_Y+y*SIZE,null);break;
		}
	}
}
