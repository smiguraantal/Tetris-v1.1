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


import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;


/**
 * A kapott ablakot a k�perny�n elhelyez� oszt�ly.
 */
public class WindowLocation {


    /**
     * A k�perny� m�rete.
     */
    private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();


    /**
     * Az oszt�lyb�l nem lehet p�ld�nyt l�trehozni.
     */
    private WindowLocation() {
    }


    /**
     * A param�terben kapott ablakot a k�perny� k�zep�re helyezi.
     */
    public static void center(Window win) {
        win.setLocation((dim.width - win.getWidth()) / 2,
                (dim.height - win.getHeight()) / 2);
    }


    /**
     * A param�terben kapott ablakot a k�perny� tetej�re helyezi.
     */
    public static void north(Window win) {
        win.setLocation((dim.width - win.getWidth()) / 2, 0);
    }
}