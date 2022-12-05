package model;

import java.awt.Point;

import events.PositionChanged;

public class ElementMobile extends Element{
	private Deplacement depl;
	private Point position;
	private final int memorySize;
	private int dataSize;

	public ElementMobile(int memorySize) {
		super();
		this.memorySize = memorySize;
		this.dataSize = 0;
	}

	public void setDataSize(int dataSize){
		this.dataSize = dataSize;
	}

	public int getDataSize() {
		return this.dataSize;
	}

	public int getMemorySize() {
		return this.memorySize;
	}

	public Deplacement deplacement() {
		return depl;
	}

	protected void resetData() {
		this.dataSize = 0;
	}

	protected boolean memoryFull() {
		return (this.dataSize >= this.memorySize);
	}

	@Override
	public void action() {
		this.depl.bouge(this);
		this.send(new PositionChanged(this));
	}

	public void setDeplacement(Deplacement depl) {
		this.depl = depl;
	}

}
