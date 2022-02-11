package ensta.model.ship;

import ensta.util.Orientation;

public class Destroyer extends AbstractShip {
	public Destroyer(char label, String name, int length, Orientation orientation) {
		super(label, name, length, orientation);
	}

	public Destroyer() {
		this('D', "Destroyer", 2, Orientation.EAST);
	}

}
