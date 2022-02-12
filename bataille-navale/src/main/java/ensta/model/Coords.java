package ensta.model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;

public class Coords {
	int x;
	int y;
	
	public Coords(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Coords(Coords coords) {
		this.x = coords.x;
		this.y = coords.y;
	}
	
	public Coords() {

	}
	
	public void setCoords(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setCoords(Coords res) {
		this.setCoords(res.getX(),res.getY());
	}

	public static Coords randomCoords(int size) {
		return new Coords(ThreadLocalRandom.current().nextInt(0,size+1),ThreadLocalRandom.current().nextInt(0,size+1));
	}

	public boolean isInBoard(int size) {
		// TODO Auto-generated method stub
		return (x>=0 && y>=0 && x<size && y<size);
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}

}
