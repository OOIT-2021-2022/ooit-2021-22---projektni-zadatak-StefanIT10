package geometry;

public class Rectangle2 {
	
	private point upperLeftPoint;
	private int width;
	private int height;
	private boolean selected;
	
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

	
	

}
