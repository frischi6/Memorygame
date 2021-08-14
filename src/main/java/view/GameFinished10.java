package view;

import model.Leaderboard;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Modales Fenster, das nach einem Singlemode-Spiel angezeigt wird, wenn die Zeit des Spielers ein Top-10-Resultat ist
 *
 * @author Sarah Frischknecht
 * @version 1.0
 * @since 7.7.2021
 */
public class GameFinished10 {
    Leaderboard leaderboard = new Leaderboard();

    private JLabel title;
    private JTextField setNameField;
    private JTextArea contentArea;
    private JButton hauptmenue;
    private JButton eintragen;

    private JPanel buttonPanel;
    private JPanel bodyPanel;

    /**
     * Konstruktor
     *
     * @param time  die der Spieler gebraucht hat um das Memory vollständig zu lösen
     * @param frame Spielfeld, auf dem zuvor gespielt wurde und noch geschlossen werden soll
     */
    public GameFinished10(float time, JFrame frame) {
        JDialog gameFinishedSingle = new JDialog();

        gameFinishedSingle.setTitle("");
        gameFinishedSingle.setSize(800, 600);
        gameFinishedSingle.setModal(true);

        title = new JLabel("GLÜCKWUNSCH");
        title.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));

        contentArea = new JTextArea("Du hast das Memory innerhalb von " + time + " Sekunden geschafft." +
                "\nDu hast eine Top-10-Spielzeit erreicht!\nBitte gib deinen Namen ein:");
        contentArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        contentArea.setBorder(new EmptyBorder(50, 50, 50, 50));
        contentArea.setEditable(false);

        setNameField = new JTextField();

        hauptmenue = new JButton("Hauptmenue");
        eintragen = new JButton("Name erfassen");
        hauptmenue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homepage homepage = new Homepage();
                gameFinishedSingle.setVisible(false);
                frame.dispose();
            }
        });
        eintragen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leaderboard.addNew(time, setNameField.getText());
                LeaderboardGUI leaderboardModal = new LeaderboardGUI(leaderboard);
                gameFinishedSingle.setVisible(false);
                frame.dispose();
            }
        });


        bodyPanel = new JPanel(new GridLayout(2, 1));
        bodyPanel.add(contentArea);
        bodyPanel.add(setNameField);
        buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(hauptmenue);
        buttonPanel.add(eintragen);

        gameFinishedSingle.add(bodyPanel, BorderLayout.CENTER);
        gameFinishedSingle.add(buttonPanel, BorderLayout.SOUTH);
        gameFinishedSingle.add(title, BorderLayout.NORTH);

        gameFinishedSingle.setLocationRelativeTo(null);
        gameFinishedSingle.setVisible(true);

    }

}
