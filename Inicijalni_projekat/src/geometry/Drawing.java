package geometry;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
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
	 	point p = new point(10,15);
		p.draw(g);
		g.setColor(Color.red);
		Line line = new Line(new point(20,30), new point(40,50));
		line.draw(g);
		g.setColor(Color.black);
		Donut donut = new Donut(new point(60,70), 50, 40, true);
		donut.draw(g);
		
		//zadatak 1 
		ArrayList <Shape> shapes = new ArrayList<Shape>();
		shapes.add(new point(20,30));
		shapes.add(new Line(new point(400,500), new point(600,700)));
		shapes.add(new Circle1(new point(100,100), 30));
		shapes.add(new Donut(new point(170,150), 40, 25, false));
		shapes.add(new Rectangle2(new point(45,90), 20, 45));
		
		Iterator<Shape> it = shapes.iterator();
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
		shapes.add(3, new Line(new point(50,50), new point(100,100)));
		
		
		Circle1 c1 = new Circle1(new point(10,15), 20);
		
		//exception 
		try{
			c1.setRadius(-10);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		
	}
	
	
	
	
	
	
	
	
}
