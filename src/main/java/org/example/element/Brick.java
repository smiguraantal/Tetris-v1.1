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
 * Egy idom részét alkotó tégla.
 */
public class Brick extends Rectangle implements Data {


    /**
     * Konstruktor.
     */
    public Brick(int x, int y) {
        super(x * UNIT, y * UNIT, UNIT, UNIT);
    }


    /**
     * Eltolja a téglát x és y egységnyi távolságra.
     */
    public void translate(int x, int y) {
        super.translate(x * UNIT, y * UNIT);
    }
}