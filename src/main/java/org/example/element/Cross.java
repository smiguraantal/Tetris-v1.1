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
 * A j�t�kban szerepl� kereszt alak� idom.
 */
public class Cross extends Profile {


    /**
     * p�ld�nyinicializ�l� blokk.
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
     * A keresztet nincs �rtelme forgatni.
     */
    protected void turn() {
    }


    /**
     * Be�ll�tja az idom t�mpontj�t.
     */
    public void setBase() {
        base = new Point(4, -1);
    }
}