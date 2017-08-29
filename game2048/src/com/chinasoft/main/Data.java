package com.chinasoft.main;

import java.awt.Graphics;

/*
 * 提供面板中的分数的处理功能
 */
public class Data {
	public static final int SCORE_X = 80;//当前分数的面板图片X坐标
	public static final int SCORE_Y = 20;
	public static final int HIGHTSCORE_X = 280;
	public static final int HIGHTSCORE_Y = 20;
	
	private int score;
	private int hightScore;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getHightScore() {
		return hightScore;
	}
	public void setHightScore(int hightScore) {
		this.hightScore = hightScore;
	}
	public void drawData(Graphics g)
	{
		g.drawImage(Resource.img_score, SCORE_X, SCORE_Y, null);
		g.drawImage(Resource.img_highScore, HIGHTSCORE_X, HIGHTSCORE_Y, null);
	}
}
