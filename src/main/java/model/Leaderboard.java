package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Enthält die Logik für die Rangliste inklusive Fülldaten
 *
 * @author Sarah Frischknecht
 * @version 1.0
 * @since 7.7.2021
 */
public class Leaderboard {

    private float lastPlaceTime = 855f;   //hoher Füllwert, wird nach Einfügen der Fülldaten aktualisiert
    private final String[] title = {"Rang", "Name", "Zeit"};
    private HashMap<Float, String> playerMap;
    private ArrayList<Float> scoreListed = new ArrayList<>();

    //Füllwerte
    Float obj1 = new Float(320.5f);
    Float obj2 = new Float(100f);
    Float obj3 = new Float(120.5f);
    Float obj4 = new Float(511.5f);
    Float obj5 = new Float(417.7f);
    Float obj6 = new Float(220.9f);
    Float obj7 = new Float(330.5f);
    Float obj8 = new Float(336.5f);
    Float obj9 = new Float(437.5f);
    Float obj10 = new Float(550.5f);
    String n1 = "Noemi";
    String n2 = "Jessi";
    String n3 = "Sven";
    String n4 = "Lars";
    String n5 = "Gian";
    String n6 = "The Pro";
    String n7 = "Nele";
    String n8 = "elias";
    String n9 = "matteo";
    String n10 = "raul";


    /**
     * Konstruktor
     */
    public Leaderboard() {
        playerMap = new HashMap<>();
        fill();
    }

    /**
     * Aktualisiert die Ranglistenwerte-> sortiert und setzt höchste Zeit
     */
    public void updateList() {
        Collections.sort(scoreListed);
        updateLastPlaceTime();
    }

    /**
     * Füllt die List/Map mit Fülldaten
     */
    public void fill() {
        scoreListed.add(obj1);
        scoreListed.add(obj2);
        scoreListed.add(obj3);
        scoreListed.add(obj4);
        scoreListed.add(obj5);
        scoreListed.add(obj6);
        scoreListed.add(obj7);
        scoreListed.add(obj8);
        scoreListed.add(obj9);
        scoreListed.add(obj10);

        playerMap.put(obj1, n1);
        playerMap.put(obj2, n2);
        playerMap.put(obj3, n3);
        playerMap.put(obj4, n4);
        playerMap.put(obj5, n5);
        playerMap.put(obj6, n6);
        playerMap.put(obj7, n7);
        playerMap.put(obj8, n8);
        playerMap.put(obj9, n9);
        playerMap.put(obj10, n10);

        updateList();
    }

    /**
     * Fügt neuen Wert in die Rangliste ein
     * @param score Zeit, die  der Spieler gebraucht hatte um das Memory zu vervollständigen
     * @param name Name des Spielers
     */
    public void addNew(Float score, String name) {
        playerMap.put(score, name);
        scoreListed.add(score);
        updateList();
    }

    /**
     * Getter title[]
     * @return Name der Werte in der Rangliste
     */
    public String[] getTitle() {
        return title;
    }

    /**
     * Getter lastPlaceTime
     * @return Zeit des 10. Plazierten
     */
    public float getLastPlaceTime() {
        return lastPlaceTime;
    }

    /**
     * Aktualisiert die höchste Zeit der Top-10-Rangliste
     */
    public void updateLastPlaceTime() {
        this.lastPlaceTime = scoreListed.get(9);
    }

    /**
     * liefert die Werte für in die Rangliste
     *
     * @param index Platz in der List
     * @return die in der Rangliste anzuzeigenden Werte eines Spielers
     */
    public String[] getRow(int index) {
        return new String[]{String.valueOf(index + 1) + ".", playerMap.get(scoreListed.get(index)),
                String.valueOf(scoreListed.get(index)) + " s"};
    }
}
