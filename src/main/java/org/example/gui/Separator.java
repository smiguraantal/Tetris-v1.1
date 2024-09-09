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


import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


/**
 * Egy vékony sáv amely elválasztja a pályát a kijelzõtõl.
 */
public class Separator extends JPanel {


    /**
     * Konstruktor.
     */
    public Separator(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }


    /**
     * Bevonalazza a komponenst.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.drawLine(getWidth() - 2, 0, getWidth() - 2, getHeight() - 1);
        g.setColor(Color.red);
        g.drawLine(0, 0, 0, getHeight() - 1);
        g.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight() - 1);
    }
}