package ensta.model;

import ensta.model.ship.AbstractShip;
import ensta.util.ColorUtil;

public class ShipState {
	private AbstractShip ship;
	private boolean struck = false;
	
	public ShipState(AbstractShip ship) {
		this.ship = ship;
	}
	
	public ShipState() {
		
	}
	
	public void addStrike() {
		if(!struck) {
			this.struck = true;
			ship.addStrike();
		}
	}
	
	public boolean isStruck() {
		return struck;
	}

	public AbstractShip getShip() {
		return ship;
	}
	
	public boolean setShip(AbstractShip ship) {
		if(this.ship == null) {
			this.ship = ship;
			return true;
		}else{
			return false;
		}
	}
	
	public String toString() {
		if(this.ship != null) {
			if(this.struck) {
				return ColorUtil.colorize(this.ship.getLabel(),ColorUtil.Color.RED);
			}else {
				return ColorUtil.colorize(this.ship.getLabel(),ColorUtil.Color.WHITE);				
			}
		}else {
			return ".";
		}
	}
}
