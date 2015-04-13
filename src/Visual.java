import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;


public class Visual extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Rectangle> list;
	private double rapport;

	public Visual(ArrayList<Rectangle> list, double rapport){
		this.list = list;
		this.rapport = rapport;
		System.out.println(rapport);
	}

	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for (Rectangle rec: list) {
        	Random rand = new Random();
        	float r = (float) (rand.nextFloat());
        	float gc = (float) (rand.nextFloat());
        	float b = (float) (rand.nextFloat());
        	g.setColor(new Color(r, gc, b));
            g.drawRect((int) (rec.getPoint().getX() * rapport), (int) (rec.getPoint().getY() * rapport),
            		(int) (rec.getLargeur() * rapport), (int) (rec.getHauteur() * rapport));
            g2.drawString(rec.identifier+"", (int)(rec.getPoint().getX() * rapport), (int)(rec.getPoint().getY() * rapport - 10));
        }
    }
}
