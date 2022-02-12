package ensta.model.ship;

import ensta.model.Hit;
import ensta.util.Orientation;

public abstract class AbstractShip {
	
	protected char label;
	protected String name;
	protected int length;
	protected Orientation orientation;
	
	private int strikeCount = 0;

	public AbstractShip(char label, String name, int length, Orientation orientation) {
		super();
		this.label = label;
		this.name = name;
		this.length = length;
		this.orientation = orientation;
	}

	public boolean isSunk() {
		return this.strikeCount>=this.length;
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public void addStrike() {
		this.strikeCount ++;
	}

	public char getLabel() {
		return label;
	}

	public String getName() {
		return name;
	}

	public int getLength() {
		return this.length;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}
	
	abstract public Hit getHitType();
}
