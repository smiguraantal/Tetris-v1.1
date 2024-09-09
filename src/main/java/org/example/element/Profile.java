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
import java.util.Vector;


/**
 * A j�t�kban lepotyog� idomok absztrakt oszt�lya. P�ld�ny nem hozhat�
 * l�tre bel�le.
 */
public abstract class Profile {


    /**
     * Az idom t�gl�inak viszony�t�si pontja.
     */
    protected Point base = new Point();


    /**
     * Az idom �ltal tarlatmazott t�gl�k.
     */
    protected Vector bricks = new Vector();


    /**
     * Az idom elfordults�g�t t�rol� adat. Egy negyed fordulattal eggyel
     * n�vekszik vagy cs�kken a v�ltoz�.
     */
    protected int turn;


    /**
     * A t�mponthoz k�pesti az elfordults�gt�l f�gg� x koordin�ta. Az
     * els� dimenzi� az elfordul�s m�rt�ke, a m�sodik pedig a t�gl�nk�nti
     * x koordin�ta.
     */
    protected int[][] turningX;


    /**
     * A t�mponthoz k�pesti az elfordults�gt�l f�gg� y koordin�ta. Az
     * els� dimenzi� az elfordul�s m�rt�ke, a m�sodik pedig a t�gl�nk�nti
     * y koordin�ta.
     */
    protected int[][] turningY;


    /**
     * Konstruktor.
     */
    protected Profile(int turn) {
        this.turn = turn;
    }


    /**
     * Inicializ�lja a t�gl�k poz�ci�jit.
     */
    public void createProfile() {
        bricks.clear();
        for (int i = 0; i < turningY[0].length; i++)
            bricks.add(new Brick(base.x + turningX[turn][i],
                    base.y + turningY[turn][i]));
    }


    /**
     * �j t�mpontot ad az idomnak, majd �jra inicializ�lja az idomot.
     */
    public void newBase() {
        setBase();
        createProfile();
    }


    /**
     * Be�ll�tja az idom alapj�t.
     */
    abstract void setBase();


    /**
     * Visszaadja az idom alapj�t.
     */
    public Point getBase() {
        return base;
    }


    /**
     * Eltolja a kapott idom t�gl�it a megadott ir�nyba.
     */
    public void translate(int x, int y) {
        for (int i = 0; i < bricks.size(); i++) {
            Brick brick = (Brick) bricks.get(i);
            brick.translate(x, y);
        }
        base.translate(x, y);
    }


    /**
     * Az ir�nyt�l f�gg�en a megfelel� ir�nyba ford�tja az idomot.
     */
    public void turning(boolean turn) {
        if (turn)
            turnLeft();
        else
            turnRight();
    }


    /**
     * Eggyel n�veli az fordulat �rt�k�t, ha az nagyobb, mint h�rom,
     * akkor a fordulat �rt�ke nulla lesz.
     */
    protected void turnLeft() {
        if (++turn > 3)
            turn = 0;
    }


    /**
     * Eggyel cs�kkenti a fordulat �rt�k�t, ha az kisebb, mint nulla,
     * akkor a fordulat �rt�ke h�rom lesz.
     */
    protected void turnRight() {
        if (--turn < 0)
            turn = 3;
    }


    /**
     * Visszaadja az idom t�gl�it.
     */
    public Vector getBricks() {
        return bricks;
    }
}