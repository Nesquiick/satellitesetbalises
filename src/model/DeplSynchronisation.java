package model;

import events.SatelliteMoved;
import events.SynchroEvent;

public class DeplSynchronisation extends DeplacementBalise {
	private int synchroTime;
	private Satellite synchro;
	
	public Boolean synchroStarted() {
		return this.synchro != null;
	}
	
	public DeplSynchronisation(Deplacement next) {
		super(next);
		this.synchroTime = 10;
		this.synchro = null;
	}

	/**
	 * Lorsque le satellite bouge, on vérifie s'il n'est pas déjà en cours de synchronisation puis on compare la
	 * position du satellite par rapport à la balise.
	 * Si les deux sont proches, la synchronisation commence et les données de la balise sont transférées au satellite
	 * @param arg Satellite qui a bougé
	 * @param target balise
	 */
	@Override
	public void whenSatelitteMoved(SatelliteMoved arg, Balise target) {
		if (synchroStarted()) return;
		Satellite sat = (Satellite) arg.getSource();
		int satX = sat.getPosition().x;
		int tarX = target.getPosition().x;
		if ((satX > tarX - 10 && satX < tarX + 10)) {
			this.synchro = sat;
			target.send(new SynchroEvent(this));
			this.synchro.send(new SynchroEvent(this));
			sat.addData(target.getMemorySize());
			target.resetData();
		}
	}

	/**
	 * Si on est en train de synchroniser, on attend que le temps de synchronisation soit écoulé puis la balise
	 * passe à son déplacement suivant
 	 * @param target balise
	 */
	@Override
	public void bouge(Balise target) {
		if (this.synchro == null) return;
		this.synchroTime--;
		if (synchroTime <= 0) {
			Satellite sat = this.synchro;
			this.synchro = null;
			this.synchroTime = 10;
			target.send(new SynchroEvent(this));
			sat.send(new SynchroEvent(this));
			target.getManager().baliseSynchroDone(target);
			target.setDeplacement(next);
		}
	}
}
