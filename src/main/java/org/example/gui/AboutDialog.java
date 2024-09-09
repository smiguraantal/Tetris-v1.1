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

import com.borland.jbcl.layout.VerticalFlowLayout;
import com.borland.jbcl.layout.XYConstraints;
import com.borland.jbcl.layout.XYLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

/**
 * A programról néhány információt megjelenítõ dialógus.
 */
public class AboutDialog extends JDialog {

    /**
     * A megjelenõ szöveg betûtípusa
     */
    private Font font = new Font("Times New Roman", Font.PLAIN, 15);

    Border border1;
    Border border2;
    Border border3;
    Border border4;
    Border border5;
    Border border6;
    Border border7;
    Border border8;
    JPanel jPanel1 = new JPanel();
    GridBagLayout gridBagLayout1 = new GridBagLayout();
    JPanel jPanel2 = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel3 = new JPanel();
    JPanel jPanel4 = new JPanel();
    JPanel jPanel5 = new JPanel();
    BorderLayout borderLayout2 = new BorderLayout();
    JPanel jPanel6 = new JPanel();
    JPanel jPanel7 = new JPanel();
    VerticalFlowLayout verticalFlowLayout1 = new VerticalFlowLayout();
    JPanel jPanel8 = new JPanel();
    JLabel jLabel1 = new JLabel();
    JPanel jPanel10 = new JPanel();
    JLabel jLabel3 = new JLabel();
    JPanel jPanel11 = new JPanel();
    JLabel jLabel4 = new JLabel();
    XYLayout xYLayout1 = new XYLayout();
    JPanel jPanel12 = new JPanel();
    Border border9;
    JPanel jPanel13 = new JPanel();
    Border border10;
    JPanel jPanel14 = new JPanel();
    Border border11;
    JPanel jPanel15 = new JPanel();
    Border border12;
    JPanel jPanel16 = new JPanel();
    Border border13;
    JPanel jPanel17 = new JPanel();
    Border border14;
    XYLayout xYLayout2 = new XYLayout();
    JSeparator jSeparator1 = new JSeparator();
    Border border15;
    JSeparator jSeparator2 = new JSeparator();
    Border border16;
    JSeparator jSeparator3 = new JSeparator();
    Border border17;
    JPanel jPanel18 = new JPanel();
    Border border18;
    JPanel jPanel19 = new JPanel();
    Border border19;
    JPanel jPanel20 = new JPanel();
    Border border20;
    GridBagLayout gridBagLayout2 = new GridBagLayout();
    JButton btClose = new JButton();
    JPanel jPanel21 = new JPanel();
    JLabel jLabel5 = new JLabel();
    Border border21;
    Border border22;
    Border border23;
    Border border24;

    /**
     * Konstruktor.
     */
    public AboutDialog(Frame frame) {
        super(frame, true);
        try {
            jbInit();
            pack();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * Felépíti a dialógust.
     */
    private void jbInit() throws Exception {
        border21 = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(Color.white, new Color(165, 163, 151)), BorderFactory.createEmptyBorder(5, 15, 5, 15));
        border22 = BorderFactory.createEmptyBorder(5, 0, 5, 0);
        border23 = BorderFactory.createEmptyBorder(0, 0, 5, 0);
        border24 = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(Color.white, new Color(156, 156, 158)), BorderFactory.createEmptyBorder(5, 15, 5, 15));
        setResizable(false);
        border1 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(109, 109, 110), new Color(156, 156, 158));
        border2 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(124, 124, 124), new Color(178, 178, 178));
        border3 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(124, 124, 124), new Color(178, 178, 178));
        border4 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(124, 124, 124), new Color(178, 178, 178));
        border5 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(124, 124, 124), new Color(178, 178, 178));
        border6 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(124, 124, 124), new Color(178, 178, 178));
        border7 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(124, 124, 124), new Color(178, 178, 178));
        border8 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(124, 124, 124), new Color(178, 178, 178));
        border9 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(109, 109, 110), new Color(156, 156, 158));
        border10 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(109, 109, 110), new Color(156, 156, 158));
        border11 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(109, 109, 110), new Color(156, 156, 158));
        border12 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(109, 109, 110), new Color(156, 156, 158));
        border13 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(109, 109, 110), new Color(156, 156, 158));
        border14 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(109, 109, 110), new Color(156, 156, 158));
        border15 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(124, 124, 124), new Color(178, 178, 178));
        border16 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(124, 124, 124), new Color(178, 178, 178));
        border17 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(124, 124, 124), new Color(178, 178, 178));
        border18 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(109, 109, 110), new Color(156, 156, 158));
        border19 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(109, 109, 110), new Color(156, 156, 158));
        border20 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(109, 109, 110), new Color(156, 156, 158));
        jPanel1.setLayout(gridBagLayout1);
        jPanel2.setLayout(borderLayout1);
        jPanel4.setLayout(borderLayout2);
        jPanel7.setLayout(verticalFlowLayout1);

        jLabel1.setFont(new Font("Serif", Font.PLAIN, 18));
        jLabel1.setBorder(border22);
        jLabel1.setDoubleBuffered(false);
        jLabel3.setFont(font);
        jLabel4.setFont(font);
        jLabel4.setBorder(border23);
        jLabel5.setFont(font);

        jLabel1.setText("TETRIS");
        jLabel5.setText("Version 1.1");
        jLabel3.setText("Copyright \u00A9 Smigura Antal");
        jLabel4.setText("September 2003");

        jPanel5.setLayout(xYLayout1);
        jPanel5.setPreferredSize(new Dimension(200, 25));
        jPanel12.setBorder(border9);
        jPanel12.setPreferredSize(new Dimension(3, 25));
        jPanel13.setBorder(border10);
        jPanel13.setPreferredSize(new Dimension(3, 22));
        jPanel14.setBorder(border11);
        jPanel14.setPreferredSize(new Dimension(3, 19));
        jPanel15.setBorder(border12);
        jPanel15.setPreferredSize(new Dimension(200, 3));
        jPanel16.setBorder(border13);
        jPanel16.setPreferredSize(new Dimension(150, 3));
        jPanel17.setBorder(border14);
        jPanel17.setPreferredSize(new Dimension(100, 3));
        jPanel6.setLayout(xYLayout2);
        jPanel6.setPreferredSize(new Dimension(200, 25));
        jSeparator1.setBorder(border15);
        jSeparator1.setOpaque(false);
        jSeparator1.setPreferredSize(new Dimension(200, 3));
        jSeparator2.setBorder(border16);
        jSeparator2.setPreferredSize(new Dimension(150, 3));
        jSeparator3.setBorder(border17);
        jSeparator3.setPreferredSize(new Dimension(100, 3));
        jPanel18.setBorder(border18);
        jPanel18.setPreferredSize(new Dimension(3, 25));
        jPanel19.setBorder(border19);
        jPanel19.setPreferredSize(new Dimension(3, 22));
        jPanel20.setBorder(border20);
        jPanel20.setPreferredSize(new Dimension(3, 19));
        jPanel3.setLayout(gridBagLayout2);
        btClose.setAlignmentY((float) 0.5);
        btClose.setText("Ok");
        this.setTitle("About Tetris");
        this.setModal(true);
        jPanel21.setForeground(Color.darkGray);
        this.getContentPane().add(jPanel1, BorderLayout.CENTER);
        jPanel1.add(jPanel2, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0
                , GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 5, 0, 5), 0, 0));
        jPanel2.add(jPanel3, BorderLayout.SOUTH);
        jPanel3.add(btClose, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
                , GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(15, 0, 5, 0), 0, 0));
        jPanel2.add(jPanel4, BorderLayout.CENTER);
        jPanel4.add(jPanel5, BorderLayout.NORTH);

        jPanel5.add(jPanel15, new XYConstraints(0, 3, -1, -1));
        jPanel5.add(jPanel16, new XYConstraints(0, 8, -1, -1));
        jPanel5.add(jPanel17, new XYConstraints(0, 13, -1, -1));
        jPanel5.add(jPanel12, new XYConstraints(3, 0, -1, -1));
        jPanel5.add(jPanel13, new XYConstraints(8, 0, -1, -1));
        jPanel5.add(jPanel14, new XYConstraints(13, 0, -1, -1));

        jPanel4.add(jPanel6, BorderLayout.SOUTH);
        jPanel6.add(jSeparator1, new XYConstraints(0, 19, -1, -1));
        jPanel6.add(jSeparator2, new XYConstraints(50, 14, -1, -1));
        jPanel6.add(jSeparator3, new XYConstraints(100, 9, -1, -1));
        jPanel6.add(jPanel18, new XYConstraints(194, 0, -1, -1));
        jPanel6.add(jPanel19, new XYConstraints(189, 3, -1, -1));
        jPanel6.add(jPanel20, new XYConstraints(184, 6, -1, -1));
        jPanel4.add(jPanel7, BorderLayout.CENTER);
        jPanel7.add(jPanel8, null);
        jPanel8.add(jLabel1, null);
        jPanel7.add(jPanel21, null);
        jPanel21.add(jLabel5, null);
        jPanel7.add(jPanel10, null);
        jPanel10.add(jLabel3, null);
        jPanel7.add(jPanel11, null);
        jPanel11.add(jLabel4, null);

        btClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hide();
            }
        });

        addKeyListening();

        pack();
    }

    /**
     * Hozzáadja a komponensekhez az ablakbecsukás figyelését.
     */
    private void addKeyListening() {
        Vector components = new Vector();
        components.add(btClose);

        for (int i = 0; i < components.size(); i++) {
            Component component = (Component) components.get(i);
            component.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    keyListening(e);
                }
            });
        }
    }

    /**
     * Escape-re a dialógus eltûnik.
     */
    private void keyListening(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            hide();
    }


    /**
     * Megjeleníti a dialógust.
     */
    public void showDialog() {
        WindowLocation.center(this);
        btClose.requestFocus();
        show();
    }
}