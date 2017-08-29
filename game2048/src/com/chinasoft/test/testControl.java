package com.chinasoft.test;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 实现控制窗体程序中的内容
 * 
 * 
 * 1.事件  —发生的某些事情，例如触发键盘按键或者点击鼠标
 * 通过一个监听器来监听这些事件的发生，然后去调用相应的处理方法来执行业务逻辑
 * 2.事件源 -监听器安装在哪里，哪里就是我们的事件源（如要监听窗体的变化，窗体就是事件源）
 * 3.监听器 -用来安装在事件源的对象上的，用来监听某个事件的发生
 * 
 * @author Administrator
 *
 */
public class testControl {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		controlPanel panel = new controlPanel();//如果把controlPanel改成JPanel会报错，因为JPanel没有继承监听器
		frame.addKeyListener(panel);
		frame.add(panel);
		frame.setSize(600, 600);//移动代码行，alt+小键盘箭头
		frame.setVisible(true);
	}
}
/**
 * 接口：常用于程序设计，通过定义一些标准规范的方法来设计程序，可以降低程序类和类之间的
 * 耦合度
 * 在使用接口编程的时候:接口类名  引用变量名 = new  子类对象（）；//父类引用指向子类对象
 * @author Administrator
 *
 */
class controlPanel extends JPanel implements KeyListener{
    String str;
    /**
     * 无参数构造方法
     */
    controlPanel(){
    	str="按了键盘";
    }
	public void paint(Graphics g)
	{
		super.paint(g);//表示调用父类的paint方法，作用是消除残影
		//对象没有初始化会出现空指针
		g.drawString(str, 50, 50);
	}
	@Override
	/**
	 * 键盘按下
	 * KeyEvent:事件对象
	 */
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("按了键盘"+e.getKeyChar());
		System.out.println("值"+e.getKeyCode());
		str = "按了键盘："+e.getKeyCode();
		repaint();
	}

	@Override
	/**
	 * 键盘抬起
	 */
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * 按键
	 */
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
