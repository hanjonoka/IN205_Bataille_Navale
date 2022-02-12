package ensta.model;
import java.util.NoSuchElementException;

import ensta.util.ColorUtil;
import ensta.util.ColorUtil.Color;

public enum Hit {
    MISS(-1, ColorUtil.colorize("X", ColorUtil.Color.WHITE), "manqué"),
    STRIKE(-2, ColorUtil.colorize("X", ColorUtil.Color.RED), "touché"),
    DEFAULT(0, ".", "default"),
    DESTROYER(2, "F", "Frégate"),
    SUBMARINE(3, "S", "Sous-marin"),
    BATTLESHIP(4, "B", "Croiseur"),
    CARRIER(5, "C", "Porte-avion");

    /* ***
     * Attributs
     */
    private int value;
    private String label;
    private String print;

    /* ***
     * Constructeur
     */
    Hit(int value, String print, String label) {
        this.value = value;
        this.print = print;
        this.label = label;
    }

    /* ***
     * Méthodes
     */
    public static Hit fromInt(int value) {
        for (Hit hit : Hit.values()) {
            if (hit.value == value) {
                return hit;
            }
        }
        throw new NoSuchElementException("no enum for value " + value);
    }

    public String toString() {
        return this.print;
    }

	public String getLabel() {
		return label;
	}
};
