package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle{
	
	private int innerRadius;
	
	public Donut() {}

	public Donut(Point center, int radius, int innerRadius) {
		//this.center=center;   //jer je circle protected
		//setRadius(radius);   //jer je u circle definisano kao private
	    super(center,radius);
	    this.innerRadius=innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		
		this(center,radius,innerRadius);
		setSelected(selected);
	}
	
	public double area() {
		return super.area()-innerRadius*innerRadius*Math.PI;
	}
	
	 public boolean equals(Object obj) {
			if(obj instanceof Donut) {
				Donut pomocna = (Donut) obj; //downcast
				if (this.center.equals(pomocna.center) &&
						this.getRadius() == pomocna.getRadius() && innerRadius==pomocna.innerRadius) 
					return true;
				
				else 
					return false;
				
			} else
				return false;
			
			}
	 
	 public boolean contains(int x, int y) {
		 double dFromCenter = getCenter().distance(x, y);
		 return dFromCenter > innerRadius && super.contains(x,y);
		
	 }
	 
	 public boolean contains(Point p) {
		 double dFromCenter = getCenter().distance(p.getX(), p.getY());
		 return dFromCenter > innerRadius && super.contains(p.getX(), p.getY());
		
	 }
	
	 public void draw(Graphics g) {
		 super.draw(g);
		 g.drawOval(center.getX()-innerRadius, center.getY()-innerRadius, innerRadius*2, innerRadius*2);
		 
		 if(selected) {
				g.setColor(Color.blue);
			    g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			    g.drawRect(center.getX() - innerRadius - 2, center.getY() - 2, 4, 4);
			    g.drawRect(center.getX() + innerRadius - 2, center.getY() - 2, 4, 4);
			    g.drawRect(center.getX() - 2, center.getY() - innerRadius - 2, 4, 4);
			    g.drawRect(center.getX() - 2, center.getY() + innerRadius - 2, 4, 4);
			    g.setColor(Color.BLACK);
			
			}
	 }

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public String toString() {
		// Center=(x,y), radius= radius, innerRadius = innerRadius
		return super.toString() + ", innerRadius=" +innerRadius;
	}
	
	public int compareTo(Object obj) {
		if(obj instanceof Donut) {
			Donut donutToCompare = (Donut)obj;
			return (int)(this.area()-donutToCompare.area());
		}
		return 0;
	}
	
	
}