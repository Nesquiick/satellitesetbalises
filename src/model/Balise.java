package model;

import events.SatelitteMoveListener;
import events.SatelliteMoved;

public class Balise extends ElementMobile implements SatelitteMoveListener{

	private Deplacement typeDeplacement;
	
	public Balise(int memorySize, Deplacement deplacement) {
		super(memorySize);
		this.typeDeplacement = deplacement;
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
			this.setDataSize(this.getDataSize()+1);
		}
	}

	/**
	 * Recolte les données et si la mémoire est pleine, la balise remonte pour transferer ses données
	 * au satellite et sa mémoire est réinitialisée
	 */
	public void tick() {
		if (this.memoryFull()) {
			Deplacement redescendre = new Redescendre(getTypeDeplacement());
			Deplacement deplSynchro = new DeplSynchronisation(redescendre);
			Deplacement nextDepl = new MonteSurfacePourSynchro(deplSynchro);
			this.setDeplacement(nextDepl);
		} else {
			this.readSensors();
		}
		super.tick();
	}

	@Override
	public void whenSatelitteMoved(SatelliteMoved arg) {
		DeplacementBalise dp = (DeplacementBalise) this.deplacement();
		dp.whenSatelitteMoved(arg, this);
	}

	public Deplacement getTypeDeplacement() {
		return typeDeplacement;
	}

	public void setTypeDeplacement(Deplacement typeDeplacement) {
		this.typeDeplacement = typeDeplacement;
	}
}
