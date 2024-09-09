/**
 * <p>Title: Tetris</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.1
 */

package org.example.log;


import java.io.Serializable;


/**
 * A legjobb eredm�nnyel rendelkez� j�t�kos.
 */
public class Recorder implements Serializable {


    /**
     * A j�t�kos neve.
     */
    private String name;


    /**
     * A t�r�lt sorok sz�ma.
     */
    private int lines;


    /**
     * A gy�jt�tt pontok sz�ma.
     */
    private int points;


    /**
     * Konstruktor, be�ll�tja az adatokat.
     */
    public Recorder(String name, int lines, int points) {
        this.name = name;
        this.lines = lines;
        this.points = points;
    }


    /**
     * Visszaadja a j�t�kos nev�t.
     */
    public String getName() {
        return name;
    }


    /**
     * Visszaadja a t�r�lt sorok sz�m�t.
     */
    public int getLines() {
        return lines;
    }


    /**
     * Visszaadja a gy�jt�tt pontokat.
     */
    public int getPoints() {
        return points;
    }
}