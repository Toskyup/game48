package com.chinasoft.main;

import java.awt.Graphics;


/**
 * ����ͼ�������࣬������bg.png��fg.png�Ĵ���
 * 
 * @author Administrator
 *
 */
public class Background {
	
	public static final int FG_X = 50;//�α������Ͻ�x����
	public static final int FG_Y = 120;//y����
	public static final int SIZE = 100;//����ĸ��ӵĴ�С
	
	/*
	 * �ṩ�ⲿ���ʵ� ����������
	 */
	public void drwBackground(Graphics g){
		g.drawImage(Resource.img_bg, 0, 0, null);//������
		g.drawImage(Resource.img_fg, FG_X, FG_Y, null);
	}
	
	/*
	 * �ṩ��  �α���ͼ�ϵķ���ͼ������ 
	 * ��Ҫ���뷽��ͼ����x��y����ֵ�����ʣ��ĸ�����ͼ����ͼ���Ķ�Ӧ�ı�ţ�
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
