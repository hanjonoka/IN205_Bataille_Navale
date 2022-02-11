package ensta.util;

public enum Frappe {
	DEFAULT("."), NOTHING("o"), HIT("x");
	String value;

	Frappe(String val) {
		this.value = val;
	}

	public String toString() {
		return this.value;
	}
	
}
