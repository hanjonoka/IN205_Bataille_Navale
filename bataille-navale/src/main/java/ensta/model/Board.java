package ensta.model;

import java.util.Arrays;

import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;
import ensta.util.Frappe;

public class Board implements IBoard {

	private static final int DEFAULT_SIZE = 10;
	private int size;
	
	private Frappe[][] fGrid;
	private char[][] navGrid;
	
	private String nom;
	
	public Board(String nom, int size) {
		this.size=size;
		this.nom = nom;
		fGrid = new Frappe[size][size];
		navGrid = new char[size][size];
		for(Frappe[] row: fGrid) {
			Arrays.fill(row, Frappe.DEFAULT);
		}
		for(char[] row: navGrid) {
			Arrays.fill(row, '.');
		}
	}
	
	public Board(String nom) {
		this(nom,DEFAULT_SIZE);
	}

	public void print() {
		System.out.print("Navires :");
		for(int i=0; i<=2*this.size + 3 - 9;i++) System.out.print(" ");
		System.out.println("Frappes :");
		
		//entête
		System.out.print("   ");
		for(int i=1;i<=this.size;i++) {
			System.out.print((char)(i+64)+" ");
		}
		System.out.print("    ");
		for(int i=1;i<=this.size;i++) {
			System.out.print((char)(i+64)+" ");
		}
		System.out.println("");

		//body
		for(int i=0;i<this.size;i++) {
			System.out.print((i+1) + " ");
			if(i+1<10) System.out.print(" ");
			for(int j=0;j<this.size;j++) {
				System.out.print(navGrid[i][j] + " ");
			}
			System.out.print(" " + (i+1) + " ");
			if(i+1<10) System.out.print(" ");
			for(int j=0;j<this.size;j++) {
				System.out.print(fGrid[i][j] + " ");
			}
			System.out.println("");
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
