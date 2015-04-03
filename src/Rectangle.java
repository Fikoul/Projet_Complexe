public class Rectangle implements Comparable<Rectangle>{

	private Point pointGauche;
	private Point pointDroit;

	public Rectangle(Point gauche, Point droit) {
		this.pointGauche = gauche;
		this.pointDroit = droit;

	}
	
	public boolean intersectWith(Rectangle r2) {
		return (
					( this.getPointGauche().getX() < r2.getPointGauche().getX() && this.getPointDroit().getX() > r2.getPointGauche().getX() )
						||
					(this.getPointGauche().getX() < r2.getPointDroit().getX() && this.getPointDroit().getX() > r2.getPointDroit().getX())
				) && (
					( this.getPointGauche().getY() < r2.getPointGauche().getY() && this.getPointDroit().getY() > r2.getPointGauche().getY() ) 
						||
					(this.getPointGauche().getY() < r2.getPointDroit().getY() && this.getPointDroit().getY() > r2.getPointDroit().getY())
				);
	}
	
	@Override
	public int compareTo(Rectangle r2) {
		return  this.getPointGauche().getX() - r2.getPointGauche().getX(); 
	}

	public Point getPointGauche() {
		return pointGauche;
	}

	public void setPointGauche(Point pointGauche) {
		this.pointGauche = pointGauche;
	}

	public Point getPointDroit() {
		return pointDroit;
	}

	public void setPointDroit(Point pointDroit) {
		this.pointDroit = pointDroit;
	}

}