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
 * A j�t�kban szerepl� T bet� alak� idom.
 */
public class T_1 extends Profile {


    /**
     * p�ld�nyinicializ�l� blokk.
     */ {
        turningX = new int[][]{{1, 0, 1, 2}, {0, 1, 1, 1},
                {0, 1, 2, 1}, {0, 0, 0, 1}};

        turningY = new int[][]{{2, 3, 3, 3}, {2, 1, 2, 3},
                {2, 2, 2, 3}, {1, 2, 3, 2}};
    }


    /**
     * Konstruktor.
     */
    public T_1(int turning) {
        super(turning);
        createProfile();
    }


    /**
     * Be�ll�tja az idom t�mpontj�t.
     */
    public void setBase() {
        base = turn % 2 == 0 ? new Point(4, -2) : new Point(4, -1);
    }
}