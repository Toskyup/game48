package com.chinasoft.test;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ʵ�ֿ��ƴ�������е�����
 * 
 * 
 * 1.�¼�  ��������ĳЩ���飬���紥�����̰������ߵ�����
 * ͨ��һ����������������Щ�¼��ķ�����Ȼ��ȥ������Ӧ�Ĵ�������ִ��ҵ���߼�
 * 2.�¼�Դ -��������װ���������������ǵ��¼�Դ����Ҫ��������ı仯����������¼�Դ��
 * 3.������ -������װ���¼�Դ�Ķ����ϵģ���������ĳ���¼��ķ���
 * 
 * @author Administrator
 *
 */
public class testControl {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		controlPanel panel = new controlPanel();//�����controlPanel�ĳ�JPanel�ᱨ����ΪJPanelû�м̳м�����
		frame.addKeyListener(panel);
		frame.add(panel);
		frame.setSize(600, 600);//�ƶ������У�alt+С���̼�ͷ
		frame.setVisible(true);
	}
}
/**
 * �ӿڣ������ڳ�����ƣ�ͨ������һЩ��׼�淶�ķ�������Ƴ��򣬿��Խ��ͳ��������֮���
 * ��϶�
 * ��ʹ�ýӿڱ�̵�ʱ��:�ӿ�����  ���ñ����� = new  ������󣨣���//��������ָ���������
 * @author Administrator
 *
 */
class controlPanel extends JPanel implements KeyListener{
    String str;
    /**
     * �޲������췽��
     */
    controlPanel(){
    	str="���˼���";
    }
	public void paint(Graphics g)
	{
		super.paint(g);//��ʾ���ø����paint������������������Ӱ
		//����û�г�ʼ������ֿ�ָ��
		g.drawString(str, 50, 50);
	}
	@Override
	/**
	 * ���̰���
	 * KeyEvent:�¼�����
	 */
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���˼���"+e.getKeyChar());
		System.out.println("ֵ"+e.getKeyCode());
		str = "���˼��̣�"+e.getKeyCode();
		repaint();
	}

	@Override
	/**
	 * ����̧��
	 */
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * ����
	 */
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
