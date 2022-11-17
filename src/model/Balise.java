package model;

import events.SatelitteMoveListener;
import events.SatelliteMoved;

public class Balise extends ElementMobile implements SatelitteMoveListener{
	
	public Balise(int memorySize) {
		super(memorySize);
	}
	
	public int profondeur() { 
		return this.getPosition().y; 
	}


	/**
	 * Tant que la balise n'est pas à la surface et que sa mémoire n'est pas pleine,
	 * la balise récolte des données
	 */
	protected void readSensors() {
		if(this.profondeur() > 0 && !this.memoryFull()) {
			this.dataSize++;
		}
	}

	/**
	 * Recolte les données et si la mémoire est pleine, la balise remonte pour transferer ses données
	 * au satellite et sa mémoire est réinitialisée
	 */
	public void tick() {
		if (this.memoryFull()) {
			Deplacement redescendre = new Redescendre(this.deplacement(), this.profondeur());
			Deplacement deplSynchro = new DeplSynchronisation(redescendre);
			Deplacement nextDepl = new MonteSurfacePourSynchro(deplSynchro);
			this.setDeplacement(nextDepl);
			this.resetData();
		} else {
			this.readSensors();
		}
		super.tick();
	}

	@Override
	public void whenSatelitteMoved(SatelliteMoved arg) {
		DeplacementBalise dp = (DeplacementBalise) this.depl;
		dp.whenSatelitteMoved(arg, this);
	}
}
