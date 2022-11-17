package model;

import events.SatelliteMoved;

public class Satellite extends ElementMobile {
			
	public Satellite(int memorySize) {
		super(memorySize);
	}

	protected void addData(int data) {
		this.setDataSize(this.getDataSize()+data);
	}
	
	public void bouge () {
		super.bouge();
		this.send(new SatelliteMoved(this));
	}
}
