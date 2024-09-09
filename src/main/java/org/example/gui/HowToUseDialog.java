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


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * A program használatát megjelenítõ dialógus.
 */
public class HowToUseDialog extends JDialog implements ActionListener {


    /**
     * Tartalompanel.
     */
    private Container cp = getContentPane();


    /**
     * Az ok gomb.
     */
    private JButton btOk;


    /**
     * A szövegterület.
     */
    private JTextArea taUse = new JTextArea(15, 0);
    ;


    /**
     * A görgetõpanel.
     */
    private JScrollPane sp = new JScrollPane(taUse);

    /**
     * Konstruktor.
     */
    public HowToUseDialog(TetrisFrame tetrisFrame) {
        super(tetrisFrame, "How to use?", true);
        cp.setLayout(new BorderLayout());

        cp.add(sp, BorderLayout.CENTER);
        taUse.setEditable(false);
        taUse.setText(use());
        taUse.setSelectionColor(Color.white);
        taUse.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        taUse.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel pn = new JPanel();
        pn.add(btOk = new JButton("Ok"));
        cp.add(pn, BorderLayout.SOUTH);

        btOk.addActionListener(this);

        btOk.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    hide();
            }
        });

        taUse.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    hide();
            }
        });

        pack();
    }


    /**
     * Megjeleníti a dialógust.
     */
    public void showDialog() {
        WindowLocation.center(this);
        btOk.requestFocus();
        show();
        sp.getVerticalScrollBar().setValue(0);
    }


    /**
     * Elrejti az ablakot.
     */
    public void actionPerformed(ActionEvent e) {
        hide();
    }


    /**
     * Visszaadja a játék használatát egy stringben.
     */
    private String use() {
        return
                "The purpose of the game:\n" +
                        "\n" +
                        "Move the shapes into the correct position.\n" +
                        "If you fill an entire row with shapes, it will disappear.\n" +
                        "Try to fill multiple rows at once to earn more points.\n" +
                        "One row = 1,000 points\n" +
                        "Two rows = 3,000 points\n" +
                        "Three rows = 7,000 points\n" +
                        "Four rows = 15,000 points\n" +
                        "If you run out of space, the game will end.\n" +
                        "The speed increases after every 50,000 points.\n" +
                        "If the game feels too easy, stop and change the mode, speed, or level.\n" +
                        "You can also change the rotation, of course.\n" +
                        "\n" +
                        "\n" +
                        "Control keys:\n" +
                        "\n" +
                        "F2: New game / Clear game\n" +
                        "F3: Pause / Continue\n" +
                        "Space : Change direction of rotation / Rotate\n" +
                        "Left arrow: Change level / Move left\n" +
                        "Right arrow: Change speed / Move right\n" +
                        "Down arrow: Change mode / Move down\n";
    }
}