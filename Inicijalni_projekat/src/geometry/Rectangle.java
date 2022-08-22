package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	
	private Point upperLeftPoint;
	private int width;
	private int height;
	
	
	public Rectangle() {}
	
	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint=upperLeftPoint;
		this.width=width;
		this.height=height;
		
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		this(upperLeftPoint, width, height);
		setSelected(selected);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle pomocna = (Rectangle) obj; //downcast
			if(this.upperLeftPoint.equals(pomocna.upperLeftPoint)&&this.width==pomocna.width
					&&this.height==pomocna.height)
				return true;
			
			else 
				return false;
			
		} else
			return false;
		
		}
	
	public boolean contains(int x, int y) {
		if(x>upperLeftPoint.getX() && x<=upperLeftPoint.getX()+width
				&& y>upperLeftPoint.getY() && y<=upperLeftPoint.getY()+height)
			return true;
		return false;
	}
	
	public boolean contains(Point p) {
		if(p.getX()>upperLeftPoint.getX() && p.getX()<=upperLeftPoint.getX()+width
				&& p.getY()>upperLeftPoint.getY() && p.getY()<=upperLeftPoint.getY()+height)
			return true;
		return false;
	}
	
	public int area() {
		return height*width;
	}
	
	public int circumference() {
		return 2*width+2*height;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawRect(upperLeftPoint.getX(),upperLeftPoint.getY(),width,height);
		
		if(selected) {
			g.setColor(Color.blue);
		    g.drawRect(upperLeftPoint.getX()-2, upperLeftPoint.getY()-2, 4, 4);
		    g.drawRect(upperLeftPoint.getX()+ width -2, upperLeftPoint.getY()-2, 4, 4);
		    g.drawRect(upperLeftPoint.getX()-2, upperLeftPoint.getY() + height -2, 4, 4);
		    g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() + height -2, 4, 4);
		    g.setColor(Color.BLACK);
		
		}
		
	}
	
	public Point getupperLeftPoint() {
		return this.upperLeftPoint;
	}
	
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint=upperLeftPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String toString() {
		return "Upper Left Point: "+upperLeftPoint+", width = "+width+", height = "+height;
	}

	@Override
	public void moveTo(int x, int y) {
		upperLeftPoint.moveTo(x, y);
		
	}

	@Override
	public void moveBy(int x, int y) {
		upperLeftPoint.moveBy(x, y);
		
	}

	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle RectToCompare = (Rectangle)obj;
			return (int)(this.area()-RectToCompare.area());
		}
		return 0;
	}
	
	

}
