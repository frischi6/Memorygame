package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Modales Fenster in dem die Namen des Entwicklungsteams stehen
 *
 * @author Sarah Frischknecht
 * @version 1.0
 * @since 7.7.2021
 */
public class UeberUnsModal {

    private JTextArea contentArea;

    /**
     * Konstruktor
     */
    public UeberUnsModal(){
        JDialog ueberUnsModal = new JDialog();

        ueberUnsModal.setTitle("Über uns");
        ueberUnsModal.setSize(450,400);
        ueberUnsModal.setModal(true);

        contentArea = new JTextArea("Über uns:\n\nAssvin Shanmuganathan\nSarah Frischknecht\nKevin Bertolini" +
                "\n\nInformatikmittelschüler Kantonsschule Hottingen");
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);
        contentArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        contentArea.setEditable(false);
        contentArea.setBorder(new EmptyBorder(50,50,50,50));

        ueberUnsModal.add(contentArea, BorderLayout.CENTER);

        ueberUnsModal.setLocationRelativeTo(null);
        ueberUnsModal.setVisible(true);

    }
}
