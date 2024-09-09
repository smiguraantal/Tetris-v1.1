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


public class Slim_2 extends Profile {


    /**
     * példányinicializáló blokk.
     */ {
        turningX = new int[][]{{1, 2}, {1, 1},
                {1, 2}, {1, 1}};

        turningY = new int[][]{{3, 3}, {2, 3},
                {3, 3}, {2, 3}};
    }


    /**
     * Konstruktor.
     */
    public Slim_2(int turning) {
        super(turning);
        createProfile();
    }


    /**
     * Beállítja az idom támpontját.
     */
    public void setBase() {
        base = turn % 2 == 0 ? new Point(3, -3) : new Point(3, -2);
    }
}