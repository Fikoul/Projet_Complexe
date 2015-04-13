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
		System.out.println("Type de données à tester");
		System.out.println("1) Rectangle aléatoire");
		System.out.println("2) Rectable de largeur et hauteur 1");
		System.out.println("3) Rectangle de largeur et hauteur entr 0 et √n");
		int choix = sc.nextInt();
		if(choix > 3 || choix < 1)
			System.exit(0);	//DUR mais c'est la vie
		System.out.print("Entrer le nombre de rectangles à génerer ");
		int n = sc.nextInt();
		ArrayList<Rectangle> list = new ArrayList<Rectangle>();

		System.out.print("Pour " + n + " rectangles: \n");

		int racine = 0;
		if(choix == 3)
			 racine = (int) Math.sqrt(n);
		int x, y, largeur = 0, hauteur = 0;
		for (int i = 0; i < n; i++) {
			x = (int) (Math.random() * n);
			y = (int) (Math.random() * n);
			switch (choix) {
			case 1:
				int x2 = (int) (Math.random() * n);
				int y2 = (int) (Math.random() * n);
				largeur = Math.abs(x2-x);
				hauteur = Math.abs(y2-y);
				x = Math.min(x, x2);
				y = Math.min(y, y2);
				break;
			case 2:
				largeur = 1;
				hauteur = 1;
				break;
			case 3:
				largeur = (int) ( Math.random() * racine);
				hauteur = (int) ( Math.random() * racine);
				break;
			}
			p1 = new Point(x, y);
			rec = new Rectangle(p1, largeur, hauteur);
			list.add(rec);

		}		
		System.out.println("Les " + list.size() + " ont été générés");

		long time = System.currentTimeMillis();
		pairAPair(list);
		System.out.println(System.currentTimeMillis() - time + " ms");
		time = System.currentTimeMillis();
		balayage(list);
		System.out.println(System.currentTimeMillis() - time + " ms");	
		
		//Ajout en fin de command pour éviter tout interraction avec les algo
        /*
		JFrame feentre = new JFrame("Rectangles");
		JFrame window = new JFrame();
        window.setSize(1500,1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new Visual(list));
        window.setVisible(true);
        */
		
	}
	
	public static void pairAPair(ArrayList<Rectangle> list){
		Rectangle current = null;
		Rectangle compared  = null;
		long nb = 0;
		long count = 0;
		for(int i = 0; i < list.size(); i++){
			current = list.get(i);
			for(int j = i + 1 ; j < list.size(); j++){
				compared = list.get(j);
				count++;
				if(current.intersectWith(compared)){
					nb++;
				}
			}
		}
		System.out.println("Nombre de comparaisons : " + count + ", Intersections : " + nb);
	}

	public static void balayage(ArrayList<Rectangle> list){
		Collections.sort(list);
		long nb = 0;
		Rectangle current = null;
		Rectangle compared = null;
		long count = 0;
		for(int i = 0; i < list.size(); i++){
			current = list.get(i);
			int sizeMax = current.getPoint().getX()  + current.getLargeur();
			for(int j = i + 1 ; j < list.size(); j++){
				count++;
				compared =  list.get(j);
				if(sizeMax < compared.getPoint().getX()){
					break;
				}
				
				if(current.intersectWith(compared)){
					nb++;
				}
			}
		}
		System.out.println("Nombre de comparaisons : " + count + ", Intersections : " + nb);
	}
}
