package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import geometry.Point;
import geometry.Shape;

public class PnlDrawing extends JPanel {
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private int j;

	/**
	 * Create the panel.
	 */
	
	
	public PnlDrawing() {
		setBackground(Color.white);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Iterator<Shape> it = shapes.iterator();
		
		while(it.hasNext()) {
			it.next().draw(g);
		}
	}
	
	public void addShape(Shape shape) {
		shapes.add(shape);
		repaint();
	}
	
	public Shape getShape(int index) {
		return shapes.get(index);
	}
	
	public void setShape(int index, Shape shape) {
		shapes.set(index, shape);
	}
	
	public void removeSelected() {
		shapes.removeIf(shape -> shape.isSelected());
		repaint();
	}
	
	public void deselect() {
		shapes.forEach(shape -> shape.setSelected(false));
		repaint();
	}
	
	public void select(Point point) {
		for(j=shapes.size() - 1; j>=0; j--) {
			if(shapes.get(j).contains(point.getX(), point.getY())) {
				shapes.get(j).setSelected(true);
				repaint();
				return;
			}
		}
	}
	
	public int getSelected() {
		for(j=shapes.size() - 1; j>=0; j--) {
			if(shapes.get(j).isSelected()) {
				return j;
			}
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return shapes.isEmpty();
	}
	
	public ArrayList<Shape> getShapes(){
		return shapes;
	}

}
