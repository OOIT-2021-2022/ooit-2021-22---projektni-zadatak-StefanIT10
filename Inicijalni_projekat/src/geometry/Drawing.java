package geometry;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JFrame;


public class Drawing extends JPanel {
	
	public Drawing() {}

	
	public static void main(String args[]) {
		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		JPanel drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
		
	}
	
	public void paint(Graphics g) {
	 	Point p = new Point(10,15);
		p.draw(g);
		g.setColor(Color.red);
		Line line = new Line(new Point(20,30), new Point(40,50));
		line.draw(g);
		g.setColor(Color.black);
		Donut donut = new Donut(new Point(60,70), 50, 40, true);
		donut.draw(g);
		
		
		//zadatak 1 
		
		ArrayList <Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Point(20,30));
		shapes.add(new Line(new Point(400,500), new Point(600,700)));
		shapes.add(new Circle(new Point(100,100), 30));
		shapes.add(new Donut(new Point(170,150), 40, 25, false));
		shapes.add(new Rectangle(new Point(45,90), 20, 45));
		
		Iterator<Shape> it = shapes.iterator();  //vraca iterator nad shapes
		while(it.hasNext()) {
			Shape sh=it.next();
			sh.moveBy(10, 0);
			System.out.println(sh);
			
		}
		
		
		//zadatak 2
		
	    shapes.get(3).draw(g);
		shapes.get(shapes.size()-1).draw(g);
		shapes.remove(1);
		shapes.get(1).draw(g);
		shapes.get(3).draw(g);
		shapes.add(3, new Line(new Point(50,50), new Point(100,100)));
		
		
		Circle c1 = new Circle(new Point(10,15), 20);
		
		
		//Exception 
		
		try{
			c1.setRadius(-10);
		   } 
		catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		
		//Zadatak 4
		
		it = shapes.iterator();
		while (it.hasNext()) {
			Shape sh = it.next();
			sh.setSelected(true);
			sh.draw(g);
       	}
		
		
		//Zadatak 5
		
		Line l7 = new Line(new Point(600,700), new Point(800,900));
		
		HashMap<String, Shape> hmShapes = new HashMap<String, Shape>();
		hmShapes.put("Point 1", p);
		hmShapes.put("Line 1", l7);
		System.out.println(hmShapes.get("Line 1"));
		
		
		
		
	}	
	
	
	
	
}
