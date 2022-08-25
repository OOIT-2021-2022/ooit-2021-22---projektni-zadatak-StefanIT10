<<<<<<< HEAD
 package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {
	
	private int x;
	private int y;
	
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public Point(int x, int y, boolean selected) {
		this(x,y);
		setSelected(selected);
	}
	
	
	public double distance(int xPoint2, int yPoint2) {
		double dx=this.x-xPoint2;
		double dy=this.y-yPoint2;
		double d= Math.sqrt(dx*dx+dy*dy);
		return d;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point pomocna = (Point) obj; //downcast
			if(this.x==pomocna.x && this.y==pomocna.y)
				return true;
			
			else 
				return false;
			
		} else
			return false;
		
		}
	
	public boolean contains (int x, int y) {
		return this.distance(x,y)<=2;
	}
	

	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	
	public String toString() {
		return "(" + x + "," + y + ")";
		
		//nije ispravno
		//return x.toString(); 
				
		//ispravno, ali necemo samo x koordinatu
		//return String.valueOf(x); 
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y-2, x, y+2);
		
		if(selected) {
			g.setColor(Color.blue);
		    g.drawRect(x-2, y-2, 4, 4);
		    g.setColor(Color.BLACK);
		}
		
	}
	

	@Override
	public void moveTo(int x, int y) {
		/*this.*/ setX(x);
		this.y=y;
		
	}

	@Override
	public void moveBy(int x, int y) {
		setX(this.x + x);
		this.y+=y;
		
	}

	@Override
	public int compareTo(Object obj) {
		if(obj instanceof Point) {
			Point pointToCompare = (Point)obj;
			return (int)(this.distance(0, 0)-pointToCompare.distance(0, 0));
		}
		return 0;
	}
	
	
	
=======
package geometry;

public class Point {
	
	//1
	private int x;
	private int y;
	private boolean selected;
	
        public point() {
		
	}
	
	public point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public point(int x, int y, boolean selected) {
		this(x,y);
		this.selected=selected;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point pomocna = (Point) obj; //downcast
			if(this.x==pomocna.x && this.y==pomocna.y)
				return true;
			
			else 
				return false;
			
		} else
			return false;
		
		}
	
	public boolean contains(int x, int y) {
		return this.distance(x,y)<=2;
	}
	
	
	public double distance(int xPoint2, int yPoint2) {
	 double dx=this.x-xPoint2;
	 double dy=this.y-yPoint2;
	 double d=Math.sqrt(dx*dx+dy*dy);
	 return d;
	}
	
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
        this.x=x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
		
		//nije ispravno
		//return x.toString(); 
				
		//ispravno, ali necemo samo x koordinatu
		//return String.valueOf(x); 
	
	
	

>>>>>>> branch 'master' of https://github.com/OOIT-2021-2022/ooit-2021-22---projektni-zadatak-StefanIT10
}
