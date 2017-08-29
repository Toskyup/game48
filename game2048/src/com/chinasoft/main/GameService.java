package com.chinasoft.main;

import java.awt.Graphics;
import java.util.Random;

/*
 * ��Ϸ�����ܣ��ṩ��һ��ҵ���߼��Ĵ�����
 */
public class GameService {
	private Data data;//������ݵĳ�Ա
	private int[][] gameMap;//�����Ϸ�еķ���ͼ���ı��1 - 11��0��ʾû�з��Ƿ���
	private Background blackground;
	GameService(){
		data = new Data();
		//gameMap = new int[4][4];
		blackground = new Background();
		start();
	}
	/*
	 * �ṩ��������ϵ�����
	 * 1.��������
	 * 2.�α����еķ���ͼ��
	 *    a.����
	 */
	public void gamePaint(Graphics g)
	{
		data.drawData(g);
		int blockIndex;//������
		//gameMap[1][1] = 2;
		//gameMap[2][2] = 5;
		for (int y =0; y<gameMap.length;y++)//������  ��Ӧһά������
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
	 * ��ʼ��Ϸ
	 */
	void start()
	{
		gameMap = new int[4][4];//����
		data.setScore(0);//��ǰ��������
		newBlock();
		newBlock();
	}
	/*
	 * �����·���Ĺ���   ��4*4�ķ���������ص��ķ���
	 * �������һ���·���
	 * 1.��4*4�ķ������������һ������2����4ͼ���������λ���ϴ����з�������������
	 * 2.��Ҫ��gameMap�еĶ�Ӧλ���ϴ���һ������ͼƬ�ı������
	 */
	public void newBlock()
	{
		Random random = new Random();
		int x,y;//�������
		do{
			x = random.nextInt(4);
			y = random.nextInt(4);
		}while(gameMap[y][x]!=0);
		//����1/8������ַ���4�������Ƿ���2
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
	 * ���ƶ�
	 * @return 0û���ƶ���1�ƶ�
	 */
	public int moveLeft()
	{
		System.out.println("��ķ������ƶ�");
		int isMove = 0;
		for (int y = 0; y < gameMap.length; y++) 
		{
			for (int x = 1; x < gameMap.length; x++)
			{
				int move_y = y;//����ǰ��Ǹ�ֵ
				int move_x = x;
				while(gameMap[move_y][move_x]!=0&&gameMap[move_y][move_x-1]==0)
				{
					//��ֵ����ߵĸ���
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
	 * ���ƶ�
	 * @return 0û���ƶ���1�ƶ�
	 */
	public int moveRight()
	{
		System.out.println("�������ƶ�");
		int isMove = 0;
		for (int y = 0; y < gameMap.length; y++) 
		{
			for(int x=2;x>=0;x--)
			{
				int move_y = y;//����ǰ��Ǹ�ֵ
				int move_x = x;
				while(gameMap[move_y][move_x]!=0&&gameMap[move_y][move_x+1]==0)
				{
					gameMap[move_y][move_x+1]=gameMap[move_y][move_x];
					gameMap[move_y][move_x]=0;
					
					if(move_x<2)
						move_x++;//�߽�ֵΪ2
					isMove = 1;
				}
				
				
			}
		}
		return isMove;
	}
	/**
	 * ���ƶ�
	 * @return 0û���ƶ���1�ƶ�
	 */
	public int moveUp()
	{
		System.out.println("�������ƶ�");
		int isMove = 0;
		for (int x = 0; x < gameMap.length; x++) 
		{
			for(int y=1;y<gameMap.length;y++)
			{
				int move_y = y;//����ǰ��Ǹ�ֵ
				int move_x = x;
				while(gameMap[move_y][move_x]!=0&&gameMap[move_y-1][move_x]==0)
				{
					gameMap[move_y-1][move_x]=gameMap[move_y][move_x];
					gameMap[move_y][move_x]=0;
					if(move_y>1)
						move_y--;//�߽�ֵΪ2
					isMove = 1;
				}
				
			}
		}
		return isMove;
	}
	/**
	 * ���ƶ�
	 * @return 0û���ƶ���1�ƶ�
	 */
	public int moveDown()
	{
		System.out.println("�������ƶ�");
		int isMove = 0;
		for (int x = 0; x < gameMap.length; x++) 
		{
			for (int y = 2;  y>=0; y--) {
				int move_y = y;//����ǰ��Ǹ�ֵ
				int move_x = x;
				while(gameMap[move_y][move_x]!=0&&gameMap[move_y+1][move_x]==0)
				{
					System.out.println(y+" "+x);
					gameMap[move_y+1][move_x]=gameMap[move_y][move_x];
					gameMap[move_y][move_x]=0;
					if(move_y<2)
					{
						System.out.println("�����������ƶ�");
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
					 * x++;//��ǰ������ֵ����1
					 * x+=1;//�ó�x��ֵ�������ٸ�ֵ��x
					 */
					gameMap[y][x]++;
					gameMap[y][x+1] = 0 ;
					isRemove =1;
					bonus(gameMap[y][x]);
				}
			}
		}
		moveLeft();//���һ��������������������Ҫ����һ�����ƶ�
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
					 * x++;//��ǰ������ֵ����1
					 * x+=1;//�ó�x��ֵ�������ٸ�ֵ��x
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
	 * �Ʒֹ��ܣ�
	 * ���ݵ�ǰ������� Ȼ��ͨ�� Math.pow(2,�������) 2��n�η�
	 */
	public void bonus(int num)
	{
		int score = (int) Math.pow(2, num);
	}
}
