package ensta;

import java.util.Arrays;
import java.util.List;

import ensta.ai.BattleShipsAI;
import ensta.model.Board;
import ensta.model.Coords;
import ensta.model.Player;
import ensta.model.ship.AbstractShip;
import ensta.model.ship.BattleShip;
import ensta.model.ship.Carrier;
import ensta.model.ship.Destroyer;
import ensta.model.ship.Submarine;

public class TestGame {
	public static void main(String[] args) {
		Board board = new Board("AI Board", 10);
		board.print();
		AbstractShip[] shipsList = new AbstractShip[] { new Destroyer(), new Submarine(), new Submarine(), new BattleShip(), new Carrier() };
		BattleShipsAI bsAI = new BattleShipsAI(board,board);
		System.out.println("puting ships");
		bsAI.putShips(shipsList);
		board.print();
		
		boolean done = false;
		while(!done) {
			Coords coords = new Coords();
			System.out.println(bsAI.sendHit(coords).getLabel() + " at " + coords);
			board.print();
			//si il reste un bateau non-coulé on continue
			done = true;
			for(AbstractShip ship: shipsList) {
				if(!ship.isSunk()) {
					done = false;
					break;
				}
			}
			
		}
	}
}
