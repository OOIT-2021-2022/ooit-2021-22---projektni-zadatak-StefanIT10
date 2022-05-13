package geometry;

import java.awt.Graphics;

public class Circle1 extends Shape {
	
	protected point center;
	private int radius;
	


	public Circle1() {

	}

	public Circle1(point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle1(point center, int radius, boolean selected) {
		this(center, radius);
		setSelected(selected);
	}
	
	public double area() {
		return radius*radius*Math.PI;
	}
	
	 public boolean equals(Object obj) {
			if(obj instanceof Circle1) {
				Circle1 pomocna = (Circle1) obj; //downcast
				if (this.center.equals(pomocna.center) &&
						this.radius == pomocna.radius)
					return true;
				
				else 
					return false;
				
			} else
				return false;
			
			}
	 
	 public boolean contains(int x, int y) {
	    	return center.distance(x,y)<=radius;
	    }
	    
	    public boolean contains(point p) {
	    	return center.distance(p.getX(), p.getY())<=radius;
	    }
	    
	
	public double circumference() {
		return 2*radius*Math.PI;
	}
	
	public point getCenter() {
		return this.center;
	}
	
	public void setCenter(point center) {
		this.center=center;
	}
	
	public int getRadius() {
		return this.radius;
	}
	
	public void setRadius(int radius) {
		this.radius=radius;
	}
	
	public String toString() {
		// Center=(x,y), radius= radius
		return "Center=" + center + ", radius=" + radius;
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
		
	}

}
