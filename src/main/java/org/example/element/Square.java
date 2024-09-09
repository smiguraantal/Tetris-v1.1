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
 * A j�t�kban szerepl� n�gyzet alak� idom.
 */
public class Square extends Profile {


    /**
     * p�ld�nyinicializ�l� blokk.
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
     * A n�gyzetet nincs �rtelme forgatni.
     */
    protected void turn() {
    }


    /**
     * Be�ll�tja az idom t�mpontj�t.
     */
    public void setBase() {
        base = new Point(3, -2);
    }
}