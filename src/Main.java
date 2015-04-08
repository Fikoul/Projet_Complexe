import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		

		Point p1;
		Point p2;
		Rectangle rec;
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrer le nombre de rectangles à génerer ");
		int n = sc.nextInt();
		ArrayList<Rectangle> map = new ArrayList<Rectangle>();

		System.out.print("Pour " + n + " rectangles: \n");

		int x, y, largeur, hauteur;
		for (int i = 0; i < n; i++) {
			x = (int) (Math.random() * 1000);
			y = (int) (Math.random() * 800);
			largeur = (int) ( Math.random() * 500);
			hauteur = (int) ( Math.random() * 400);


			p1 = new Point(x, y);
			rec = new Rectangle(p1, largeur, hauteur);
			map.add(rec);

		}		
		System.out.println("Les " + map.size() + " ont été générés");

		long time = System.currentTimeMillis();
		pairAPair(map);
		System.out.println(System.currentTimeMillis() - time + " ms");
		time = System.currentTimeMillis();
		balayage(map);
		System.out.println(System.currentTimeMillis() - time + " ms");	
		
		//Ajout en fin de command pour éviter tout interraction avec les algo
        
		JFrame feentre = new JFrame("Rectangles");
		JFrame window = new JFrame();
        window.setSize(1500,1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new Visual(map));
        window.setVisible(true);
	}
	
	public static void pairAPair(ArrayList<Rectangle> map){
		Rectangle current = null;
		Rectangle compared  = null;
		int nb = 0;
		int count = 0;
		for(int i = 0; i < map.size(); i++){
			current = map.get(i);
			for(int j = i + 1 ; j < map.size(); j++){
				compared = map.get(j);
				count++;
				if(current.intersectWith(compared)){
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

				if(current.getPoint().getX()  + current.getLargeur() < compared.getPoint().getX())
					break;
				if(current.intersectWith(compared)){
					nb++;
				}
			}
		}
		System.out.println("Nombre de comparaisons : " + count + ", Intersections : " + nb);
	}
}
