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

	public Visual(ArrayList<Rectangle> list){
		this.list = list;
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
            g.drawRect(rec.getPoint().getX(), rec.getPoint().getY(), rec.getLargeur(),rec.getHauteur());
            g2.drawString(rec.identifier+"", rec.getPoint().getX(), rec.getPoint().getY() - 10);
        }
    }
}
