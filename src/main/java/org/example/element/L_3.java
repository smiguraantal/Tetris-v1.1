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


public class L_3 extends Profile {


    /**
     * példányinicializáló blokk.
     */ {
        turningX = new int[][]{{1, 1, 2}, {2, 1, 2},
                {1, 2, 2}, {1, 2, 1}};

        turningY = new int[][]{{2, 3, 3}, {2, 3, 3},
                {2, 2, 3}, {2, 2, 3}};
    }


    /**
     * Konstruktor.
     */
    public L_3(int turning) {
        super(turning);
        createProfile();
    }


    /**
     * Beállítja az idom támpontját.
     */
    public void setBase() {
        base = new Point(3, -2);
    }
}