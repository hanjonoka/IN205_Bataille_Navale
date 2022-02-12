package ensta;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import ensta.model.Board;
import ensta.model.Coords;
import ensta.model.Hit;
import ensta.model.Player;
import ensta.model.ship.AbstractShip;
import ensta.model.ship.BattleShip;
import ensta.model.ship.Carrier;
import ensta.model.ship.Destroyer;
import ensta.model.ship.Submarine;
import ensta.util.Orientation;

public class TestBoard {
	public static void main(String[] args) {
		Board board = new Board("testboard",10);
//		board.putShip(new BattleShip(Orientation.NORTH), new Coords(4,3));
//		board.putShip(new Carrier(Orientation.WEST), new Coords(6,3));
		board.print();
		Player player = new Player(board,board,Arrays.asList(new AbstractShip[] { new Destroyer()})); //, new Submarine(), new Submarine(), new BattleShip(), new Carrier() }));
		player.putShips();
		
		Coords coords = new Coords();
		Hit hit;
		hit = player.sendHit(coords);
		System.out.println(hit + " at " + coords);
		player.getBoard().setHit(player.getOpponentBoard().getHit(coords), coords);;
		board.print();
		
		hit = player.sendHit(coords);
		player.getBoard().setHit(player.getOpponentBoard().getHit(coords), coords);;
		System.out.println(hit + " at " + coords);
		board.print();

		hit = player.sendHit(coords);
		player.getBoard().setHit(player.getOpponentBoard().getHit(coords), coords);;
		System.out.println(hit + " at " + coords);
		board.print();

		hit = player.sendHit(coords);
		player.getBoard().setHit(player.getOpponentBoard().getHit(coords), coords);;
		System.out.println(hit + " at " + coords);
		board.print();

		hit = player.sendHit(coords);
		player.getBoard().setHit(player.getOpponentBoard().getHit(coords), coords);;
		System.out.println(hit + " at " + coords);

		board.print();
	}
}
