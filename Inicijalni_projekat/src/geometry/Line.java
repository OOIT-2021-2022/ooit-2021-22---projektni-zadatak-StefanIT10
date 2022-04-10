package geometry;

public class Line {
	
	private point startPoint;
	private point endPoint;
	private boolean selected;
	
	public Line() {}
	
	public Line(point startPoint, point endPoint) {
		this.startPoint=startPoint;
		this.endPoint=endPoint;
	}
	
	public Line(point startPoint, point endPoint, boolean selected) {
		this (startPoint, endPoint);
		this.selected=selected;
	}
	
	public double length() {
		return this.startPoint.distance(this.endPoint.getX(), this.endPoint.getY());
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line pomocna = (Line) obj; //downcast
			if(this.startPoint.equals(pomocna.startPoint) && this.endPoint.equals(pomocna.endPoint))
				return true;
			
			else 
				return false;
			
		} else
			return false;
		
		}
	
	public void setStartPoint(point startPoint) {
		this.startPoint=startPoint;
	}
	
	public point getStartPoint() {
		return this.startPoint;
	}

	public point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(point endPoint) {
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
