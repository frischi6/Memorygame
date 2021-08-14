package view;

import control.Spiellogik;
import model.Field;
import model.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * GUI, das das Memory im Multimode darstellt
 *
 * @author Sarah Frischknecht
 * @version 1.0
 * @since 7.7.2021
 */
public class Multimode extends JFrame {

    Spiellogik spiellogik = new Spiellogik();
    private Field field = new Field();

    private List<JButton> buttons = new ArrayList<>();

    private JButton firstOpenedCard = new JButton();
    private JButton secondOpenedCard = new JButton();

    private DecimalFormat decimalFormatPoints = new DecimalFormat("000");


    private JLabel titleLabel;
    private JLabel nameLabel1;
    private JLabel nameLabel2;
    private JLabel pointLabel1;
    private JLabel pointLabel2;

    private JButton reset;
    private JButton hauptmenue;
    private JButton hilfe;

    private JPanel cardPanel;
    private JPanel buttonPanel;
    private JPanel player1Panel;
    private JPanel player2Panel;


    /**
     * Konstruktor
     *
     * @param player1 Spieler 1
     * @param player2 Spieler 2
     */
    public Multimode(Player player1, Player player2) {
        setTitle("Multimode");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(255, 171, 0));
        setResizable(true);
        setLayout(new BorderLayout(100, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UIManager.put("Button.disabledText", new ColorUIResource(Color.BLACK));//enabled buttons haben Textfarbe schwarz


        titleLabel = new JLabel("Multiplayer", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 80));
        titleLabel.setBorder(new EmptyBorder(80, 0, 80, 0));


        nameLabel1 = new JLabel(player1.getName());
        nameLabel2 = new JLabel(player2.getName());
        nameLabel1.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        nameLabel2.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        nameLabel1.setBackground(Color.green);
        nameLabel2.setBackground(Color.white);
        nameLabel1.setOpaque(true);
        nameLabel2.setOpaque(true);
        nameLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel1.setBorder(new LineBorder(Color.black, 4));
        nameLabel2.setBorder(new LineBorder(Color.black, 4));

        pointLabel1 = new JLabel(decimalFormatPoints.format(player1.getPunkte()));
        pointLabel2 = new JLabel(decimalFormatPoints.format(player2.getPunkte()));
        pointLabel1.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        pointLabel2.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        pointLabel1.setBackground(Color.green);
        pointLabel1.setOpaque(true);
        pointLabel2.setBackground(Color.white);
        pointLabel2.setOpaque(true);
        pointLabel1.setBorder(new LineBorder(Color.black, 4));
        pointLabel2.setBorder(new LineBorder(Color.black, 4));
        pointLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        pointLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);


        reset = new JButton("Reset");
        hauptmenue = new JButton("Hauptmenue");
        hilfe = new JButton("Hilfe");
        reset.setFont(new Font("Arial", Font.BOLD, 15));
        hauptmenue.setFont(new Font("Arial", Font.BOLD, 15));
        hilfe.setFont(new Font("Arial", Font.BOLD, 15));
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player1 = new Player("Player One");
                Player player2 = new Player("Player Two");
                Multimode multimode = new Multimode(player1, player2);
                getFrame().dispose();
            }
        });
        hauptmenue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homepage homepage = new Homepage();
                getFrame().dispose();
            }
        });
        hilfe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnleitungModal anleitungModal = new AnleitungModal();
            }
        });


        //Karten-Buttons erstellen und zu List adden
        for (int i = 0; i < 36; i++) {
            JButton button = new JButton(String.valueOf(field.getCardVector().get(i).getValue()));
            button.setForeground(new Color(255, 171, 0));
            button.setBackground(field.getCardVector().get(i).getBackgroundcolor());
            button.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
            button.setBorder(new LineBorder(Color.black, 4));
            button.setOpaque(false);    //damit Karte nicht sichtbar
            button.addActionListener(new cardbuttonListener());
            buttons.add(button);

        }


        //cardPanel
        cardPanel = new JPanel(new GridLayout(6, 6, 40, 30));
        for (JButton button : buttons) {
            cardPanel.add(button);
        }
        cardPanel.setBackground(new Color(255, 171, 0));
        cardPanel.setBorder(new EmptyBorder(0, 0, 80, 0));


        //buttonPanel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(reset);
        buttonPanel.add(Box.createRigidArea(new Dimension(45, 0)));
        buttonPanel.add(hauptmenue);
        buttonPanel.add(Box.createRigidArea(new Dimension(45, 0)));
        buttonPanel.add(hilfe);
        buttonPanel.add(Box.createRigidArea(new Dimension(45, 0)));
        buttonPanel.setBackground(new Color(255, 171, 0));
        buttonPanel.setBorder(new EmptyBorder(0, 790, 60, 0));

        //playerPanel
        player1Panel = new JPanel();
        player1Panel.setLayout(new BoxLayout(player1Panel, BoxLayout.PAGE_AXIS));
        player1Panel.add(nameLabel1);
        player1Panel.add(Box.createRigidArea(new Dimension(0, 45)));
        player1Panel.add(pointLabel1);
        player1Panel.setOpaque(false);
        player1Panel.setBorder(new EmptyBorder(0, 30, 0, 0));

        player2Panel = new JPanel();
        player2Panel.setLayout(new BoxLayout(player2Panel, BoxLayout.PAGE_AXIS));
        player2Panel.add(nameLabel2);
        player2Panel.add(Box.createRigidArea(new Dimension(0, 45)));
        player2Panel.add(pointLabel2);
        player2Panel.setOpaque(false);
        player2Panel.setBorder(new EmptyBorder(0, 0, 0, 30));


        getContentPane().add(titleLabel, BorderLayout.NORTH);
        getContentPane().add(cardPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().add(player1Panel, BorderLayout.WEST);
        getContentPane().add(player2Panel, BorderLayout.EAST);


        setVisible(true);
    }


    class cardbuttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (spiellogik.getAnzKartenGedreht() == 0) {    //Spieler, der am Zug ist kennzeichnen
                if (spiellogik.isPlayer1WillPlay()) {
                    nameLabel1.setBackground(Color.white);
                    pointLabel1.setBackground(Color.white);
                    nameLabel2.setBackground(Color.green);
                    pointLabel2.setBackground(Color.green);
                } else {
                    nameLabel1.setBackground(Color.green);
                    pointLabel1.setBackground(Color.green);
                    nameLabel2.setBackground(Color.white);
                    pointLabel2.setBackground(Color.white);
                }
            }
            JButton sender = (JButton) e.getSource();
            sender.setEnabled(false);
            if (spiellogik.isSwitchPlayer()) {
                twoTurnedNotEqual(firstOpenedCard, secondOpenedCard);
                spiellogik.setSwitchPlayer(false);
            }
            sender.setForeground(Color.black);
            sender.setOpaque(true);
            spiellogik.setAnzKartenGedreht(spiellogik.getAnzKartenGedreht() + 1);


            if (spiellogik.checkAnzGedrehte() == true) {    //2 Karten von einem Spieler aufgedeckt

                if (spiellogik.compare(firstOpenedCard.getText(), firstOpenedCard.getBackground(),
                        sender.getText(), sender.getBackground()) == true) {
                    twoTurnedEqual(firstOpenedCard, sender);
                } else {    //Karten sind kein Paar
                    spiellogik.setSwitchPlayer(true);
                }

            } else {
                firstOpenedCard = sender;
            }
            secondOpenedCard = sender;

        }

        public void twoTurnedNotEqual(JButton card1, JButton card2) {   //Karten wieder "umdecken"
            card1.setOpaque(false);
            card1.setForeground(new Color(255, 171, 0));
            card2.setOpaque(false);
            card2.setForeground(new Color(255, 171, 0));
            card1.setEnabled(true);
            card2.setEnabled(true);

        }

        public void twoTurnedEqual(JButton card1, JButton card2) {
            if (spiellogik.isPlayer1WillPlay() == true) {
                if (card2.getText().equals("111")) {    //Jokercard
                    pointLabel2.setText(String.valueOf(decimalFormatPoints.format
                            (Integer.parseInt(pointLabel2.getText()) + 3)));
                } else {
                    pointLabel2.setText(String.valueOf(decimalFormatPoints.format
                            (Integer.parseInt(pointLabel2.getText()) + 1)));
                }
            } else {
                if (card2.getText().equals("111")) {    //Jokercard
                    pointLabel1.setText(String.valueOf(decimalFormatPoints.format
                            (Integer.parseInt(pointLabel1.getText()) + 3)));

                } else {
                    pointLabel1.setText(String.valueOf(decimalFormatPoints.format
                            (Integer.parseInt(pointLabel1.getText()) + 1)));
                }
            }

            card1.setBackground(Color.black);
            card2.setBackground(Color.black);
            card1.setText("");
            card2.setText("");
            card1.setEnabled(false);
            card2.setEnabled(false);


            if (spiellogik.getAnzPairsFound() == field.getAmountCards() / 2) {    //Spiel beendet?
                String winner = "";
                if (Integer.parseInt(pointLabel1.getText()) > Integer.parseInt(pointLabel2.getText())) {
                    winner = nameLabel1.getText();
                } else if (Integer.parseInt(pointLabel1.getText()) < Integer.parseInt(pointLabel2.getText())) {
                    winner = nameLabel2.getText();
                } else {    //Unentschieden
                    winner = "Niemand";
                }
                GameFinishedMultimode finishedModal = new GameFinishedMultimode(winner,
                        Integer.parseInt(pointLabel1.getText()), Integer.parseInt(pointLabel2.getText()), getFrame());
            }
        }

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
