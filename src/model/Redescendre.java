package model;

import java.awt.Point;
import java.util.Random;

public class Redescendre extends DeplacementBalise {
	int profondeur;
	
	public Redescendre(Deplacement next, int profondeur) {
		super (next);
		Random r = new Random();
		this.profondeur = r.nextInt(270);
	}
	
	@Override
	public void bouge(Balise target) {
		Point p = target.getPosition();
		int y = p.y;
		if (y < this.profondeur) {
			y += 3;
			if (y > this.profondeur) y = this.profondeur;
			target.setPosition(new Point(p.x, y));
		}  else {
			target.setDeplacement(next);
		}
	}

}
