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
 * A j�t�kban szerepl� L bet� alak� idom.
 */
public class L_1 extends Profile {


    /**
     * p�ld�nyinicializ�l� blokk.
     */ {
        turningX = new int[][]{{0, 0, 0, 1}, {2, 0, 1, 2},
                {0, 1, 1, 1}, {0, 1, 2, 0}};

        turningY = new int[][]{{1, 2, 3, 3}, {2, 3, 3, 3},
                {1, 1, 2, 3}, {2, 2, 2, 3}};
    }


    /**
     * Konstruktor.
     */
    public L_1(int turning) {
        super(turning);
        createProfile();
    }


    /**
     * Be�ll�tja az idom t�mpontj�t.
     */
    public void setBase() {
        base = turn % 2 == 0 ? new Point(4, -1) : new Point(4, -2);
    }
}