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


public class Z_4 extends Profile {


    /**
     * p�ld�nyinicializ�l� blokk.
     */ {
        turningX = new int[][]{{2, 0, 1, 2, 0}, {0, 1, 1, 1, 2},
                {2, 0, 1, 2, 0}, {0, 1, 1, 1, 2}};

        turningY = new int[][]{{1, 2, 2, 2, 3}, {1, 1, 2, 3, 3},
                {1, 2, 2, 2, 3}, {1, 1, 2, 3, 3}};
    }


    /**
     * Konstruktor.
     */
    public Z_4(int turning) {
        super(turning);
        createProfile();
    }


    /**
     * Be�ll�tja az idom t�mpontj�t.
     */
    public void setBase() {
        base = new Point(4, -1);
    }
}