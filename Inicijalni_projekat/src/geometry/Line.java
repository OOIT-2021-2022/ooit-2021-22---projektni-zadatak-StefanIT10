package geometry;

public class Line {
	
	private point startPoint;
	private point endPoint;
	private boolean selected;
	
	
	public double length() {
		return this.startPoint.distance(this.endPoint.getX(), this.endPoint.getY());
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

}
