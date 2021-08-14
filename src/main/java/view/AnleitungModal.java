package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Modales Fenster in dem die Anleitung des Spieles steht
 *
 * @author Sarah Frischknecht
 * @version 1.0
 * @since 7.7.2021
 */
public class AnleitungModal {

    private JTextArea contentArea;

    /**
     * Konstuktor (inkl. Aufbau des GUIs)
     */
    public AnleitungModal(){
        JDialog ueberUnsModal = new JDialog();

        ueberUnsModal.setTitle("Anleitung");
        ueberUnsModal.setSize(650,600);
        ueberUnsModal.setModal(true);

        contentArea = new JTextArea("Anleitung:\n\nBei Memory werden mehrere Kartenpaare auf dem Spielfeld verteilt. " +
                "Zwei Spieler müssen versuchen, möglichst viele Paare aufzudecken. Zu Beginn des Spiels werden alle " +
                "Kärtchen verdeckt auf dem Spielfeld verteilt. Ist ein Spieler am Zug, darf er zwei Kärtchen aufdecken." +
                "\nIm Multiplayer-Modus spielen zwei Spieler gegeneinander und versuchen die meisten Punkte zu erreichen." +
                "\nDer Singleplayer-Modus ist ein Spiel gegen die Zeit. Ein Spieler versucht alle Karten so schnell " +
                "wie möglich aufzudecken. Nachdem die Zeit gespeichert wurde, kann man erneut spielen, um die Bestzeit " +
                "zu schlagen. Die Bestzeiten werden dann in einer Rangliste aufgelistet.");

        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true); //Zeilenumbruch nur wortweise
        contentArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        contentArea.setEditable(false);
        contentArea.setBorder(new EmptyBorder(50,50,50,50));

        ueberUnsModal.add(contentArea, BorderLayout.CENTER);

        ueberUnsModal.setLocationRelativeTo(null);  //Fenster wird an zentraler Position geöffnet
        ueberUnsModal.setVisible(true);
    }
}
