/**
 * <p>Title: Tetris</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.1
 */

package org.example.element;

import java.awt.Point;


/**
 * A játékban szereplõ kereszt alakú idom.
 */
public class Cross extends Profile {


    /**
     * példányinicializáló blokk.
     */ {
        turningX = new int[][]{{1, 0, 1, 2, 1}, {1, 0, 1, 2, 1},
                {1, 0, 1, 2, 1}, {1, 0, 1, 2, 1}};

        turningY = new int[][]{{1, 2, 2, 2, 3}, {1, 2, 2, 2, 3},
                {1, 2, 2, 2, 3}, {1, 2, 2, 2, 3}};
    }


    /**
     * Konstruktor.
     */
    public Cross(int turning) {
        super(turning);
        createProfile();
    }


    /**
     * A keresztet nincs értelme forgatni.
     */
    protected void turn() {
    }


    /**
     * Beállítja az idom támpontját.
     */
    public void setBase() {
        base = new Point(4, -1);
    }
}