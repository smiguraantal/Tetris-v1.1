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


import org.example.log.Data;

import java.awt.Rectangle;


/**
 * Egy idom r�sz�t alkot� t�gla.
 */
public class Brick extends Rectangle implements Data {


    /**
     * Konstruktor.
     */
    public Brick(int x, int y) {
        super(x * UNIT, y * UNIT, UNIT, UNIT);
    }


    /**
     * Eltolja a t�gl�t x �s y egys�gnyi t�vols�gra.
     */
    public void translate(int x, int y) {
        super.translate(x * UNIT, y * UNIT);
    }
}