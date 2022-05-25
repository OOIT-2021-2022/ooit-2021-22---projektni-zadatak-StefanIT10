package geometry;

import java.util.Arrays;

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
		
		point p2 = new point(50,100);
		Line l2 = new Line(p2, new point(400,500));
		Circle1 c2 = new Circle1();
		
		//c2.getCenter().setX((int)(c2.getRadius()+l2.getStartPoint().distance(l2.getEndPoint().getX(),l2.getEndPoint().getY())));
		
		
		System.out.println("\nVezbe 4");
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
			
		
		
	  //ZADATAK - testirati konstruktore, toString() i equals(...) metode
		
	    
	    //vezbe 5
	    point clickPoint= new point(12,17);
	    System.out.println(p7.contains(clickPoint.getX(), clickPoint.getY()));
		//System.out.println(lin.contains(clickPoint.getX(), clickPoint.getY()));
	    
	    
	    Donut donut = new Donut(new point(12,17), 20,10,true);
	    System.out.println(donut.toString());
		System.out.println(donut instanceof Circle1);
		System.out.println(donut instanceof Donut);
		System.out.println(c2 instanceof Donut);
		
		//Vezbe 6
		Shape shape=new point(10,15);
		System.out.println(shape);
		
		
		//Vezbe 7
		point p10 = new point(55,70);
		p10.moveBy(10, 20);
		System.out.println(p10);
		p10.moveTo(100, 200);
		System.out.println(p10);
		
		Circle1 movedCircle = new Circle1(new point(20, 30), 15);
		movedCircle.moveBy(5, 10);
		System.out.println(movedCircle);
		movedCircle.moveTo(15, 15);
		System.out.println(movedCircle);
		
		//Comparable
		p10.compareTo(clickPoint);
		
		
		Line linija1 = new Line(new point(10,15), new point(20,25));
		Line linija2 = new Line(new point(15,20), new point(25,25));
		Line linija3 = new Line(new point(10,25), new point(30,40));
		Line[] linije = {linija1, linija2, linija3};
		
	    System.out.println("Niz linija pre sortiranja: ");
	    
	    for(int i=0;i<linije.length;i++) {
	    	System.out.println(linije[i]);
	    }
	    
	    Arrays.sort(linije);
	    
	    System.out.println("Niz linija posle sortiranja: ");
	    
	    for(int i=0; i<linije.length; i++) {
	    	System.out.println(linije[i]);
	    }
	    
	    
	    Rectangle2 pravougaonik1 = new Rectangle2(new point(10,15), 10, 15);
	    Rectangle2 pravougaonik2 = new Rectangle2(new point(10,15), 30, 40);
	    Rectangle2 pravougaonik3 = new Rectangle2(new point(10,15), 10, 10);
	    Rectangle2[] pravougaonici = {pravougaonik1, pravougaonik2, pravougaonik3};
	    
	    System.out.println("Niz pravougaonika pre sortiranja: ");
	    
	    for(int i=0;i<pravougaonici.length;i++) {
	    	System.out.println(pravougaonici[i]);
	    }
	    
	    Arrays.sort(pravougaonici);
	    
        System.out.println("Niz pravougaonika posle sortiranja: ");
	    
	    for(int i=0; i<pravougaonici.length; i++) {
	    	System.out.println(pravougaonici[i]);
	    }
	    
	    
	    //svi oblici u jednoj listi
	    Shape[] oblici = {pravougaonik1, pravougaonik2, linija2, linija3};
	       for(int i=0; i<oblici.length; i++) 
	       oblici[i].moveBy(10, 15);
	      
	      
	    
	       
	       
	       
	       
	       
	    
	}

}
