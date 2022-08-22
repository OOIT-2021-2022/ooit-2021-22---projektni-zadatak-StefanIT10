package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
	
	private Point startPoint;
	private Point endPoint;
	
	
	public Line() {}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint=startPoint;
		this.endPoint=endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this (startPoint, endPoint);
		//this.selected=selected;
		setSelected(selected);
	}
	
	public double length() {
		return this.startPoint.distance(this.endPoint.getX(), this.endPoint.getY());
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line pomocna = (Line) obj; //downcast
			if(this.startPoint.equals(pomocna.startPoint) && this.endPoint.equals(pomocna.endPoint))
				return true;
			
			else 
				return false;
			
		} else
			return false;
		
		}
	
	public boolean contains(int x, int y) {
		return (this.startPoint.distance(x,y)+this.endPoint.distance(x,y)-length()<=2);
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint=startPoint;
	}
	
	public Point getStartPoint() {
		return this.startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	
	public String toString() {
		return startPoint+"-->"+endPoint;
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		
		if(selected) {
			g.setColor(Color.blue);
		    g.drawRect(startPoint.getX()-2, startPoint.getY()-2, 4, 4);
		    g.drawRect(endPoint.getX()-2, endPoint.getY()-2, 4, 4);
		    g.setColor(Color.BLACK);
		
		}
	}

	@Override
	public void moveTo(int x, int y) {
		startPoint.moveTo(x, y);
		endPoint.moveTo(x, y);
		
	}

	@Override
	public void moveBy(int x, int y) {
		startPoint.moveBy(x, y);
		endPoint.moveBy(x,y);
		
	}

	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Line) {
			Line LineToCompare = (Line)obj;
			return (int)(this.length()-LineToCompare.length());
		}
		return 0;
	}
	
	

}
