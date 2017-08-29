package com.chinasoft.main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Game2048 extends JPanel implements KeyListener{
	private Backgroundself backgrond;
	private GameService service;
	
	public Game2048()
	{
		backgrond = new Backgroundself();
		service = new GameService();
	}
	public void paint(Graphics g)
	{
		backgrond.drawBackgroud(g);
		service.gamePaint(g);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���˼���"+e.getKeyChar());
		System.out.println("ֵ"+e.getKeyCode());
		int isMove;//�Ƿ����ƶ�
		int isRemove;
		int choice=e.getKeyCode();//�洢�����˼��̵��ĸ�������ֵ
		switch(choice)
		{
		    case 37://shift+enter  ����һ�п���
		    {
		    	System.out.println("��");
		    	isMove=service.moveLeft();
		    	isRemove=service.removeLeft();
		    	if(isMove!=0||isRemove!=0)
		    	{
		    		service.newBlock();
		    	}
		    	break;
		    }
		    case 38:
		    {
		    	System.out.println("��");
		    	isMove=service.moveUp();
		    	isRemove=service.removeUp();
		    	if(isMove!=0||isRemove!=0)
		    	{
		    		service.newBlock();
		    	}
		    	break;
		    }
		    case 39:
		    {
		    	System.out.println("��");
		    	isMove=service.moveRight();
		    	if(isMove!=0)
		    	{
		    		service.newBlock();
		    	}
		    	break;
		    }
		    case 40:
		    {
		    	System.out.println("��");
		    	isMove=service.moveDown();
		    	if(isMove!=0)
		    	{
		    		service.newBlock();
		    	}
		    	break;
		    }
		    case 27:
		    {
		    	System.out.println("ESC");
		    	break;
		    }
		    case 112:
		    {
		    	System.out.println("F1");
		    	break;
		    }
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
