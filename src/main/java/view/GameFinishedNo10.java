package view;

import control.Timerrr;
import model.Leaderboard;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Modales Fenster, das nach einem Singlemode-Spiel angezeigt wird, wenn die Zeit des Spielers kein Top-10-Resultat ist
 *
 * @author Sarah Frischknecht
 * @version 1.0
 * @since 7.7.2021
 */
public class GameFinishedNo10 {

    private JTextArea contentArea;
    private JLabel title;
    private JButton rangliste;
    private JButton hauptmenue;
    private JButton newSinglegame;

    private JPanel buttonPanel;


    /**
     * Konstruktor
     * @param time
     */
    public GameFinishedNo10(float time, JFrame frame){
        JDialog gameFinishedSingle = new JDialog();

        gameFinishedSingle.setTitle("");
        gameFinishedSingle.setSize(450,500);
        gameFinishedSingle.setModal(true);

        title = new JLabel("SPIEL BEENDET", SwingConstants.CENTER);
        title.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));

        contentArea = new JTextArea("Du hast das Memory innerhalb von " + time + " Sekunden geschafft." +
                "\nLeider hast du keine Top-10-Zeit erreicht, du darfst es aber gerne nochmals versuchen:)");
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true); //Zeilenumbruch nur wortweise
        contentArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        contentArea.setEditable(false);
        contentArea.setBorder(new EmptyBorder(50,50,50,50));

        rangliste = new JButton("Rangliste");
        hauptmenue = new JButton("Hauptmenue");
        newSinglegame = new JButton("Neues Spiel");
        rangliste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFinishedSingle.setVisible(false);
                frame.dispose();
                Leaderboard leaderboard = new Leaderboard();
                LeaderboardGUI leaderboardGUI = new LeaderboardGUI(leaderboard);
            }
        });
        hauptmenue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFinishedSingle.setVisible(false);
                frame.dispose();
                Homepage homepage = new Homepage();
            }
        });
        newSinglegame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFinishedSingle.setVisible(false);
                frame.dispose();
                Timerrr timer = new Timerrr();
                timer.start();
                Singlemode singlemode = new Singlemode(timer);
            }
        });

        buttonPanel = new JPanel(new GridLayout(1,3));
        buttonPanel.add(newSinglegame);
        buttonPanel.add(hauptmenue);
        buttonPanel.add(rangliste);


        gameFinishedSingle.add(title, BorderLayout.NORTH);
        gameFinishedSingle.add(contentArea, BorderLayout.CENTER);
        gameFinishedSingle.add(buttonPanel, BorderLayout.SOUTH);

        gameFinishedSingle.setLocationRelativeTo(null);
        gameFinishedSingle.setVisible(true);

    }
}
