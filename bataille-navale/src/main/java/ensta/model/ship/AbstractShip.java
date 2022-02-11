package ensta.model.ship;

import ensta.util.Orientation;

public class AbstractShip {
	
	protected char label;
	protected String name;
	protected int length;
	protected Orientation orientation;

	public AbstractShip(char label, String name, int length, Orientation orientation) {
		super();
		this.label = label;
		this.name = name;
		this.length = length;
		this.orientation = orientation;
	}

	public boolean isSunk() {
		// TODO Auto-generated method stub
		return false;
	}

	public char getLabel() {
		return label;
	}

	public String getName() {
		return name;
	}

	public int getLength() {
		return this.length;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
}
