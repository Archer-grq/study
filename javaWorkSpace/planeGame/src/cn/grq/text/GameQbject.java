package cn.grq.text;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class GameQbject {
	Image img;
	double x,y;
	int speed;
	int width,height;
	
	public void drawSelf(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
	}

	public GameQbject(Image img, double x, double y, int speed, int width, int height) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}

	public GameQbject(Image img, double x, double y) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
	}
	public GameQbject() {
		
	}
	public Rectangle getRect() {
		return new Rectangle((int)x,(int)y,width,height);
	}
}
