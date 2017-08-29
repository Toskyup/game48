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
		System.out.println("按了键盘"+e.getKeyChar());
		System.out.println("值"+e.getKeyCode());
		int isMove;//是否发生移动
		int isRemove;
		int choice=e.getKeyCode();//存储按下了键盘的哪个按键的值
		switch(choice)
		{
		    case 37://shift+enter  在下一行空行
		    {
		    	System.out.println("左");
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
		    	System.out.println("上");
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
		    	System.out.println("右");
		    	isMove=service.moveRight();
		    	if(isMove!=0)
		    	{
		    		service.newBlock();
		    	}
		    	break;
		    }
		    case 40:
		    {
		    	System.out.println("下");
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
