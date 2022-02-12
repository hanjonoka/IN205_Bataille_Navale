package ensta.model.ship;

import ensta.model.Hit;
import ensta.util.Orientation;

public class Carrier extends AbstractShip {
	public Carrier(char label, String name, int length, Orientation orientation) {
		super(label, name, length, orientation);
	}
	
	public Carrier(Orientation o) {
		this('C', "Carrier", 5, o);
	}

	public Carrier() {
		this('C', "Carrier", 5, Orientation.EAST);
	}

	@Override
	public Hit getHitType() {
		return Hit.CARRIER;
	}

}
