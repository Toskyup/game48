package com.chinasoft.main;

import java.awt.Graphics;
import java.util.Random;

/*
 * 游戏服务功能，提供了一切业务逻辑的处理功能
 */
public class GameService {
	private Data data;//存放数据的成员
	private int[][] gameMap;//存放游戏中的方块图案的编号1 - 11，0表示没有非那方块
	private Background blackground;
	GameService(){
		data = new Data();
		//gameMap = new int[4][4];
		blackground = new Background();
		start();
	}
	/*
	 * 提供画出面板上的内容
	 * 1.分数数据
	 * 2.次背景中的方块图案
	 *    a.遍历
	 */
	public void gamePaint(Graphics g)
	{
		data.drawData(g);
		int blockIndex;//方块编号
		//gameMap[1][1] = 2;
		//gameMap[2][2] = 5;
		for (int y =0; y<gameMap.length;y++)//遍历行  对应一维的索引
		{
			for (int x = 0; x < gameMap.length; x++)
			{
				if(gameMap[y][x]!=0)
				{
					blockIndex=gameMap[y][x];
					blackground.drawBlock(g, x, y, blockIndex);
				}
			}
		}
	}
	/*
	 * 开始游戏
	 */
	void start()
	{
		gameMap = new int[4][4];//清零
		data.setScore(0);//当前分数清零
		newBlock();
		newBlock();
	}
	/*
	 * 产生新方块的功能   在4*4的方块产生不重叠的方块
	 * 随机生成一个新方块
	 * 1.在4*4的方块内随机生产一个方块2或者4图案，如果该位置上存在有方块则重新生成
	 * 2.需要在gameMap中的对应位置上存入一个代表图片的编号数据
	 */
	public void newBlock()
	{
		Random random = new Random();
		int x,y;//随机坐标
		do{
			x = random.nextInt(4);
			y = random.nextInt(4);
		}while(gameMap[y][x]!=0);
		//设置1/8该类出现方块4，其他是方块2
		int index = random.nextInt(8);
		if(index!=0)
		{
			gameMap[y][x]=1;
		}
		else
		{
			gameMap[y][x]=2;
		}
	}
	/**
	 * 左移动
	 * @return 0没有移动，1移动
	 */
	public int moveLeft()
	{
		System.out.println("真的发生左移动");
		int isMove = 0;
		for (int y = 0; y < gameMap.length; y++) 
		{
			for (int x = 1; x < gameMap.length; x++)
			{
				int move_y = y;//给当前标记赋值
				int move_x = x;
				while(gameMap[move_y][move_x]!=0&&gameMap[move_y][move_x-1]==0)
				{
					//赋值给左边的格子
					gameMap[move_y][move_x-1]=gameMap[move_y][move_x];
					gameMap[move_y][move_x]=0;
					/*
					move_x--;
					if(move_x==0)
						break;
					*/
					if(move_x>1)
					{
						move_x--;
					}
					isMove = 1;
				}
			}
		}
		return isMove;
	}
	/**
	 * 右移动
	 * @return 0没有移动，1移动
	 */
	public int moveRight()
	{
		System.out.println("发生右移动");
		int isMove = 0;
		for (int y = 0; y < gameMap.length; y++) 
		{
			for(int x=2;x>=0;x--)
			{
				int move_y = y;//给当前标记赋值
				int move_x = x;
				while(gameMap[move_y][move_x]!=0&&gameMap[move_y][move_x+1]==0)
				{
					gameMap[move_y][move_x+1]=gameMap[move_y][move_x];
					gameMap[move_y][move_x]=0;
					
					if(move_x<2)
						move_x++;//边界值为2
					isMove = 1;
				}
				
				
			}
		}
		return isMove;
	}
	/**
	 * 上移动
	 * @return 0没有移动，1移动
	 */
	public int moveUp()
	{
		System.out.println("发生上移动");
		int isMove = 0;
		for (int x = 0; x < gameMap.length; x++) 
		{
			for(int y=1;y<gameMap.length;y++)
			{
				int move_y = y;//给当前标记赋值
				int move_x = x;
				while(gameMap[move_y][move_x]!=0&&gameMap[move_y-1][move_x]==0)
				{
					gameMap[move_y-1][move_x]=gameMap[move_y][move_x];
					gameMap[move_y][move_x]=0;
					if(move_y>1)
						move_y--;//边界值为2
					isMove = 1;
				}
				
			}
		}
		return isMove;
	}
	/**
	 * 下移动
	 * @return 0没有移动，1移动
	 */
	public int moveDown()
	{
		System.out.println("发生下移动");
		int isMove = 0;
		for (int x = 0; x < gameMap.length; x++) 
		{
			for (int y = 2;  y>=0; y--) {
				int move_y = y;//给当前标记赋值
				int move_x = x;
				while(gameMap[move_y][move_x]!=0&&gameMap[move_y+1][move_x]==0)
				{
					System.out.println(y+" "+x);
					gameMap[move_y+1][move_x]=gameMap[move_y][move_x];
					gameMap[move_y][move_x]=0;
					if(move_y<2)
					{
						System.out.println("继续发生下移动");
						move_y++;
					}
						
					isMove=1;
					
				}
			}
			
		}
		return isMove;
	}
	public int removeLeft()
	{
		int isRemove =0;
		for (int y = 0; y < gameMap.length; y++) 
		{
			for (int x = 0; x < gameMap.length-1; x++)
			{
				if(gameMap[y][x]!=0&&gameMap[y][x]==gameMap[y][x+1])
				{
					/*
					 * x++;//当前变量的值增减1
					 * x+=1;//拿出x的值，增减再赋值给x
					 */
					gameMap[y][x]++;
					gameMap[y][x+1] = 0 ;
					isRemove =1;
					bonus(gameMap[y][x]);
				}
			}
		}
		moveLeft();//如果一行内遇到两次左消，需要再做一次左移动
		return isRemove;
	}
	public int reRight()
	{
		int isRemove=0;
		for (int y = 0; y < gameMap.length; y++) 
		{
			for (int x = 2; x >=0; x--)
			{
				if(gameMap[y][x]!=0&&gameMap[y][x]==gameMap[y][x+1])
				{
					/*
					 * x++;//当前变量的值增减1
					 * x+=1;//拿出x的值，增减再赋值给x
					 */
					System.out.println("ss");
					gameMap[y][x]++;
					gameMap[y][x+1] = 0 ;
					isRemove =1;
					bonus(gameMap[y][x]);
				}
			}
		}
		moveRight();
		return isRemove;
	}
	public int removeUp()
	{
		int isRemove=0;
		for (int y = 0; y < gameMap.length; y++) {
			for (int x = 0; x < gameMap.length; x++) {
				if(gameMap[y][x]!=0&&gameMap[y+1][x]==gameMap[y][x])
				{
					gameMap[y][x]++;
					gameMap[y+1][x]=0;
					bonus(gameMap[y][x]);
					isRemove=1;
				}
			}
		}
		moveUp();
		return isRemove;
	}
	public int removeDown()
	{
		int isRemove=0;
		return isRemove;
	}
	/*
	 * 计分功能：
	 * 根据当前索引编号 然后通过 Math.pow(2,索引编号) 2的n次方
	 */
	public void bonus(int num)
	{
		int score = (int) Math.pow(2, num);
	}
}
