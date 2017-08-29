package com.chinasoft.main;

import java.awt.Image;

import javax.swing.ImageIcon;

/*
 * 用于加载图片的功能类
 * 由于图片加载需要消耗较多的资源  所以单独提供一个加载功能来处理，其他类中需要用到图片资源都通过该类提供
 * 在该类中实现了一次性加载图片资源的功能
 */
public class Resourceself {
	public static Image img_num;
	public static Image img_bg;
	public static Image img_fg;
	//静态块 会随着类加载而加载 而且只会执行一次
	static{
		img_num = new ImageIcon("res/num.png").getImage();
	}
	/*
	 * java中，凡是静态
	 */
	public static Image getImg(String url)
	{
		return new ImageIcon(url).getImage();
	}

}
