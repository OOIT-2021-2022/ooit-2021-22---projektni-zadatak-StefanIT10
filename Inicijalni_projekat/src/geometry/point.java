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
	
	public boolean equals(Object obj) {
		if(obj instanceof point) {
			point pomocna = (point) obj; //downcast
			if(this.x==pomocna.x && this.y==pomocna.y)
				return true;
			
			else 
				return false;
			
		} else
			return false;
		
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

	public String toString() {
		return "(" + x + "," + y + ")";
		
		//nije ispravno
		//return x.toString(); 
				
		//ispravno, ali necemo samo x koordinatu
		//return String.valueOf(x); 
	}
	
	
	
}
