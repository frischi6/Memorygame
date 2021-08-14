package view;

import control.Spiellogik;
import control.Timerrr;
import model.Field;
import model.Leaderboard;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *  GUI, das das Memory im Singlemode darstellt
 *
 * @author Sarah Frischknecht
 * @version 1.0
 * @since 7.7.2021
 */
public class Singlemode extends JFrame {

    private Field field = new Field();
    private Timerrr timerrr;
    private Spiellogik spiellogik = new Spiellogik();
    private Leaderboard leaderboard = new Leaderboard();
    private JButton firstOpenedCard = new JButton();
    private JButton secondOpenedCard = new JButton();


    private List<JButton> buttons = new ArrayList<>();

    private JLabel titleLabel;

    private JButton reset;
    private JButton hauptmenue;
    private JButton hilfe;

    private JPanel cardPanel;
    private JPanel buttonPanel;


    /**
     * Konstruktor
     * @param timer mit dem die Zeit gestoppt wird
     */
    public Singlemode(Timerrr timer) {
        setTitle("Singlemode");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(253, 253, 39));
        setResizable(true);
        setLayout(new BorderLayout(100, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UIManager.put("Button.disabledText", new ColorUIResource(Color.BLACK));//enabled Buttons behalten Textfarbe schwarz

        timerrr = timer;

        titleLabel = new JLabel("Singleplayer", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 80));
        titleLabel.setBorder(new EmptyBorder(80, 0, 100, 0));

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.BOLD, 15));
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Timerrr timer = new Timerrr();
                Singlemode singlemode = new Singlemode(timer);
                getFrame().dispose();
            }
        });
        hauptmenue = new JButton("Hauptmenue");
        hauptmenue.setFont(new Font("Arial", Font.BOLD, 15));
        hauptmenue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homepage homepage = new Homepage();
                getFrame().dispose();
            }
        });
        hilfe = new JButton("Hilfe");
        hilfe.setFont(new Font("Arial", Font.BOLD, 15));
        hilfe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AnleitungModal anleitungModal = new AnleitungModal();
            }
        });


        //Karten-Buttons erstellen und zu List adden
        for (int i = 0; i < 36; i++) {
            JButton button = new JButton(String.valueOf(field.getCardVector().get(i).getValue()));
            button.setForeground(new Color(253, 253, 39));
            button.setBackground(field.getCardVector().get(i).getBackgroundcolor());
            button.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
            button.setBorder(new LineBorder(Color.black, 4));
            button.setOpaque(false);
            button.addActionListener(new cardbuttonListener());
            buttons.add(button);
        }


        cardPanel = new JPanel(new GridLayout(6, 6, 40, 30));
        for (JButton button : buttons) {
            cardPanel.add(button);
        }
        cardPanel.setBackground(new Color(253, 253, 39));
        cardPanel.setBorder(new EmptyBorder(0, 0, 80, 80));


        //buttonPanel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.add(reset);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 45)));
        buttonPanel.add(hauptmenue);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 45)));
        buttonPanel.add(hilfe);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 45)));
        buttonPanel.setBackground(new Color(253, 253, 39));
        buttonPanel.setBorder(new EmptyBorder(0, 50, 0, 0));


        getContentPane().add(titleLabel, BorderLayout.NORTH);
        getContentPane().add(cardPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.WEST);


        setVisible(true);
    }

    /**
     * Listener für wenn eine Karte angeklickt wird
     * inkl. aktueller Spieler kennzeichnen, Punkte setzen,..
     */
    class cardbuttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton sender = (JButton) e.getSource();
            sender.setEnabled(false);

            if (spiellogik.getAnzKartenGedreht() == 0) {
                if (spiellogik.compare(firstOpenedCard.getText(), firstOpenedCard.getBackground(),
                        secondOpenedCard.getText(), secondOpenedCard.getBackground()) == false) {
                    twoTurnedNotEqual(firstOpenedCard, secondOpenedCard);
                }
            }
            sender.setForeground(Color.black);
            sender.setOpaque(true);
            spiellogik.setAnzKartenGedreht(spiellogik.getAnzKartenGedreht() + 1);


            if (spiellogik.checkAnzGedrehte() == true) {

                if (spiellogik.compare(sender.getText(), sender.getBackground(),
                        firstOpenedCard.getText(), firstOpenedCard.getBackground())) {
                    twoTurnedEqual(firstOpenedCard, sender);
                }
            } else {
                firstOpenedCard = sender;
            }
            secondOpenedCard = sender;

        }

        public void twoTurnedNotEqual(JButton card1, JButton card2) {   //Karten wieder verdecken
            card1.setOpaque(false);
            card1.setForeground(new Color(253, 253, 39));
            card2.setOpaque(false);
            card2.setForeground(new Color(253, 253, 39));
            card1.setEnabled(true);
            card2.setEnabled(true);
        }

        public void twoTurnedEqual(JButton card1, JButton card2) {
            card1.setBackground(Color.black);
            card2.setBackground(Color.black);
            card1.setText("");
            card2.setText("");
            card1.setEnabled(false);
            card2.setEnabled(false);

            if (spiellogik.getAnzPairsFound() == field.getAmountCards()) {//Spiel beendet
                timerrr.stop();
                if (timerrr.getTime() < leaderboard.getLastPlaceTime()) {
                    GameFinished10 finishedModal = new GameFinished10(timerrr.getTime(), getFrame());
                } else {
                    GameFinishedNo10 finishedModal = new GameFinishedNo10(timerrr.getTime(), getFrame());
                }
                System.out.println(timerrr.getTime());
            }

        }
    }

    /**
     * getter JFrame
     *
     * @return frame Homepage
     */
    public JFrame getFrame(){
        return this;
    }
}

