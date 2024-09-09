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
 * A játékban szereplõ négyzet alakú idom.
 */
public class Square extends Profile {


    /**
     * példányinicializáló blokk.
     */ {
        turningX = new int[][]{{1, 2, 1, 2}, {1, 2, 1, 2},
                {1, 2, 1, 2}, {1, 2, 1, 2}};

        turningY = new int[][]{{2, 2, 3, 3}, {2, 2, 3, 3},
                {2, 2, 3, 3}, {2, 2, 3, 3}};
    }


    /**
     * Konstruktor.
     */
    public Square(int turning) {
        super(turning);
        createProfile();
    }


    /**
     * A négyzetet nincs értelme forgatni.
     */
    protected void turn() {
    }


    /**
     * Beállítja az idom támpontját.
     */
    public void setBase() {
        base = new Point(3, -2);
    }
}