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
 * A játékban lepotyogó idomok absztrakt osztálya. Példány nem hozható
 * létre belõle.
 */
public abstract class Profile {


    /**
     * Az idom tégláinak viszonyítási pontja.
     */
    protected Point base = new Point();


    /**
     * Az idom által tarlatmazott téglák.
     */
    protected Vector bricks = new Vector();


    /**
     * Az idom elfordultságát tároló adat. Egy negyed fordulattal eggyel
     * növekszik vagy csökken a változó.
     */
    protected int turn;


    /**
     * A támponthoz képesti az elfordultságtól függõ x koordináta. Az
     * elsõ dimenzió az elfordulás mértéke, a második pedig a téglánkénti
     * x koordináta.
     */
    protected int[][] turningX;


    /**
     * A támponthoz képesti az elfordultságtól függõ y koordináta. Az
     * elsõ dimenzió az elfordulás mértéke, a második pedig a téglánkénti
     * y koordináta.
     */
    protected int[][] turningY;


    /**
     * Konstruktor.
     */
    protected Profile(int turn) {
        this.turn = turn;
    }


    /**
     * Inicializálja a téglák pozíciójit.
     */
    public void createProfile() {
        bricks.clear();
        for (int i = 0; i < turningY[0].length; i++)
            bricks.add(new Brick(base.x + turningX[turn][i],
                    base.y + turningY[turn][i]));
    }


    /**
     * Új támpontot ad az idomnak, majd újra inicializálja az idomot.
     */
    public void newBase() {
        setBase();
        createProfile();
    }


    /**
     * Beállítja az idom alapját.
     */
    abstract void setBase();


    /**
     * Visszaadja az idom alapját.
     */
    public Point getBase() {
        return base;
    }


    /**
     * Eltolja a kapott idom tégláit a megadott irányba.
     */
    public void translate(int x, int y) {
        for (int i = 0; i < bricks.size(); i++) {
            Brick brick = (Brick) bricks.get(i);
            brick.translate(x, y);
        }
        base.translate(x, y);
    }


    /**
     * Az iránytól függõen a megfelelõ irányba fordítja az idomot.
     */
    public void turning(boolean turn) {
        if (turn)
            turnLeft();
        else
            turnRight();
    }


    /**
     * Eggyel növeli az fordulat értékét, ha az nagyobb, mint három,
     * akkor a fordulat értéke nulla lesz.
     */
    protected void turnLeft() {
        if (++turn > 3)
            turn = 0;
    }


    /**
     * Eggyel csökkenti a fordulat értékét, ha az kisebb, mint nulla,
     * akkor a fordulat értéke három lesz.
     */
    protected void turnRight() {
        if (--turn < 0)
            turn = 3;
    }


    /**
     * Visszaadja az idom tégláit.
     */
    public Vector getBricks() {
        return bricks;
    }
}