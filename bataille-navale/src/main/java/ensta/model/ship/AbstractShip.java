package ensta.model.ship;

import ensta.util.Orientation;

public class AbstractShip {
	String name;
	int Length;
	Orientation orientation;
	
	public AbstractShip() {
		
	}

	public boolean isSunk() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return Length;
	}

	public void setLength(int length) {
		Length = length;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	
}
