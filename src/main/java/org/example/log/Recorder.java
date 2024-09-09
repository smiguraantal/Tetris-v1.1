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
 * A legjobb eredménnyel rendelkezõ játékos.
 */
public class Recorder implements Serializable {


    /**
     * A játékos neve.
     */
    private String name;


    /**
     * A törölt sorok száma.
     */
    private int lines;


    /**
     * A gyûjtött pontok száma.
     */
    private int points;


    /**
     * Konstruktor, beállítja az adatokat.
     */
    public Recorder(String name, int lines, int points) {
        this.name = name;
        this.lines = lines;
        this.points = points;
    }


    /**
     * Visszaadja a játékos nevét.
     */
    public String getName() {
        return name;
    }


    /**
     * Visszaadja a törölt sorok számát.
     */
    public int getLines() {
        return lines;
    }


    /**
     * Visszaadja a gyûjtött pontokat.
     */
    public int getPoints() {
        return points;
    }
}