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
 * A kapott ablakot a képernyõn elhelyezõ osztály.
 */
public class WindowLocation {


    /**
     * A képernyõ mérete.
     */
    private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();


    /**
     * Az osztályból nem lehet példányt létrehozni.
     */
    private WindowLocation() {
    }


    /**
     * A paraméterben kapott ablakot a képernyõ közepére helyezi.
     */
    public static void center(Window win) {
        win.setLocation((dim.width - win.getWidth()) / 2,
                (dim.height - win.getHeight()) / 2);
    }


    /**
     * A paraméterben kapott ablakot a képernyõ tetejére helyezi.
     */
    public static void north(Window win) {
        win.setLocation((dim.width - win.getWidth()) / 2, 0);
    }
}