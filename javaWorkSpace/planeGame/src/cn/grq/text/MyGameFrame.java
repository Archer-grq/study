package cn.grq.text;


import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MyGameFrame extends Frame{
	Image ballimg=GameUtil.getImage("images/1.png");
	Image bg=GameUtil.getImage("images/2.jpg");
	Ball ball=new Ball(ballimg, 250, 250);
	Shell[] shells=new Shell[50];
	private Image offscreenImage=null;
	public void update(Graphics g) {
		if(offscreenImage==null) {
			offscreenImage=this.createImage(Contant.WINDOW_WIDTH,Contant.WINDOW_HEIGH);
		}
		Graphics goff=offscreenImage.getGraphics();
		paint(goff);
		g.drawImage(offscreenImage,0,0,null);
	}
	
	public void paint(Graphics g) {//自动被调用相当于画笔
		
		super.paint(g);
		g.drawImage(bg, -180, 0, null);
		ball.drawSelf(g);
		
		for(int i=0;i<shells.length;i++) {
			shells[i].draw(g);
			boolean peng=shells[i].getRect().intersects(ball.getRect());
			if(peng) {
				ball.live=false;
			}
			
		}

	}
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}
	
	//加载窗口
		public void launchFrame() {
			this.setTitle("飞机游戏");
			this.setVisible(true);
			this.setSize(Contant.WINDOW_WIDTH,Contant.WINDOW_HEIGH);
			this.setLocation(300,300);
			
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			new paintThread().start();//启动重画窗口的线程
			addKeyListener(new KeyMonitor());//给窗口增加键盘的监听
			for(int i=0;i<shells.length;i++) {
				shells[i]=new Shell();
				
			}
		}
	//内部类   
	//帮助我们反复重画窗口
	class paintThread extends Thread{
		public void run() {
			while(true){
				repaint();//重画
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	//键盘监听内部类
	class KeyMonitor extends  KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			ball.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			ball.minusDirection(e);
		}
		
	}
}
	
