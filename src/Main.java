import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int x1,x2,y1,y2;
		Point p1;
		Point p2;
		Rectangle rec;
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrer le nombre de rectangles à génerer ");
		int n=sc.nextInt();
		ArrayList<Rectangle> map= new ArrayList<Rectangle>();
		
		System.out.print("Pour "+ n +" rectangles: \n");
		
		
		
		for (int i=0; i<n;i++)
		{
			x1=(int) (Math.random() * 100 );
			x2=(int) (Math.random() * x1 );
			y1=(int) (Math.random() * 100 );
			y2=(int)(Math.random() * y1 );
			
			
			p1= new Point(x1,y1);
			p2=new Point(x2,y2);
			rec= new Rectangle(p1,p2);
			map.add(rec);

		}
		
		System.out.println("Les "+ map.size()+" ont été généré");

	}

}
