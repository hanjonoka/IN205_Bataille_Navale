package ensta;

import java.util.List;

import ensta.model.Board;
import ensta.model.Coords;
import ensta.model.Player;
import ensta.model.ship.AbstractShip;
import ensta.model.ship.BattleShip;
import ensta.model.ship.Carrier;
import ensta.util.Orientation;

public class TestBoard {
	public static void main(String[] args) {
		Board board = new Board("testboard",10);
		board.putShip(new BattleShip(Orientation.NORTH), new Coords(4,3));
		board.putShip(new Carrier(Orientation.WEST), new Coords(6,3));
		board.print();
		List<AbstractShip> ships;
		Player player = new Player(board,board,ships);
	}
}
