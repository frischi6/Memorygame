package model;

/**
 * Jokerkarte fürs Spielfeld
 * Unterschied zu Karte: Punktewert ist höher
 *
 * @author Sarah Frischknecht
 * @version 1.0
 * @since 7.7.2021
 */
public class JokerCard extends Card {

    private final int pointsJokerCard = 3;

    /**
     * Konstruktor
     */
    public JokerCard() {
    }

    /**
     * Getter pointsJokerCard
     * @return anz Punkte, die bei gefunden Kartenpaar resultieren
     */
    @Override
    public int getPointsCard() {
        return this.pointsJokerCard;
    }
}
