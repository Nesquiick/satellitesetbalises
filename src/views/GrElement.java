package views;


import java.awt.Graphics;

import events.*;
import model.Element;
import nicellipse.component.NiRectangle;

public class GrElement extends NiRectangle implements PositionChangeListener, SynchroEventListener, SynchroSatelliteEventListener  {
	private static final long serialVersionUID = -5422724191168577346L;
	Element model;
	GrEther ether;
	Boolean duringSynchro = false;
	
	public GrElement(GrEther ether) {
		this.ether = ether;
		this.setBorder(null);
		this.setBackground(null);
		this.setOpaque(false);
	}

	Object getModel() { return this.model; }
	
	public void setModel(Element model) {
		this.model = model;
		model.registerListener(PositionChanged.class, this);
		model.registerListener(SynchroEvent.class, this);
		model.registerListener(SynchroSatelliteEvent.class, this);
		this.setLocation(this.model.getPosition());
		this.repaint();		
	}
	
	@Override
	public void whenStartSynchro(SynchroEvent arg) {
		duringSynchro = true;
		this.ether.startSync(this);	
	}

	@Override
	public void whenStopSynchro(SynchroEvent arg) {
		duringSynchro = false;
		this.ether.stopSync(this);	
	}

	@Override
	public void whenPositionChanged(PositionChanged arg) {
		this.setLocation(this.model.getPosition());
		this.repaint();				
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	@Override
	public void whenStartSynchro(SynchroSatelliteEvent arg) {
		duringSynchro = true;
		this.ether.startSync(this);
	}

	@Override
	public void whenStopSynchro(SynchroSatelliteEvent arg) {
		duringSynchro = false;
		this.ether.stopSync(this);
	}
}