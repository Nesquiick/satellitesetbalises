package views;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import events.*;
import model.ElementMobile;
import nicellipse.component.NiRectangle;

import javax.swing.*;

public class GrElementMobile extends NiRectangle implements PositionChangeListener, SynchroEventListener, SynchroSatelliteEventListener  {
	private static final long serialVersionUID = -5422724191168577346L;
	ElementMobile model;
	GrEther ether;
	Boolean duringSynchro = false;
	
	public GrElementMobile(GrEther ether) {
		this.ether = ether;
		this.setBorder(null);
		this.setBackground(null);
		this.setOpaque(false);
	}

	Object getModel() { return this.model; }
	
	public void setModel(ElementMobile model) {
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