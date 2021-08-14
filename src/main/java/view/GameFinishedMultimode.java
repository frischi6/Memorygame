package view;

import model.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Modales Fenster, das nach einem Multimode-Spiel angezeigt wird und den Gewinner anzeigt
 *
 * @author Sarah Frischknecht
 * @version 1.0
 * @since 7.7.2021
 */
public class GameFinishedMultimode {

    private JLabel title;
    private JButton erneutSpielen;
    private JButton hauptmenue;

    private JPanel buttonPanel;

    /**
     * Konstruktor
     *
     * @param winnerName Name des Gewinners
     * @param punkteP1   Punkte des Spieler 1
     * @param punkteP2   Punkte des Spieler 2
     * @param jFrame     Spielfeld, auf dem zuvor gespielt wurde und noch geschlossen werden soll
     */
    public GameFinishedMultimode(String winnerName, int punkteP1, int punkteP2, JFrame jFrame) {
        JDialog gameFinishedMulti = new JDialog();

        gameFinishedMulti.setTitle("");
        gameFinishedMulti.setSize(450, 400);
        gameFinishedMulti.setModal(true);

        title = new JLabel(winnerName + " hat gewonnen!");
        title.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        title.setBorder(new EmptyBorder(50, 50, 50, 50));

        erneutSpielen = new JButton("Nochmals spielen");
        hauptmenue = new JButton("Hauptmenue");
        erneutSpielen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player1 = new Player("Player One");
                Player player2 = new Player("Player Two");
                player1.setPunkte(punkteP1);
                player2.setPunkte(punkteP2);
                Multimode multimode = new Multimode(player1, player2);
                gameFinishedMulti.setVisible(false);
                jFrame.dispose();
            }
        });
        hauptmenue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homepage homepage = new Homepage();
                gameFinishedMulti.setVisible(false);
                jFrame.dispose();
            }
        });

        buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(erneutSpielen);
        buttonPanel.add(hauptmenue);


        gameFinishedMulti.add(title, BorderLayout.CENTER);
        gameFinishedMulti.add(buttonPanel, BorderLayout.SOUTH);


        gameFinishedMulti.setLocationRelativeTo(null);
        gameFinishedMulti.setVisible(true);
    }
}
