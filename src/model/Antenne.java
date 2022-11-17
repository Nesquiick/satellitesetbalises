package model;


import java.awt.*;

public class Antenne extends ElementMobile{
	private Point position;

	public Antenne(int memorySize) {
		super(memorySize);
	}

	protected void addData(int data) {
		this.dataSize += data;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
}
