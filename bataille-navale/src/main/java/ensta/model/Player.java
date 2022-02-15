package ensta.model;

import java.io.Serializable;
import java.util.List;

import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;
import ensta.view.InputHelper;
import ensta.model.Coords;

public class Player {
	/*
	 * ** Attributs
	 */
	private Board board;
	protected Board opponentBoard;
	private int destroyedCount;
	protected AbstractShip[] ships;
	private boolean lose;

	/*
	 * ** Constructeur
	 */
	public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
		this.setBoard(board);
		this.ships = ships.toArray(new AbstractShip[0]);
		this.opponentBoard = opponentBoard;
	}

	/*
	 * ** Méthodes
	 */

	/**
	 * Read keyboard input to get ships coordinates. Place ships on given
	 * coodrinates.
	 */
	public void putShips() {
		boolean done = false;
		int i = 0;

		do {
			AbstractShip ship = ships[i];
			String msg = String.format("placer %d : %s(%d)", i + 1, ship.getName(), ship.getLength());
			System.out.println(msg);
			InputHelper.ShipInput res = InputHelper.readShipInput();

			switch(res.orientation) {
			case "north":
				ship.setOrientation(Orientation.NORTH);
				break;
			case "south":
				ship.setOrientation(Orientation.SOUTH);
				break;
			case "east":
				ship.setOrientation(Orientation.EAST);
				break;
			case "west":
				ship.setOrientation(Orientation.WEST);
				break;
			default:
				System.err.println("wrong orientation error");
			}
			if(!board.putShip(ship, new Coords(res.x, res.y))) {
				System.err.println("can't put the ship here ! chose another spot.");
			}else{
				++i;
				done = i == ships.length;
	
				board.print();
			}
		} while (!done);
	}

	public Hit sendHit(Coords coords) {
		boolean done = false;
		Hit hit = null;

		do {
			System.out.println("où frapper?");
			InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
			coords.setCoords(hitInput.x, hitInput.y);

			if(coords.isInBoard(board.getSize())) {
				hit = this.opponentBoard.sendHit(coords);
				
				done = true;
			}else {
				System.err.println("Coordinates out of board !");
			}

			// Game expects sendHit to return BOTH hit result & hit coords.
			// return hit is obvious. But how to return coords at the same time ?
			// Change coords value with setCoords so Game can retrieve it.
		} while (!done);

		return hit;
	}

	public Board getOpponentBoard() {
		return opponentBoard;
	}

	public AbstractShip[] getShips() {
		return ships;
	}

//	public void setShips(AbstractShip[] ships) {
//		this.ships = ships;
//	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getDestroyedCount() {
		return destroyedCount;
	}

	public void setDestroyedCount(int destroyedCount) {
		this.destroyedCount = destroyedCount;
	}

	public boolean isLose() {
		return lose;
	}

	public void setLose(boolean lose) {
		this.lose = lose;
	}
}
