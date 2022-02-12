package ensta.model;

import java.util.Arrays;

import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;
import ensta.util.Frappe;

public class Board implements IBoard {

	private static final int DEFAULT_SIZE = 10;
	private int size;
	
	private Hit[][] hitGrid;
	private ShipState[][] navGrid;
	
	private String nom;
	
	public Board(String nom, int size) {
		this.size=size;
		this.nom = nom;
		hitGrid = new Hit[size][size];
		navGrid = new ShipState[size][size];
		for(Hit[] row: hitGrid) {
			for(int i=0; i<this.size; i++) {
				row[i] = Hit.DEFAULT;
			}
		}
		for(ShipState[] row: navGrid) {
			for(int i=0; i<this.size; i++){
				row[i] = new ShipState();
			}
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
			System.out.print((i) + " ");
			if(i+1<10) System.out.print(" ");
			for(int j=0;j<this.size;j++) {
				System.out.print(navGrid[i][j] + " ");
			}
			System.out.print(" " + (i) + " ");
			if(i+1<10) System.out.print(" ");
			for(int j=0;j<this.size;j++) {
				System.out.print(hitGrid[i][j] + " ");
			}
			System.out.println("");
		}
		
	}

	public boolean canPutShip(AbstractShip ship, Coords coords) {
		Orientation o = ship.getOrientation();
		int dx = 0, dy = 0;
		if(coords.getX()<0 || coords.getY()<0 || coords.getX()>=this.size || coords.getY()>=this.size) {
			return false;
		}
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
		if(this.canPutShip(ship, coords)) {
			switch(ship.getOrientation()) {
			case EAST:
				for(int i=0; i<ship.getLength();i++) {
					navGrid[coords.getY()][coords.getX()+i].setShip(ship);
				}
				break;
			case NORTH:
				for(int i=0; i<ship.getLength();i++) {
					navGrid[coords.getY()-i][coords.getX()].setShip(ship);					
				}
				break;
			case WEST:
				for(int i=0; i<ship.getLength();i++) {
					navGrid[coords.getY()][coords.getX()-i].setShip(ship);					
				}
				break;
			case SOUTH:
				for(int i=0; i<ship.getLength();i++) {
					navGrid[coords.getY()+i][coords.getX()].setShip(ship);					
				}
				break;
			default:
				return false;
			}
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean hasShip(Coords coords) {
		return this.navGrid[coords.getY()][coords.getX()].getShip() != null;
	}
	
	public char getCase(Coords coords) {
		return this.navGrid[coords.getY()][coords.getX()].getShip().getLabel();
	}

	@Override
	public void setHit(boolean hit, Coords coords) {
		if(hit) {
			this.hitGrid[coords.getY()][coords.getX()] = Hit.STRIKE;
		}else {
			this.hitGrid[coords.getY()][coords.getX()] = Hit.MISS;			
		}
	}

	@Override
	public Boolean getHit(Coords coords) {
		return this.navGrid[coords.getY()][coords.getX()].isStruck();
	}

	@Override
	public Hit sendHit(Coords res) {
		if(this.hasShip(res)) {
			this.navGrid[res.getY()][res.getX()].addStrike();
			if(this.navGrid[res.getY()][res.getX()].getShip().isSunk()) {
				System.out.println(this.navGrid[res.getY()][res.getX()].getShip().getHitType()+" coulé !");
				return this.navGrid[res.getY()][res.getX()].getShip().getHitType();
			}else {
				return Hit.STRIKE;
			}
		}else {
			return Hit.MISS;
		}
	}
	
}
