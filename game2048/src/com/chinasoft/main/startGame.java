package com.chinasoft.main;

import javax.swing.JFrame;

/**
 * ������Ϸ
 * @author Administrator
 *
 */
public class startGame {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		
		Game2048 gamePanel = new Game2048();
		jFrame.add(gamePanel);
		jFrame.addKeyListener(gamePanel);
		
		jFrame.setSize(500, 570);
		jFrame.setResizable(false);
		jFrame.setVisible(true);
	}
}
