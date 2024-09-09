/**
 * <p>Title: Tetris</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.1
 */

package org.example.log;


import javax.swing.ImageIcon;


/**
 * A játékhoz tartozó konstans adatok.
 */
public interface Data {


    /**
     * A játékban használt ikonok.
     */
    public static final ImageIcon SWING_RIGHT = new ImageIcon("images/right.gif");
    public static final ImageIcon SWING_LEFT = new ImageIcon("images/left.gif");
    public static final ImageIcon COFFEE = new ImageIcon("images/coffee.gif");


    /**
     * Egy tégla mérete.
     */
    public static final int UNIT = 24;


    /**
     * A játék lehetséges állapotai.
     */
    public static final int STOP = 0;
    public static final int PLAY = 1;
    public static final int PAUSE = 2;
    public static final int END = 3;


    /**
     * A játék lehetséges típusai.
     */
    public static final String MODE_A = "A";
    public static final String MODE_B = "B";
}