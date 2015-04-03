import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x1, x2, y1, y2;
		Point p1;
		Point p2;
		Rectangle rec;
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrer le nombre de rectangles à génerer ");
		int n = sc.nextInt();
		ArrayList<Rectangle> map = new ArrayList<Rectangle>();

		System.out.print("Pour " + n + " rectangles: \n");

		for (int i = 0; i < n; i++) {
			x1 = (int) (Math.random() * 10000);
			x2 = (int) ( x1 + 40); //HACK
			y1 = (int) (Math.random() * 10000);
			y2 = (int) (y1 + 40);

			p1 = new Point(x1, y1);
			p2 = new Point(x2, y2);
			rec = new Rectangle(p1, p2);
			//System.out.println("Rectangle " + i +" : P1(" + x1 + " , " + y1 + "), P2(" + x2 + " , " + y2 + ")" );
			map.add(rec);

		}
		System.out.println("Les " + map.size() + " ont été générés");

		long time = System.currentTimeMillis();
		pairAPair(map);
		System.out.println(System.currentTimeMillis() - time + " ms");
		time = System.currentTimeMillis();
		balayage(map);
		System.out.println(System.currentTimeMillis() - time + " ms");	
	}
	
	public static void pairAPair(ArrayList<Rectangle> map){
		Rectangle current = null;
		int nb = 0;
		int count = 0;
		for(int i = 0; i < map.size(); i++){
			current = map.get(i);
			for(int j = i + 1 ; j < map.size(); j++){
				count++;
				if(current.intersectWith(map.get(j))){
					//System.out.println("Intersection avec Rectagle " + i + " et " + j);
					nb++;
				}
			}
		}
		System.out.println("Nombre de comparaisons : " + count + ", Intersections : " + nb);
	}

	public static void balayage(ArrayList<Rectangle> map){
		Collections.sort(map);
		int nb = 0;
		Rectangle current = null;
		Rectangle compared = null;
		int count = 0;
		for(int i = 0; i < map.size(); i++){
			current = map.get(i);
			for(int j = i + 1 ; j < map.size(); j++){
				count++;
				compared =  map.get(j);
				/*
				System.out.println("--------------------------------------------------------------");
				System.out.println(current.getPointDroit().getX());
				System.out.println(compared.getPointGauche().getX());
				*/
				if(current.getPointDroit().getX() < compared.getPointGauche().getX())
					break;
				if(current.intersectWith(compared)){
					//System.out.println("Intersection avec Rectagle " + i + " et " + j);
					nb++;
				}
			}
		}
		System.out.println("Nombre de comparaisons : " + count + ", Intersections : " + nb);
	}
}
