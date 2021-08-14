package control;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.*;

/**
 * Gebraucht um die Zeit zu messen, die ein Spieler im Singlemode braucht, um alle Paare zu finden
 *
 * @author Sarah Frischknecht
 * @version 1.0
 * @since 7.7.2021
 */
public class Timerrr {
    private LocalTime start;
    private LocalTime finish;
    private long time;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS");


    /**
     * Konstruktor
     */
    public Timerrr() {
    }

    /**
     * Startet den Timer-> setzt die Startzeit
     */
    public void start() {
        this.start = LocalTime.parse(LocalTime.now().format(formatter));
    }

    /**
     * Stoppt den Timer-> setzt die Endzeit
     */
    public void stop() {
        this.finish = LocalTime.parse(LocalTime.now().format(formatter));

    }

    /**
     * Berechnet Zeit, die gebraucht wurde, um das Memory vollständig zu lösen
     *
     * @return time die gebraucht wurde, um das Memory vollständig zu lösen
     */
    public long getTime() {
        time = MILLIS.between(start, finish) / 1000;
        return time;
    }

}
