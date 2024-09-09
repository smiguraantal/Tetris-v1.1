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
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Locale;


/**
 * A legjobb eredmény megjelenítõ dialógus.
 */
public class BestResultDialog extends JDialog implements ActionListener {


    /**
     * Tartalompanel.
     */
    private Container cp = getContentPane();


    /**
     * A nevet megjelenítõ cimke.
     */
    private SpecLabel lbName =
            new SpecLabel("", SpecLabel.LEFT);


    /**
     * A törölt sorok számát megjelenítõ cimke.
     */
    private SpecLabel lbLines =
            new SpecLabel("", SpecLabel.CENTER);


    /**
     * A pontok számát megjelenítõ dialógus.
     */
    private SpecLabel lbScore =
            new SpecLabel("", SpecLabel.CENTER);


    /**
     * Az ok gomb.
     */
    private JButton btOk;


    /**
     * Konstruktor, felépíti a dialógust.
     */
    public BestResultDialog(TetrisFrame tetrisFrame) {
        super(tetrisFrame, "Best result", true);

        JPanel pn = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        pn.setLayout(gridbag);
        c.fill = GridBagConstraints.HORIZONTAL;

        //name
        SpecLabel lb = new SpecLabel("Name", SpecLabel.LEFT);
        c.gridx = 0;
        c.gridy = 0;
        gridbag.setConstraints(lb, c);
        pn.add(lb);

        //lines
        lb = new SpecLabel("Lines", SpecLabel.CENTER);
        c.gridx = 1;
        c.gridy = 0;
        gridbag.setConstraints(lb, c);
        pn.add(lb);

        //score
        lb = new SpecLabel("Score", SpecLabel.CENTER);
        c.gridx = 2;
        c.gridy = 0;
        gridbag.setConstraints(lb, c);
        pn.add(lb);

        //lbName
        c.gridx = 0;
        c.gridy = 1;
        gridbag.setConstraints(lbName, c);
        pn.add(lbName);

        //lbLines
        c.gridx = 1;
        c.gridy = 1;
        gridbag.setConstraints(lbLines, c);
        pn.add(lbLines);

        //lbScore
        c.gridx = 2;
        c.gridy = 1;
        gridbag.setConstraints(lbScore, c);
        pn.add(lbScore);

        cp.add(pn, BorderLayout.CENTER);

        pn = new JPanel();
        pn.add(btOk = new JButton("Ok"));
        cp.add(pn, BorderLayout.SOUTH);
        btOk.addActionListener(this);

        btOk.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    hide();
            }
        });
    }


    /**
     * Beállítja a cimkék értékét és megjeleníti a dialógust.
     */
    public void showDialog(String name, int lines, int score) {
        lbName.setText(format(name));
        lbLines.setText(format(lines));
        lbScore.setText(format(score));
        pack();
        WindowLocation.center(this);
        show();
    }


    /**
     * A kapott string hosszát 20-ra állítja
     */
    private String format(String name) {
        if (name.length() > 20) {
            StringBuffer formattedName = new StringBuffer(name);
            formattedName.setLength(20);
            return formattedName.toString();
        }
        return name;
    }


    /**
     * Stringként adja vissza a megformázott számot.
     */
    private String format(int number) {
        Locale locale = Locale.US;
        NumberFormat nf = NumberFormat.getNumberInstance(locale);
        return nf.format(number);
    }


    /**
     * Elrejti a dialógust.
     */
    public void actionPerformed(ActionEvent e) {
        hide();
    }
}