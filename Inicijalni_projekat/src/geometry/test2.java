package geometry;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Kreiranje objekta");
		Point p = new Point();
		//System.out.println(p.x + " " + p.y + " "+p.selected);
		System.out.println(p.getX());
		
		p.setX(10);
		
		p.setY(20);
		
		System.out.println("Udaljenost je: " +p.distance(15, 25));
		
		
		//vezbe 3
		//point p => x=10, y=20
		p.setSelected(true);
		Point p1= new Point();
		
		p1.setX(20);
		p1.setY(25);
		
		line l1 = new line();
		System.out.println(l1.getStartPoint()+ " "+ l1.getEndPoint());
		System.out.println(l1.isSelected());
		
		Rectangle r1=new Rectangle();
		Circle c1 = new Circle();
		
		
		System.out.println(p.getX());
		p.setX(p1.getY());
		System.out.println(p.getX());
		
		
	    l1.setStartPoint(p);
	    l1.setEndPoint(p1);
	    System.out.println(l1.getEndPoint().getX()+ " "+ l1.getStartPoint().getY());
	    System.out.println(l1.getEndPoint().getX()+ " "+ l1.getEndPoint().getY());
	    
	    
	    l1.getEndPoint().setY(23);
	    l1.getStartPoint().setX(l1.getEndPoint().getY());
	    l1.getEndPoint().setX((int)(l1.length()-(l1.getStartPoint().getX()+l1.getStartPoint().getY())));
	    
	  
	    
	    //r1.getUpperLeftPoint().setX(10);
	    r1.setUpperLeftPoint(p);
	   // r1.setUpperLeftPoint(new Point(p.getX(),p.getY()));  ignorisi
	    r1.getUpperLeftPoint().setX(10);
	    r1.getUpperLeftPoint().setY(15);
	    
	    
	    
	    
	    c1.setCenter(r1.getUpperLeftPoint());
	    
	   
	    r1.setHeight(10);
	    r1.setWidth(15);
	    c1.getCenter().setX(r1.area()-l1.getStartPoint().getY());
	    
		
		
		
		
		
		

	}

}
