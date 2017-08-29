package com.chinasoft.main;

import java.awt.Image;

import javax.swing.ImageIcon;

/*
 * 用于加载图片的功能类
 * 由于图片加载需要损耗较多资源    所以单独提供一个加载功能类来处理，其他类中需要用到图片资源
 * 都通过该类提供
 * 在该类中实现了一次性加载图片资源的功能
 */
public class Resource {
	public static Image img_num;//分数数字
	public static Image img_bg;//背景
	public static Image img_fg;//次背景方格
	public static Image img_score;//得分
	public static Image img_highScore;//最高得分
	public static Image img_2;//方块2
	public static Image img_4;//方块4
	public static Image img_8;//方块8
	public static Image img_16;//方块16
	public static Image img_32;//方块32
	public static Image img_64;//方块64
	public static Image img_128;//方块128
	public static Image img_256;//方块256
	public static Image img_512;//方块512
	public static Image img_1024;//方块1024
	public static Image img_2048;//方块2048
	
	//静态块   会随着类加载而加载    而且只会执行一次
	/*
	 * java中，凡是用static 修饰的  资源，都属于类的资源，
	 * 会随着java的类文件(.class)加载而同时加载
	 */
	static{//静态块用于初始化静态成员，对于一些资源类文件应当用静态块加载
		img_num = getImg("res/num.png");
		img_bg = getImg("res/bg.png");
		img_fg = getImg("res/fg.png");
		img_score = getImg("res/score.png");
		img_highScore = getImg("res/highScore.png");
		img_2 = getImg("res/2.png");
		img_4 = getImg("res/4.png");
		img_8 = getImg("res/8.png");
		img_16 = getImg("res/16.png");
		img_32 = getImg("res/32.png");
		img_64 = getImg("res/64.png");
		img_128 = getImg("res/128.png");
		img_256 = getImg("res/256.png");
		img_512 = getImg("res/512.png");
		img_1024 = getImg("res/1024.png");
		img_2048 = getImg("res/2048.png");
	}
	
	
	/**
	 * 加载图片对象到程序中
	 * @param imgName	图片资源路径和图片名
	 * @return			加载到的图片对象
	 */
	public static Image getImg(String url){
		return new ImageIcon(url).getImage();
	}
}
