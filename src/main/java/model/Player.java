package model;

/**
 * Erstellt neuen Spieler
 *
 * @author Sarah Frischknecht
 * @version 1.0
 * @since 7.7.2021
 */
public class Player {
    private String name;
    private int punkte;

    /**
     * default-Konstruktor
     */
    public Player() {
    }

    /**
     * Konstruktor
     *
     * @param name des Spielers
     */
    public Player(String name) {
        this.name = name;
        this.punkte = 0;
    }

    /**
     * Setter für Punkte
     *
     * @param punkte die der Spieler erzielt hat (Multimode)
     */
    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    /**
     * Getter Name
     *
     * @return Name des Spielers
     */
    public String getName() {
        return name;
    }

    /**
     * Getter Punkte
     *
     * @return Punkte, die der Spieler erzielt hat (Multimode)
     */
    public int getPunkte() {
        return punkte;
    }


}
