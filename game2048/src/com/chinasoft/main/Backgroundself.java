package com.chinasoft.main;
/**
 * ����ͼ�������࣬������bg.png��fg.png�Ĵ���
 * @author Administrator
 *
 */

import java.awt.Graphics;

public class Backgroundself {
	public static final int FG_X = 50;//�α������Ͻ�X
	public static final int FG_Y = 120;
	public static final int SIZE = 100;
	/**
	 * �ṩ�ⲿ����
	 */
	public void drawBackgroud(Graphics g)
	{
		g.drawImage(Resource.img_bg, 0, 0, null);
		g.drawImage(Resource.img_fg, FG_X, FG_Y, null);
	}
	/*
	 * �ṩ�� �α���ͼ�ϵķ���ͼ������
	 * ��Ҫ���뷽��ͼ����X��Y����ֵ�����ʣ��ĸ��ķ��飨ͼ���Ķ�Ӧ��ţ�
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
