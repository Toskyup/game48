package com.chinasoft.main;

import java.awt.Image;

import javax.swing.ImageIcon;

/*
 * ���ڼ���ͼƬ�Ĺ�����
 * ����ͼƬ������Ҫ���Ľ϶����Դ  ���Ե����ṩһ�����ع�������������������Ҫ�õ�ͼƬ��Դ��ͨ�������ṩ
 * �ڸ�����ʵ����һ���Լ���ͼƬ��Դ�Ĺ���
 */
public class Resourceself {
	public static Image img_num;
	public static Image img_bg;
	public static Image img_fg;
	//��̬�� ����������ض����� ����ֻ��ִ��һ��
	static{
		img_num = new ImageIcon("res/num.png").getImage();
	}
	/*
	 * java�У����Ǿ�̬
	 */
	public static Image getImg(String url)
	{
		return new ImageIcon(url).getImage();
	}

}
