package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable, Comparable{
	//protected boolean selected;
	private boolean selected;
	private Color color;
	private Color innerColor;

	public Shape() {

	}
	
	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	public Shape(Color color) {
		this.color=color;
	}
	
	public Shape(Color color, boolean selected) {
		this(color);
		this.selected=selected;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public abstract boolean contains(int x, int y);
	
	public abstract void draw(Graphics g);
	
	public abstract void fill(Graphics g);

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
	
	
	
	
	
	
	


