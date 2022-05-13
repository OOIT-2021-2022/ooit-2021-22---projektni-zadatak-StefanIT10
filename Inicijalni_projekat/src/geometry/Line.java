package geometry;

import java.awt.Graphics;

public class Line extends Shape{
	
	private point startPoint;
	private point endPoint;
	
	
	public Line() {}
	
	public Line(point startPoint, point endPoint) {
		this.startPoint=startPoint;
		this.endPoint=endPoint;
	}
	
	public Line(point startPoint, point endPoint, boolean selected) {
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
	
	public void setStartPoint(point startPoint) {
		this.startPoint=startPoint;
	}
	
	public point getStartPoint() {
		return this.startPoint;
	}

	public point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(point endPoint) {
		this.endPoint = endPoint;
	}

	
	public String toString() {
		return startPoint+"-->"+endPoint;
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		
	}

}
