package ensta.model.ship;

import ensta.util.Orientation;

public class BattleShip extends AbstractShip{
	public BattleShip(char label, String name, int length, Orientation orientation) {
		super(label, name, length, orientation);
	}

	public BattleShip() {
		this('B', "BattleShip", 4, Orientation.EAST);
	}
}
