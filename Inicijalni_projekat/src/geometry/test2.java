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
		
		System.out.println("Udaljenost je: "+p.distance(15, 25));

	}

}
