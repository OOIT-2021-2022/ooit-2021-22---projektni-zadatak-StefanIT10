package geometry;

import java.awt.Graphics;

public class Donut extends Circle1{
	
	private int innerRadius;
	
	public Donut() {}

	public Donut(point center, int radius, int innerRadius) {
		//this.center=center;   //jer je circle protected
		//setRadius(radius);   //jer je u circle definisano kao private
	    super(center,radius);
	    this.innerRadius=innerRadius;
	}
	
	public Donut(point center, int radius, int innerRadius, boolean selected) {
		
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
	 
	 public boolean contains(point p) {
		 double dFromCenter = getCenter().distance(p.getX(), p.getY());
		 return dFromCenter > innerRadius && super.contains(p.getX(), p.getY());
		
	 }
	
	 public void draw(Graphics g) {
		 super.draw(g);
		 g.drawOval(center.getX()-innerRadius, center.getY()-innerRadius, innerRadius*2, innerRadius*2);
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
	
	
}