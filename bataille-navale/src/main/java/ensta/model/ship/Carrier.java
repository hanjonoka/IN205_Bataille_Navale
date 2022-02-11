package ensta.model.ship;

import ensta.util.Orientation;

public class Carrier extends AbstractShip {
	public Carrier(char label, String name, int length, Orientation orientation) {
		super(label, name, length, orientation);
	}

	public Carrier() {
		this('C', "Carrier", 5, Orientation.EAST);
	}

}
