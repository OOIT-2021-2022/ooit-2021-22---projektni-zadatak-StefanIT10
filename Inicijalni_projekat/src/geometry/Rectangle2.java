package geometry;

public class Rectangle2 {
	
	private point upperLeftPoint;
	private int width;
	private int height;
	private boolean selected;
	
	public Rectangle2() {}
	
	public Rectangle2(point upperLeftPoint, int width, int height) {
		this.upperLeftPoint=upperLeftPoint;
		this.width=width;
		this.height=height;
		
	}
	
	public Rectangle2(point upperLeftPoint, int width, int height, boolean selected) {
		this(upperLeftPoint, width, height);
		this.selected=selected;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle2) {
			Rectangle2 pomocna = (Rectangle2) obj; //downcast
			if(this.upperLeftPoint.equals(pomocna.upperLeftPoint)&&this.width==pomocna.width
					&&this.height==pomocna.height)
				return true;
			
			else 
				return false;
			
		} else
			return false;
		
		}
	
	public int area() {
		return height*width;
	}
	
	public int circumference() {
		return 2*width+2*height;
	}
	
	public point getupperLeftPoint() {
		return this.upperLeftPoint;
	}
	
	public void setUpperLeftPoint(point upperLeftPoint) {
		this.upperLeftPoint=upperLeftPoint;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String toString() {
		return "Upper Left Point: "+upperLeftPoint+", width = "+width+", height ="+height;
	}
	
	

}
