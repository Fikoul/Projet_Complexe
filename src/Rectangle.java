public class Rectangle implements Comparable<Rectangle>{

	private static int next_id = 0;
	
	public int identifier;
	
	private Point point;

	private int largeur;

	private int hauteur;

	public Rectangle(Point point, int largeur, int hauteur) {
		this.point = point;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.identifier = next_id;
		next_id++;

	}
	public boolean intersectWith(Rectangle r2) {
		boolean x = (this.getPoint().getX() <= r2.getPoint().getX() + r2.largeur)    && (r2.getPoint().getX() <= this.getPoint().getX()+this.largeur);
		boolean y = (this.getPoint().getY() <= r2.getPoint().getY()+r2.getHauteur()) && (r2.getPoint().getY() <= this.getPoint().getY()+this.hauteur);
		 
		return x && y;
	}
	
	@Override
	public int compareTo(Rectangle r2) {
		return  this.getPoint().getX() - r2.getPoint().getX(); 
	}

	public Point getPoint() {
		return point;
	}
	
	public int getLargeur() {
		return largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

}