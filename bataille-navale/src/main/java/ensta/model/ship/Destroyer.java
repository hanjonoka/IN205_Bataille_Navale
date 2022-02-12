package ensta.model.ship;

import ensta.model.Hit;
import ensta.util.Orientation;

public class Destroyer extends AbstractShip {
	public Destroyer(char label, String name, int length, Orientation orientation) {
		super(label, name, length, orientation);
	}

	public Destroyer(Orientation o) {
		this('B', "Destroyer", 4, o);
	}

	public Destroyer() {
		this('D', "Destroyer", 2, Orientation.EAST);
	}

	@Override
	public Hit getHitType() {
		return Hit.DESTROYER;
	}

}
