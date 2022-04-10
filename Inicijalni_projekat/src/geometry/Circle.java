package geometry;

public class Circle {
	
	private Point center;
	private int radius;
	
	public Circle() {

	}

	public Circle(point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(point center, int radius, boolean selected) {
		this(center, radius);
		this.selected = selected;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Cirlce pomocna = (Circle) obj; //downcast
			if (this.center.equals(pomocni.center) &&
					this.radius == pomocni.radius)
				return true;
			
			else 
				return false;
			
		} else
			return false;
		
		}
	
	public double area() {
		return radius*radius*Math.PI;
	}
	
	public double circumference() {
		return 2*radius*Math.PI;
	}
	
	
	public Point getCenter() {
		return this.center;
	}
	
	public void setCenter(Point center) {
		this.center=center;
		
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public String toString() {
		// Center=(x,y), radius= radius
		return "Center=" + center + ", radius=" + radius;
	}
	

}
