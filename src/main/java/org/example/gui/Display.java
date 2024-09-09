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

import org.example.element.Brick;
import org.example.element.Profile;
import org.example.log.Data;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


/**
 * Kijelzõ, amely a következõ idomot mutatja.
 */
public class Display extends JPanel implements Data {


    /**
     * Az oszlopok száma.
     */
    public static final int COLUMNS = 4;


    /**
     * A sorok száma.
     */
    public static final int ROWS = 4;


    /**
     * Az következõ idom.
     */
    private Profile profile;


    /**
     * Konstruktor.
     */
    public Display() {
        setPreferredSize(new Dimension(COLUMNS * UNIT + 1, ROWS * UNIT + 1));
    }


    /**
     * Beállítja az idomot.
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
        repaint();
    }


    /**
     * Visszaadja az aktuális idomot.
     */
    public Profile getprofile() {
        return profile;
    }


    /**
     * Törli a idomot.
     */
    public void stop() {
        profile = null;
        repaint();
    }


    /**
     * Megrajzolja az idomot és a rácsot.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //vízszintes vonalak
        g.setColor(Color.white);
        for (int i = 0; i < ROWS + 1; i++) {
            g.drawLine(0, i * UNIT, COLUMNS * UNIT, i * UNIT);
        }
        //függõleges vonalak
        for (int i = 0; i < COLUMNS + 1; i++) {
            g.drawLine(i * UNIT, 0, i * UNIT, ROWS * UNIT);
        }
        //ha nincs megkezdett játék
        if (profile == null)
            return;
        //idom
        for (int i = 0; i < profile.getBricks().size(); i++) {
            Brick brick = (Brick) profile.getBricks().get(i);
            paintBrick(brick, g);
        }
    }


    /**
     * Megrajzol egy téglát.
     */
    private void paintBrick(Brick brick, Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRoundRect(brick.x + 1, brick.y + 1, brick.width - 1,
                brick.height - 1, 5, 5);
    }
}