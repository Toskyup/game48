package com.chinasoft.main;
/**
 * 背景图案处理类，包括了bg.png和fg.png的处理
 * @author Administrator
 *
 */

import java.awt.Graphics;

public class Backgroundself {
	public static final int FG_X = 50;//次背景坐上角X
	public static final int FG_Y = 120;
	public static final int SIZE = 100;
	/**
	 * 提供外部工具
	 */
	public void drawBackgroud(Graphics g)
	{
		g.drawImage(Resource.img_bg, 0, 0, null);
		g.drawImage(Resource.img_fg, FG_X, FG_Y, null);
	}
	/*
	 * 提供画 次背景图上的方块图案功能
	 * 需要传入方块图案的X和Y坐标值，画笔，哪个的方块（图案的对应编号）
	 */
	public void drawBlock(Graphics g,int x,int y , int blockIndex)
	{
		switch(blockIndex)
		{
		    case 1:
		    {
		    	g.drawImage(Resource.img_2, FG_X+x*SIZE, FG_Y+y*SIZE, null);
		    	break;
		    }
		    	
		}
	}
}
