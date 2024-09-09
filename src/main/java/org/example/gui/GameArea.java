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


import org.example.element.Brick;
import org.example.element.Cross;
import org.example.element.L_1;
import org.example.element.L_2;
import org.example.element.L_3;
import org.example.element.Profile;
import org.example.element.Slim_1;
import org.example.element.Slim_2;
import org.example.element.Square;
import org.example.element.T_1;
import org.example.element.T_2;
import org.example.element.U;
import org.example.element.Z_1;
import org.example.element.Z_2;
import org.example.element.Z_3;
import org.example.element.Z_4;
import org.example.log.Data;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;


/**
 * A pálya, amelyen lepotyognak az idomok.
 */
public class GameArea extends JPanel implements Data {


    /**
     * Az oszlopok száma.
     */
    public static final int COLUMNS = 10;


    /**
     * A sorok száma.
     */
    public static final int ROWS = 20;


    /**
     * A pályát határoló téglalap.
     */
    public static final Rectangle BOUND =
            new Rectangle(0, 0, COLUMNS * UNIT, ROWS * UNIT);


    /**
     * Az összes lepotyogott tégla.
     */
    private Vector fallenBricks = new Vector();


    /**
     * Az éppen lepotyogó idom.
     */
    private Profile profile = null;


    /**
     * Az idõzítõ.
     */
    private Timer stopper;


    /**
     * A fõ ablak.
     */
    private TetrisFrame tetrisFrame;


    /**
     * A kijelzõ
     */
    private Display display;


    /**
     * A törölt sorok száma.
     */
    private int numberOfClearedRows;


    /**
     * Konstruktor.
     */
    public GameArea(TetrisFrame tetrisFrame, Display display) {
        this.tetrisFrame = tetrisFrame;
        this.display = display;
        setPreferredSize(new Dimension(COLUMNS * UNIT + 1, ROWS * UNIT + 1));
    }


    /**
     * Létrehozza az idõzítõt a megadott késleltetéssel.
     */
    private void newStopper(int delay) {
        stopper = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                down();
            }
        });
    }


    /**
     * Visszaadja, hogy az idom minden egyes téglája a pályán belül
     * helyezkedik-e el.
     */
    protected boolean within() {
        Vector bricks = profile.getBricks();
        for (int i = 0; i < bricks.size(); i++) {
            Brick brick = (Brick) bricks.get(i);
            if (!BOUND.contains(brick))
                return false;
        }
        return true;
    }


    /**
     * Visszaadja, hogy van-e olyan téglája az idomnak amelyik átfedésben
     * van a pályán egy másik idommal.
     */
    protected boolean overLap() {
        Vector bricks = profile.getBricks();
        for (int i = 0; i < bricks.size(); i++) {
            Brick brick = (Brick) bricks.get(i);
            for (int j = 0; j < fallenBricks.size(); j++) {
                Brick fallenBrick = (Brick) fallenBricks.get(j);
                if (brick.contains(fallenBrick))
                    return true;
            }
        }
        return false;
    }


    /**
     * Eltolja az idomot a megadott irányba, ha rossz helyre került az
     * idom akkor visszatolja eredeti helyére.
     */
    protected boolean moving(int x, int y) {
        profile.translate(x, y);
        if (!within() || overLap()) {
            profile.translate(-x, -y);
            return false;
        }
        repaint();
        return true;
    }


    /**
     * Elfordítja az idomot a megadott irányba. Ha rossz pozícióba került,
     * akkor visszafordítja.
     */
    protected void turn(boolean turn) {
        profile.turning(turn);
        profile.createProfile();
        if (!within() || overLap()) {
            profile.turning(!turn);
            profile.createProfile();
        }
        repaint();
    }


    /**
     * Bállítja az idõzítés értékét.
     */
    public void setDelay(int speed) {
        stopper.setDelay(delay(speed));
    }


    /**
     * A sebességbõl kiszámítja az idõzítést.
     */
    public int delay(int speed) {
        return (10 - speed) * 60;
    }


    /**
     * Elindítja a stoppert.
     */
    public void play() {
        stopper.start();
    }


    /**
     * Megállítja a stoppert, törli az elemeket.
     */
    public void stop() {
        stopper.stop();
        fallenBricks.clear();
        profile = null;
        display.stop();
        repaint();
    }


    /**
     * Megállítja a soppert.
     */
    public void pause() {
        stopper.stop();
    }


    /**
     * Megadott szintig feltölti a pályát foghíjas sorokkal.
     */
    private void fillIn(int level) {
        for (int i = ROWS - 1; i >= ROWS - level; i--) {
            boolean[] oneRow = oneRow();
            for (int j = 0; j < COLUMNS; j++) {
                if (oneRow[j])
                    fallenBricks.add(new Brick(j, i));
            }
        }
    }


    /**
     * Létrehoz és visszaad egy logikai tömböt, melynek mérete megegyezik
     * az oszlopok számával és mindenképpen tartalmaz egy false értéket.
     * Ez alapján lesz feltöltve a sor téglákkal foghíjasan.
     */
    private boolean[] oneRow() {
        boolean[] oneRow = new boolean[COLUMNS];
        for (int i = 0; i < oneRow.length; i++) {
            oneRow[i] = rnd(2) == 0 ? false : true;
        }
        if (!isGap(oneRow))
            oneRow[rnd(COLUMNS)] = false;
        return oneRow;
    }


    /**
     * Visszaadja, hogy a megadott logikai tömbben van false érték.
     */
    private boolean isGap(boolean[] oneRow) {
        for (int i = 0; i < oneRow.length; i++) {
            if (oneRow[i] == false)
                return true;
        }
        return false;
    }


    /**
     * Létrehoz és elindít egy új játékot.
     */
    public void newGame(int level, int speed) {
        newStopper(delay(speed));
        fallenBricks.clear();
        fillIn(level);
        newProfile();
        changeProfile();
        repaint();
        play();
    }


    /**
     * A következõ idomot(next) áthelyezi a pályára, beállítja a támpontját
     * és létrehoz egy új(next) idomot. Eközben figyeli, hogy vége van-e
     * a játéknak. Ha igen, akkor azt jelzi a fõ ablaknak.
     */
    private void changeProfile() {
        profile = display.getprofile();
        profile.newBase();
        newProfile();
        if (overLap()) {
            pause();
            tetrisFrame.setState(END);
            tetrisFrame.recordExamination();
        }
    }


    /**
     * Jobbra tolja az idomot.
     */
    public void right() {
        moving(1, 0);
    }


    /**
     * Balra tolja az idomot.
     */
    public void left() {
        moving(-1, 0);
    }


    /**
     * Lefelé tolja az idomot. Ha nem tolható lejjebb, akkor létrehoz
     * egy új idomot.
     */
    public void down() {
        if (!moving(0, 1)) {
            addBricks();
            examine();
            changeProfile();
        }
    }


    /**
     * Kiválasztja azokat a sorokat amelyek beteltek, törli azokat és
     * üzenetet küld a fõ ablaknak a törlés eredményérõl.
     */
    private void examine() {
        numberOfClearedRows = 0;
        for (int i = 0; i < 4; i++) { // max négy sort lehet törölni.
            for (int j = ROWS; j >= 0; j--) { // alulról felfelé
                int n = 0;
                for (int k = 0; k < fallenBricks.size(); k++) { // minden tégla meg lesz viszgálva
                    Brick brick = (Brick) fallenBricks.get(k);
                    if (brick.y == j * UNIT)
                        if (++n == COLUMNS)
                            clearRow(j);
                }
            }
        }
        repaint();
        tetrisFrame.setValues(numberOfClearedRows);
    }


    /**
     * Ha a megadott sorban mindenhol tégla található, akkor törli
     * az abban a sorban lévõ téglákat.
     */
    private void clearRow(int row) {
        for (int i = fallenBricks.size() - 1; i >= 0; i--) {
            Brick brick = (Brick) fallenBricks.get(i);
            if (brick.y == row * UNIT)
                fallenBricks.remove(brick);
        }
        ++numberOfClearedRows;
        pushDown(row);
    }


    /**
     * A kitörölt sor feletti téglákat eggyel lejjebb tolja.
     */
    private void pushDown(int row) {
        for (int i = 0; i < fallenBricks.size(); i++) {
            Brick brick = (Brick) fallenBricks.get(i);
            if (brick.y < row * UNIT)
                brick.translate(0, 1);
        }
    }


    /**
     * A leesett idom tégláit regisztrálja mint leesett téglát.
     */
    private void addBricks() {
        for (int i = 0; i < profile.getBricks().size(); i++)
            fallenBricks.add(profile.getBricks().get(i));
    }


    /**
     * létrehoz egy új idomot, amelyet a kijelzõn helyez el.
     */
    private void newProfile() {
        int turn = rnd(4);
        int countOfProfiles = tetrisFrame.getMode() == MODE_A ? 7 : 14;
        Profile next = null;

        switch (rnd(countOfProfiles)) {
            case 0:
                next = new Square(turn);
                break;
            case 1:
                next = new Slim_1(turn);
                break;
            case 2:
                next = new T_1(turn);
                break;
            case 3:
                next = new Z_1(turn);
                break;
            case 4:
                next = new Z_2(turn);
                break;
            case 5:
                next = new L_1(turn);
                break;
            case 6:
                next = new L_2(turn);
                break;
            case 7:
                next = new Cross(turn);
                break;
            case 8:
                next = new Z_3(turn);
                break;
            case 9:
                next = new Z_4(turn);
                break;
            case 10:
                next = new T_2(turn);
                break;
            case 11:
                next = new U(turn);
                break;
            case 12:
                next = new Slim_2(turn);
                break;
            case 13:
                next = new L_3(turn);
                break;
        }
        display.setProfile(next);
    }


    /**
     * Visszaadja az aktuális idomot.
     */
    public Profile getprofile() {
        return profile;
    }


    /**
     * Visszaad egy véletlenszámot 0 és max között.
     */
    private int rnd(int max) {
        return (int) (Math.random() * max);
    }


    /**
     * Kirajzolja a pályára az idomot és a lepotyogott téglákat, valamint
     * a rácsot.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //vízszintes vonalak
        g.setColor(Color.white);
        for (int i = 0; i < ROWS + 1; i++) {
            g.drawLine(0, i * UNIT, COLUMNS * UNIT, i * UNIT);
        }
        //függõleges vonalak
        for (int i = 0; i < COLUMNS + 1; i++) {
            g.drawLine(i * UNIT, 0, i * UNIT, ROWS * UNIT);
        }
        //leesett teglák
        for (int i = 0; i < fallenBricks.size(); i++) {
            Brick brick = (Brick) fallenBricks.get(i);
            paintBrick(brick, g);
        }
        //ha nincs megkezdett játék
        if (profile == null)
            return;
        //idom
        for (int i = 0; i < profile.getBricks().size(); i++) {
            Brick brick = (Brick) profile.getBricks().get(i);
            paintBrick(brick, g);
        }
    }


    /**
     * Megrajzol egy téglát.
     */
    private void paintBrick(Brick brick, Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRoundRect(brick.x + 1, brick.y + 1, brick.width - 1,
                brick.height - 1, 5, 5);
    }
}