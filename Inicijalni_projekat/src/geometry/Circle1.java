package geometry;

public class Circle1 {
	
	private point center;
	private int radius;
	
	public double area() {
		return radius*radius*Math.PI;
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
	

}
