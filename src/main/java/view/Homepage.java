package view;

import control.Spiellogik;
import model.Leaderboard;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Homepage, in der die Applikation gestartet wird und als Hauptmenue dient
 *
 * @author Sarah Frischknecht
 * @version 1.0
 * @since 7.7.2021
 */
public class Homepage extends JFrame {
    private Spiellogik spiellogik;

    private JLabel titleLabel;

    private JButton singleplayerButton;
    private JButton multiplayerButton;
    private JButton rangliste;
    private JButton ueberUns;
    private JButton anleitung;

    private JPanel buttonPanel;
    private JPanel buttonBoxPanel;


    /**
     * Konstruktor
     */
    public Homepage() {
        spiellogik = new Spiellogik();

        setTitle("Memory-Game by Assvin, Kevin and Sarah");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(0, 206, 209));
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("Memory-Game", SwingConstants.CENTER);
        singleplayerButton = new JButton("Singleplayer");
        multiplayerButton = new JButton("Multiplayer");
        rangliste = new JButton("Rangliste");
        ueberUns = new JButton("Über uns");
        anleitung = new JButton("Anleitung");

        titleLabel.setBorder(new EmptyBorder(80, 0, 80, 0));

        titleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 65));
        singleplayerButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        multiplayerButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        rangliste.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        ueberUns.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
        anleitung.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));

        singleplayerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        multiplayerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rangliste.setAlignmentX(Component.CENTER_ALIGNMENT);
        ueberUns.setAlignmentX(Component.CENTER_ALIGNMENT);
        anleitung.setAlignmentX(Component.CENTER_ALIGNMENT);


        buttonBoxPanel = new JPanel();
        buttonBoxPanel.setLayout(new BoxLayout(buttonBoxPanel, BoxLayout.PAGE_AXIS));
        buttonBoxPanel.add(singleplayerButton);
        buttonBoxPanel.add(Box.createRigidArea(new Dimension(0, 45)));  //Abstand zwischen den Buttons
        buttonBoxPanel.add(multiplayerButton);
        buttonBoxPanel.add(Box.createRigidArea(new Dimension(0, 45)));
        buttonBoxPanel.add(rangliste);
        buttonBoxPanel.add(Box.createRigidArea(new Dimension(0, 45)));
        buttonBoxPanel.add(ueberUns);
        buttonBoxPanel.add(Box.createRigidArea(new Dimension(0, 45)));
        buttonBoxPanel.add(anleitung);
        buttonPanel = new JPanel();
        buttonPanel.add(buttonBoxPanel);

        buttonBoxPanel.setBackground(new Color(0, 206, 209));
        buttonPanel.setBackground(new Color(0, 206, 209));


        getContentPane().setLayout(new BorderLayout(1, 1));
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(titleLabel, BorderLayout.NORTH);

        //add ActionListener
        multiplayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spiellogik.multiplayer(getFrame());
            }
        });
        singleplayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spiellogik.singleplayer(getFrame());
            }
        });
        rangliste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Leaderboard leaderboard = new Leaderboard();
                LeaderboardGUI leaderboardModal = new LeaderboardGUI(leaderboard);
                getFrame().dispose();
            }
        });
        ueberUns.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UeberUnsModal ueberUnsModal = new UeberUnsModal();
            }
        });
        anleitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnleitungModal anleitungModal = new AnleitungModal();
            }
        });


        setVisible(true);
    }

    /**
     * main-Methode startet Programm
     *
     * @param args Übergabeparameter
     */
    public static void main(String[] args) {

        Homepage homesite = new Homepage();
    }

    /**
     * getter JFrame
     *
     * @return frame Homepage
     */
    public JFrame getFrame() {
        return this;
    }


}
