package model;

import java.awt.*;

/**
 * Karte fürs Spielfeld
 *
 * @author Sarah Frischknecht
 * @version 1.0
 * @since 7.7.2021
 */
public class Card {

    private final int pointsNormalCard = 1;
    private int value;
    private Color backgroundcolor;

    /**
     * Konstruktor
     */
    public Card() {

    }

    /**
     * Setzt die Hintergrundfarbe in rgb
     * @param r rgb-Wert von r
     * @param g rgb-Wert von g
     * @param b rgb-Wert von b
     */
    public void setBackgroundcolor(int r, int g, int b) {
        this.backgroundcolor = new Color(r, g, b);
    }

    /**
     * Setzt den Wert der Karte
     * @param value Zahl, die auf der Karte angezeigt wird
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Getter von Backgroundcolor
     * @return Backgroundcolor der Karte
     */
    public Color getBackgroundcolor() {
        return backgroundcolor;
    }

    /**
     * Getter von Value
     * @return zahl, die auf der Karte angezeigt wird
     */
    public int getValue() {
        return value;
    }

    /**
     * Getter pointsCard
     * @return anz Punkte die die Karte als Paar gibt
     */
    public int getPointsCard() {
        return this.pointsNormalCard;
    }
}
