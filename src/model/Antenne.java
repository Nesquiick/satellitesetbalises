package model;


import events.SatelitteMoveListener;
import events.SatelliteMoved;


public class Antenne extends ElementMobile implements SatelitteMoveListener {

	private SynchronisationAntenneSatellite synchro;

	public Antenne(int memorySize) {
		super(memorySize);
		synchro = new SynchronisationAntenneSatellite();
	}

	@Override
	public void whenSatelitteMoved(SatelliteMoved arg) {
		synchro.whenSatelitteMoved(arg, this);
	}


	@Override
	public void bouge(){
		synchro.bouge(this);
	}
}
