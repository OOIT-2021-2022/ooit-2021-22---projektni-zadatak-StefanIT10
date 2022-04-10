package geometry;

public class line {

	private Point startPoint;
	private Point endPoint;
	private boolean selected;
	
	public Line() {}
	
	public Line(Point startPoint, Point endpoint) {
		this.startPoint=startPoint;
		this.endPoint=endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this (startPoint, endPoint);
		this.selected=selected;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof line) {
			line pomocna = (line) obj; //downcast
			if(this.startPoint.equals(pomocna.startPoint) && this.endPoint.equals(pomocna.endPoint))
				return true;
			
			else 
				return false;
			
		} else
			return false;
		
		}
	
	
	
	public double length() {
		return this.startPoint.distance(this.endPoint.getX(), this.endPoint.getY());
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	public Point getStartPoint() {
		return this.startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public String toString() {
		return startPoint+"-->"+endPoint;
	}
	
	
	
	
	
	
}
