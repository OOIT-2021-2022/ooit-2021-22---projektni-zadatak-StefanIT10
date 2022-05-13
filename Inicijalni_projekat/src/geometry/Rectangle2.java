package geometry;

import java.awt.Graphics;

public class Rectangle2 extends Shape {
	
	private point upperLeftPoint;
	private int width;
	private int height;
	
	
	public Rectangle2() {}
	
	public Rectangle2(point upperLeftPoint, int width, int height) {
		this.upperLeftPoint=upperLeftPoint;
		this.width=width;
		this.height=height;
		
	}
	
	public Rectangle2(point upperLeftPoint, int width, int height, boolean selected) {
		this(upperLeftPoint, width, height);
		setSelected(selected);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle2) {
			Rectangle2 pomocna = (Rectangle2) obj; //downcast
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
	
	public boolean contains(point p) {
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
		
	}
	
	public point getupperLeftPoint() {
		return this.upperLeftPoint;
	}
	
	public void setUpperLeftPoint(point upperLeftPoint) {
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
		return "Upper Left Point: "+upperLeftPoint+", width = "+width+", height ="+height;
	}
	
	

}
