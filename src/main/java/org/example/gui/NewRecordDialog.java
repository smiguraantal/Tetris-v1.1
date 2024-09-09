/**
 * <p>Title: Tetris</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.1
 */

package org.example.gui;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Az rekorder nevének beírásához szükségess dialógus.
 */
public class NewRecordDialog extends JDialog {


    /**
     * Tartalompanel.
     */
    private Container cp = getContentPane();


    /**
     * Szövegmezõ a név beírásához.
     */
    private JTextField tfName = new JTextField(20);


    /**
     * Az ok gomb.
     */
    private JButton btOk;


    /**
     * A cancel gomb.
     */
    private JButton btCancel;


    /**
     * A fõ ablak.
     */
    private TetrisFrame tetrisFrame;


    /**
     * A beírt név.
     */
    private String name;


    /**
     * Konstruktor, felépíti a dialógust.
     */
    public NewRecordDialog(TetrisFrame tetrisFrame) {
        super(tetrisFrame, "New record", true);
        this.tetrisFrame = tetrisFrame;

        JPanel pn = new JPanel();
        pn.add(new JLabel("Name"));
        pn.add(tfName);
        cp.add(pn, BorderLayout.CENTER);

        pn = new JPanel();
        pn.add(btOk = new JButton("Ok"));
        pn.add(btCancel = new JButton("Cancel"));
        cp.add(pn, BorderLayout.SOUTH);

        btOk.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    hide();
            }
        });

        btCancel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    hide();
            }
        });

        tfName.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    hide();
            }
        });

        btOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ok();
            }
        });

        tfName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ok();
            }
        });

        btCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hide();
            }
        });

        pack();
    }


    /**
     * Megjeleníti a dialógust.
     */
    public void showDialog() {
        tfName.setText("");
        tfName.requestFocus();
        WindowLocation.center(this);
        show();
    }


    /**
     * Elmenti az új rekorder adatait.
     */
    private void ok() {
        name = tfName.getText();
        name = name.trim().equals("") ? "???" : name.trim();
        tetrisFrame.newRecord(name);
        hide();
    }
}