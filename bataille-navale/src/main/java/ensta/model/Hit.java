package ensta.model;
import java.util.NoSuchElementException;

import ensta.util.ColorUtil;
import ensta.util.ColorUtil.Color;

public enum Hit {
    MISS(-1, ColorUtil.colorize("X", ColorUtil.Color.WHITE)),
    STRIKE(-2, ColorUtil.colorize("X", ColorUtil.Color.RED)),
    DEFAULT(0, "."),
    DESTROYER(2, "Frégate"),
    SUBMARINE(3, "Sous-marin"),
    BATTLESHIP(4, "Croiseur"),
    CARRIER(5, "Porte-avion");

    /* ***
     * Attributs
     */
    private int value;
    private String label;

    /* ***
     * Constructeur
     */
    Hit(int value, String label) {
        this.value = value;
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
        return this.label;
    }
};
