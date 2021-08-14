package control;

import model.Field;
import model.Leaderboard;
import model.Player;
import view.Multimode;
import view.Singlemode;

import javax.swing.*;
import java.awt.*;

/**
 * Diese Klasse beinhaltet die Spiellogik
 * <p>
 * Von hier aus werden die neuen Spiele aufgerufen und die Logik des Spiels organisiert, ob ein Paar aufgedeckt
 * wurde, das Spiel zu Ende ist, etc.
 *
 * @author Sarah Frischknecht
 * @version 1.0
 * @since 7.7.2021
 */
public class Spiellogik {

    private int anzKartenGedreht = 0;
    private int anzPairsFound = 0;
    private boolean player1WillPlay = false;
    private boolean switchPlayer = false;

    private Timerrr timer = new Timerrr();
    private Field field;
    private Player player;
    private Leaderboard leaderboard;
    private Multimode multimode;

    /**
     * Konstruktor
     */
    public Spiellogik() {
    }

    /**
     * Neuer Multimode wird gestartet
     *
     * @param jFrame Frame, das vor dem Öffnen des Multiplayers aktiviert war und jetzt geschlossen werden soll
     */
    public void multiplayer(JFrame jFrame) {
        Player player1 = new Player("Player One");
        Player player2 = new Player("Player Two");
        Multimode multimode = new Multimode(player1, player2);
        jFrame.dispose();
    }

    /**
     * Neuer Singlemode wird gestartet
     *
     * @param jFrame Frame, das vor dem Öffnen des Singleplayers aktiviert war und jetzt geschlossen werden soll
     */
    public void singleplayer(JFrame jFrame) {
        Player player = new Player();
        timer.start();
        Singlemode singlemode = new Singlemode(timer);
        jFrame.dispose();
    }

    /**
     * Setter von Anzahl Karten, die im Spielzug umgedreht wurden
     *
     * @param anzKartenGedreht neuer Wert für anzKartenGedereht
     */
    public void setAnzKartenGedreht(int anzKartenGedreht) {
        this.anzKartenGedreht = anzKartenGedreht;
    }

    /**
     * Returnt anzKartenGedreht
     *
     * @return Anzahl Karten, die im Spielzug umgedreht wurden
     */
    public int getAnzKartenGedreht() {
        return anzKartenGedreht;
    }

    /**
     * Returnt anzPairsFound
     *
     * @return Anz bereits gefundene Paare
     */
    public int getAnzPairsFound() {
        return anzPairsFound;
    }

    /**
     * Setzt boolean switchPlayer
     *
     * @param switchPlayer ob der Spieler, der am Zug ist gewechselt werden muss
     */
    public void setSwitchPlayer(boolean switchPlayer) {
        this.switchPlayer = switchPlayer;
    }

    /**
     * Returnt switchPlayer
     *
     * @return ob der Spieler, der am Zug ist gewechselt werden muss
     */
    public boolean isSwitchPlayer() {
        return switchPlayer;
    }

    /**
     * Returnt player1WillPlay
     *
     * @return ob Spieler 1 den nächsten Zug ausführt
     */
    public boolean isPlayer1WillPlay() {
        return player1WillPlay;
    }

    /**
     * returnt boolean
     * @return ob ein Spieler bereits zwei Karten aufgedeckt hat
     */
    public boolean checkAnzGedrehte() {
        if (anzKartenGedreht == 2) {
            anzKartenGedreht = 0;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Vergleicht den Inhalt(Text und Hintergrundfarbe) von zwei Karten
     * @param text1 value der Karte 1
     * @param color1 Hintergrundfarbe der Karte 1
     * @param text2 value der Karte 2
     * @param color2 Hintergrundfarbe der Karte 2
     * @return ob die Karten ein Paar sind
     */
    public boolean compare(String text1, Color color1, String text2, Color color2) {
        if (text1.equals(text2) && color1 == color2) {
            anzPairsFound++;
            return true;
        } else {
            player1WillPlay = !player1WillPlay; //changes bool to opposite
            return false;
        }
    }
}
