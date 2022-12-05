package model;


import events.SatelitteMoveListener;
import events.SatelliteMoved;


public class Antenne extends Element implements SatelitteMoveListener {

	private final SynchronisationAntenneSatellite synchro;

	public Antenne() {
		super();
		synchro = new SynchronisationAntenneSatellite();
	}

	@Override
	public void whenSatelitteMoved(SatelliteMoved arg) {
		synchro.whenSatelitteMoved(arg, this);
	}


	@Override
	public void action(){
		synchro.action(this);
	}
}
