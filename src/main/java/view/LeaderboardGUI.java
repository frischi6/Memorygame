package view;

import control.Timerrr;
import model.Leaderboard;
import model.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI, das die Rangliste anzeigt
 *
 * @author Sarah Frischknecht
 * @version 1.0
 * @since 7.7.2021
 */
public class LeaderboardGUI extends JFrame {

    private DefaultTableModel daDefaultTableModel;

    private JTable ranglisteTable;
    private JLabel title;
    private JButton hauptmenue;
    private JButton neuesSpielSingle;
    private JButton neuesSpielMulti;

    private JPanel buttonPanel;
    private JPanel ranglistePanel;


    /**
     * Konstruktor
     *
     * @param leaderboard Werte der Rangliste
     */
    public LeaderboardGUI(Leaderboard leaderboard) {
        setTitle("Rangliste");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        getContentPane().setBackground(new Color(235, 103, 103));


        title = new JLabel("Rangliste", SwingConstants.CENTER);
        title.setFont(new Font("Comic Sans MS", Font.PLAIN, 65));
        title.setBackground(new Color(235, 103, 103));
        title.setForeground(Color.black);
        title.setOpaque(true);
        title.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, Color.BLACK));


        daDefaultTableModel = new DefaultTableModel(0, 0);
        daDefaultTableModel.setColumnIdentifiers(leaderboard.getTitle());
        for (int i = 0; i < 10; i++) {          //leaderboard abfüllen
            daDefaultTableModel.addRow(leaderboard.getRow(i));
        }

        ranglisteTable = new JTable();
        ranglisteTable.setRowHeight(50);
        ranglisteTable.setModel(daDefaultTableModel);//Model in JTable einfügen
        ranglisteTable.setBackground(Color.black);
        ranglisteTable.setForeground(Color.white);
        ranglisteTable.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        ranglisteTable.setShowVerticalLines(false);
        ranglisteTable.setPreferredSize(new Dimension(1300, 500));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        DefaultTableCellRenderer leftRender = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        leftRender.setHorizontalAlignment(JLabel.LEFT);
        ranglisteTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        ranglisteTable.getColumnModel().getColumn(1).setCellRenderer(leftRender);
        ranglisteTable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        ranglistePanel = new JPanel();
        ranglistePanel.add(ranglisteTable, BorderLayout.CENTER);
        ranglistePanel.setBackground(new Color(235, 103, 103));
        ranglistePanel.setBorder(new EmptyBorder(80, 5, 50, 5));


        hauptmenue = new JButton("Hauptmenue");
        neuesSpielSingle = new JButton("Neues Singlemode-Spiel");
        neuesSpielMulti = new JButton("Neues Multimode-Spiel");
        hauptmenue.setFont(new Font("Arial", Font.BOLD, 25));
        neuesSpielSingle.setFont(new Font("Arial", Font.BOLD, 25));
        neuesSpielMulti.setFont(new Font("Arial", Font.BOLD, 25));
        hauptmenue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Homepage homepage = new Homepage();
                getFrame().dispose();
            }
        });
        neuesSpielSingle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Timerrr timer = new Timerrr();
                Singlemode singlemode = new Singlemode(timer);
                getFrame().dispose();
            }
        });
        neuesSpielMulti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Player player1 = new Player("Player One");
                Player player2 = new Player("Player Two");
                Multimode multimode = new Multimode(player1, player2);
                getFrame().dispose();
            }
        });

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(neuesSpielSingle);
        buttonPanel.add(Box.createRigidArea(new Dimension(45, 0)));
        buttonPanel.add(hauptmenue);
        buttonPanel.add(Box.createRigidArea(new Dimension(45, 0)));
        buttonPanel.add(neuesSpielMulti);
        buttonPanel.add(Box.createRigidArea(new Dimension(45, 0)));
        buttonPanel.setBackground(new Color(235, 103, 103));
        buttonPanel.setBorder(new EmptyBorder(0, 520, 100, 0));


        getContentPane().add(title, BorderLayout.NORTH);
        getContentPane().add(ranglistePanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);

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
