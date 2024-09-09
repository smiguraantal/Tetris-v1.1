/**
 * <p>Title: Tetris</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 *
 * @author Smigura Antal
 * @version 1.1
 */

package org.example.gui;


import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;


/**
 * Monospaced betûtípusú cimke.
 */
public class MonospacedLabel extends JLabel {


    /**
     * Konstruktor.
     */
    public MonospacedLabel(String text, int alignment, int fontSize) {
        super(text, alignment);
        setProperties(fontSize);
    }


    /**
     * Konstuktor.
     */
    public MonospacedLabel(String text, int fontSize) {
        super(text);
        setProperties(fontSize);
    }


    /**
     * Beállítja a szükséges tulajdonságokat.
     */
    private void setProperties(int fontSize) {
        setFont(new Font("Monospaced", Font.BOLD, fontSize));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setForeground(Color.black);
    }
}