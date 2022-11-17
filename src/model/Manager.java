package model;

import java.util.ArrayList;

import events.SatelliteMoved;

public class Manager {
	private ArrayList<Satellite> sats = new ArrayList<Satellite>();
	private ArrayList<Balise> bals = new ArrayList<Balise>();
	private Antenne antenne;
	
	public void addBalise(Balise bal) {
		bals.add(bal);
		bal.setManager(this);
	}
	public void addSatellite(Satellite sat) {
		this.sats.add(sat);
		sat.setManager(this);
	}
	public void addAntenne(Antenne antenne) {
		this.antenne = antenne;
		antenne.setManager(this);
		this.antenneReadyForSynchro(antenne);
	}
	public void tick() {
		for (Balise b : this.bals) {
			b.tick();
		}
		for (Satellite s : this.sats) {
			s.tick();
		}
		antenne.tick();
	}

	/**
	 * Une fois que la balise est prête pour la synchronisation, les satellites vont enregistrer la balise en tant que
	 * listener afin que la balise puisse trouver un satellite proche d'elle pour se synchroniser
	 */
	public void baliseReadyForSynchro(Balise b) {
		for (Satellite s : this.sats) {			
			s.registerListener(SatelliteMoved.class, b);
		}
	}

	/**
	 * Une fois la synchronisation terminée, la balise n'a plus besoin d'être un listener des satellites
	 * @param b Balise à désinscrire des listeners
	 */
	public void baliseSynchroDone(Balise b) {
		for (Satellite s : this.sats) {			
			s.unregisterListener(SatelliteMoved.class, b);
		}
	}

	public void antenneReadyForSynchro(Antenne a) {
		for (Satellite s : this.sats) {
			s.registerListener(SatelliteMoved.class, a);
		}
	}

}
