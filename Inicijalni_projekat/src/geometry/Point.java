package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {

	private int x;
	private int y;

	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, boolean selected) {
		this(x, y);
		setSelected(selected);
	}
	

	public Point(int x, int y, boolean selected, Color color) {
		// TODO Auto-generated constructor stub
		this(x, y, selected);
		this.setColor(color);
		
	}

	
	public double distance(int xPoint2, int yPoint2) {
		double dx = this.x - xPoint2;
		double dy = this.y - yPoint2;
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;

	}

	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point pomocna = (Point) obj;// downcast
			if (this.x == pomocna.x && this.y == pomocna.y)
				return true;
			else
				return false;
		} else
			return false;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(x - 2, y, x + 2, y);
		g.drawLine(x, y - 2, x, y + 2);
		
		if(isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(x-2, y-2, 4, 4);
			g.setColor(Color.BLACK);
		}

	}

	@Override
	public void moveTo(int x, int y) {
		/* this. */setX(x);
		this.y = y;
	}

	@Override
	public void moveBy(int x, int y) {
		setX(this.x + x);
		this.y += y;
	}
	
	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Point) {
			Point pointToCompare = (Point)obj;
			return (int)(this.distance(0, 0) - pointToCompare.distance(0, 0));
		}			
		return 0;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";

		// nije ispravno
		// return x.toString();

		// ispravno, ali necemo samo x koordinatu
		// return String.valueOf(x);
	}

	@Override
	public void fill(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}