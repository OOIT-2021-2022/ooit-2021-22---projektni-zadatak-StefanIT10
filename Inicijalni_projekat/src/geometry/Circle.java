package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
	protected Point center;
	private int radius;

	public Circle() {

	}

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		setSelected(selected);
	}

	public Circle(Point center, int radius, boolean selected, Color color) {
		this(center, radius, selected);
		this.setColor(color);
	}
	
	
	public Circle(Point center, int radius, boolean selected, Color color, Color innerColor) {
		// TODO Auto-generated constructor stub
		this(center, radius, selected, color);
		this.setInnerColor(innerColor);
	}

	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle pomocni = (Circle) obj;
			if (this.center.equals(pomocni.center) && this.radius == pomocni.radius) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean contains(int x, int y) {
		return center.distance(x, y) <= radius;
	}
	
	public boolean contains(Point clickPoint) {
		return center.distance(clickPoint.getX(), clickPoint.getY()) <= radius;
	}

	public double area() {
		return radius * radius * Math.PI;
	}

	public double circumference() {
		return 2 * radius * Math.PI;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
		this.fill(g);
	
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() + radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - radius - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + radius - 2, 4, 4);
			g.setColor(Color.black);
		}

	}
	
	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);		
	}

	@Override
	public void moveBy(int x, int y) {
		center.moveBy(x, y);		
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Circle) {
			Circle circleToCompare = (Circle)obj;
			return (int)(this.area() - circleToCompare.area());
		}			
		return 0;
	}
	
	public Point getCenter() {
		return this.center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) throws Exception {
		
		if(radius < 0) {
			throw new Exception("Radius mora biti veci od 0");
		}
		this.radius = radius;
	}
	
	public String toString() {
		// Center=(x,y), radius= radius
		return "Center=" + center + ", radius=" + radius;
	}

	@Override
	public void fill(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getInnerColor());
		g.fillOval(this.center.getX() - this.radius + 1, this.center.getY() - this.radius + 1, this.radius * 2 - 2, this.radius * 2 - 2);
		
	}

}