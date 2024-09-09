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


public class U extends Profile {


    /**
     * példányinicializáló blokk.
     */ {
        turningX = new int[][]{{0, 2, 0, 1, 2}, {1, 2, 2, 1, 2},
                {0, 1, 2, 0, 2}, {0, 1, 0, 0, 1}};

        turningY = new int[][]{{2, 2, 3, 3, 3}, {1, 1, 2, 3, 3},
                {1, 1, 1, 2, 2}, {1, 1, 2, 3, 3}};
    }


    /**
     * Konstruktor.
     */
    public U(int turning) {
        super(turning);
        createProfile();
    }


    /**
     * Beállítja az idom támpontját.
     */
    public void setBase() {
        base = turn == 0 ? new Point(4, -2) : new Point(4, -1);
    }
}