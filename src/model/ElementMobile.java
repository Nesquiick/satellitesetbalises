package model;

import java.awt.Point;

import eventHandler.AbstractEvent;
import eventHandler.EventHandler;
import events.PositionChanged;

public class ElementMobile {
	private Deplacement depl;
	private Point position;
	private final EventHandler eventHandler;
	private final int memorySize;
	private int dataSize;
	private Manager manager;

	public ElementMobile(int memorySize) {
		eventHandler = new EventHandler();
		this.memorySize = memorySize;
		this.dataSize = 0;
		this.position = new Point(0, 0);
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
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	protected void resetData() {
		this.dataSize = 0;
	}

	protected boolean memoryFull() {
		return (this.dataSize >= this.memorySize);
	}

	public void registerListener(Class<? extends AbstractEvent> whichEventType, Object listener) {
		eventHandler.registerListener(whichEventType, listener);
	}

	public void unregisterListener(Class<? extends AbstractEvent> whichEventType, Object listener) {
		eventHandler.unregisterListener(whichEventType, listener);
	}

	public void send(AbstractEvent event) {
		eventHandler.send(event);
	}

	public void tick() {
		this.bouge();
	}

	public void bouge() {
		this.depl.bouge(this);
		this.send(new PositionChanged(this));
	}

	public void setPosition(Point position) {
		if (this.position.equals(position))
			return;
		this.position = position;
	}

	public Point getPosition() {
		return position;
	}

	public void setDeplacement(Deplacement depl) {
		this.depl = depl;
	}

	public Manager getManager() {
		return manager;
	}

}
