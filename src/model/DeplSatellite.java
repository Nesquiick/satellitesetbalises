package model;

import java.awt.Point;

/**
 * Déplacements horizontaux des satellites en fonction d'une vitesse donnée
 */
public class DeplSatellite extends Deplacement {
	private final Integer start;
	private final Integer end;
	private final int vitesse;

	public DeplSatellite(Integer start, Integer end, int vitesse) {
		this.start = start;
		this.end = end;
		this.vitesse = vitesse;
	}
	
	@Override
	public void bouge(ElementMobile target) {
		Point p = target.getPosition();
		int x = p.x;
		x += vitesse;
		if (x > end) x = start;
		target.setPosition(new Point(x, p.y));
	}

}
