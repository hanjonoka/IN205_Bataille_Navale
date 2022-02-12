package ensta.model.ship;

import ensta.model.Hit;
import ensta.util.Orientation;

public class Submarine extends AbstractShip {
	public Submarine(char label, String name, int length, Orientation orientation) {
		super(label, name, length, orientation);
	}
	
	public Submarine(Orientation o) {
		this('B', "Submarine", 4, o);
	}

	public Submarine() {
		this('S', "Submarine", 3, Orientation.EAST);
	}

	@Override
	public Hit getHitType() {
		return Hit.SUBMARINE;
	}

}
