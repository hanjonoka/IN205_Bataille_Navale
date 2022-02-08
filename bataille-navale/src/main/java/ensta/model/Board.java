package ensta.model;

import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;
import ensta.util.Frappe;

public class Board implements IBoard {

	private static final int DEFAULT_SIZE = 10;
	private int size;
	
	private Frappe[][] charGrid;
	private boolean[][] boolGrid;
	
	private String nom;
	
	public Board(String nom, int size) {
		this.size=size;
		this.nom = nom;
	}
	
	public Board(String nom) {
		this.size = DEFAULT_SIZE;
		this.nom = nom;
	}

	public void print() {
		System.out.println("Navires :              Frappes :");
		
		//entête
		System.out.print(" ");
		for(int i=1;i<=this.size;i++) {
			System.out.print(i+" ");
		}
		System.out.print(" ");
		for(int i=1;i<=this.size;i++) {
			System.out.print(i+" ");
		}
		System.out.println("");

		//body
		for(int i=1;i<=this.size;i++) {
			String nLine = "";
			String fLine = "";
			for(int j=1;j<=this.size;j++) {
				//nLine
			}
		}
		
	}

	public boolean canPutShip(AbstractShip ship, Coords coords) {
		Orientation o = ship.getOrientation();
		int dx = 0, dy = 0;
		if (o == Orientation.EAST) {
			if (coords.getX() + ship.getLength() >= this.size) {
				return false;
			}
			dx = 1;
		} else if (o == Orientation.SOUTH) {
			if (coords.getY() + ship.getLength() >= this.size) {
				return false;
			}
			dy = 1;
		} else if (o == Orientation.NORTH) {
			if (coords.getY() + 1 - ship.getLength() < 0) {
				return false;
			}
			dy = -1;
		} else if (o == Orientation.WEST) {
			if (coords.getX() + 1 - ship.getLength() < 0) {
				return false;
			}
			dx = -1;
		}

		Coords iCoords = new Coords(coords);

		for (int i = 0; i < ship.getLength(); ++i) {
			if (this.hasShip(iCoords)) {
				return false;
			}
			iCoords.setX(iCoords.getX() + dx);
			iCoords.setY(iCoords.getY() + dy);
		}

		return true;
	}


	public int getSize() {
		return size;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public boolean putShip(AbstractShip ship, Coords coords) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasShip(Coords coords) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setHit(boolean hit, Coords coords) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean getHit(Coords coords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hit sendHit(Coords res) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
