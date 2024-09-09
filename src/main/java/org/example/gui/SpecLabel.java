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
 * Cimke a dialógusokhoz.
 */
public class SpecLabel extends JLabel {


    /**
     * Konstruktor.
     */
    public SpecLabel(String text, int alignment) {
        super(text, alignment);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setFont(new Font("Times New Roman", Font.PLAIN, 14));
        setForeground(Color.black);
    }
}