package geometry;

public class test {

	public static void main(String[] args) {
		
		// int broj;
		// System.out.println(broj);

		System.out.println("Kreiranje objekta");

		point p = new point();
		// System.out.println(p.x + " "+ p.y+ " "+p.selected);

		System.out.print(p.getX() + "\n");
		p.setX(10);
		System.out.print(p.getX() + "\n");

		p.setY(20);
		System.out.print("Udaljenost je: " + p.distance(15, 25));

		// vezbe 3
		p.setSelected(true);
		point p1 = new point();
		p1.setX(20);
		p1.setY(25);

		Line l1 = new Line();
		Rectangle2 r1 = new Rectangle2();
		Circle1 c1 = new Circle1();

		// 1
		p.setX(p1.getY());

		// 2
		l1.setStartPoint(p);
		l1.setEndPoint(p1);

		// 3
		l1.getEndPoint().setY(23);

		// 4
		l1.getStartPoint().setX(l1.getEndPoint().getY());

		// 5
		l1.getEndPoint().setX((int) (l1.length() - l1.getStartPoint().getX() + l1.getStartPoint().getY()));

		// 6
		r1.setUpperLeftPoint(p);
		r1.getupperLeftPoint().setX(10);
		r1.getupperLeftPoint().setY(15);

		// 7
		c1.setCenter(r1.getupperLeftPoint());

		// 8
		r1.setHeight(10);
		r1.setWidth(15);
		c1.getCenter().setX(r1.area() - l1.getStartPoint().getY());
		
		
		//vezbe 4
		
		point p2 = new point();
		Line l2 = new Line();
		Circle1 c2 = new Circle1();
		
		c2.getCenter().setX((int)(c2.getRadius()+l2.getStartPoint().distance(l2.getEndPoint().getX(),l2.getEndPoint().getY())));
		
		
		System.out.println("Vezbe 4");
		point p4 = new point(10,15);
		point p5 = new point(15,20,true);
		System.out.println(p4.getX());
		System.out.println(p5.isSelected());
		
		//za tacku poziva toString() i ispisuje koordinate tacke dok za liniju ispisuje referencu (nismo jos redefinisali toString() u liniji)
		System.out.println(p4.toString());
		System.out.println(p4);
		System.out.println(l1);
			
				
		//nakon definisanja equals(...) metode
		//razlicite vrednosti i razlicite reference
		
		System.out.println(p4.equals(p5));
		System.out.println(p4==p5);
		System.out.println(p4==p5);
				
		//dodela vrednosti i reference
				p4=p5;	
			
		//iste vrednosti i iste reference
		System.out.println(p4.equals(p5));	
		System.out.println(p4==p5);

		
		//iste vrednosti, ali razlicite reference zbog operatora NEW	
	    point p6 = new point(10,15);
	    point p7 = new point(10,15);
	    System.out.println(p6==p7);
	    System.out.println(p6.equals(p7));		
			
		
		
		
		
	}

}
