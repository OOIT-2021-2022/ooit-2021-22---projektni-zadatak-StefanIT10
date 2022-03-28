package geometry;

public class point {
	
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
	
	
	public double distance(int xPoint2, int yPoint2) {
		double dx=this.x-xPoint2;
		double dy=this.y-yPoint2;
		double d= Math.sqrt(dx*dx+dy*dy);
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
		this.y=y;
	}
	
	public void setSelected(boolean selected) {
		this.selected=selected;
	}

	public boolean isSelected() {
		return selected;
	}

	
	
	
}
