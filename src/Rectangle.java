public class Rectangle {
	Point pointgauche;
	Point pointdroit;
		
		public Rectangle(Point i, Point j)
		{
					pointgauche=j;
					pointdroit=i;
					
					System.out.println("\n Le point en bas a gauche est:");
					pointgauche.printpoint();
					
					System.out.println("Le Point en haut a droite est");
					pointdroit.printpoint();
				
		}
		
}
