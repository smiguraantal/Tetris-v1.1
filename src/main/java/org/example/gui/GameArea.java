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
 * A p�lya, amelyen lepotyognak az idomok.
 */
public class GameArea extends JPanel implements Data {


    /**
     * Az oszlopok sz�ma.
     */
    public static final int COLUMNS = 10;


    /**
     * A sorok sz�ma.
     */
    public static final int ROWS = 20;


    /**
     * A p�ly�t hat�rol� t�glalap.
     */
    public static final Rectangle BOUND =
            new Rectangle(0, 0, COLUMNS * UNIT, ROWS * UNIT);


    /**
     * Az �sszes lepotyogott t�gla.
     */
    private Vector fallenBricks = new Vector();


    /**
     * Az �ppen lepotyog� idom.
     */
    private Profile profile = null;


    /**
     * Az id�z�t�.
     */
    private Timer stopper;


    /**
     * A f� ablak.
     */
    private TetrisFrame tetrisFrame;


    /**
     * A kijelz�
     */
    private Display display;


    /**
     * A t�r�lt sorok sz�ma.
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
     * L�trehozza az id�z�t�t a megadott k�sleltet�ssel.
     */
    private void newStopper(int delay) {
        stopper = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                down();
            }
        });
    }


    /**
     * Visszaadja, hogy az idom minden egyes t�gl�ja a p�ly�n bel�l
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
     * Visszaadja, hogy van-e olyan t�gl�ja az idomnak amelyik �tfed�sben
     * van a p�ly�n egy m�sik idommal.
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
     * Eltolja az idomot a megadott ir�nyba, ha rossz helyre ker�lt az
     * idom akkor visszatolja eredeti hely�re.
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
     * Elford�tja az idomot a megadott ir�nyba. Ha rossz poz�ci�ba ker�lt,
     * akkor visszaford�tja.
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
     * B�ll�tja az id�z�t�s �rt�k�t.
     */
    public void setDelay(int speed) {
        stopper.setDelay(delay(speed));
    }


    /**
     * A sebess�gb�l kisz�m�tja az id�z�t�st.
     */
    public int delay(int speed) {
        return (10 - speed) * 60;
    }


    /**
     * Elind�tja a stoppert.
     */
    public void play() {
        stopper.start();
    }


    /**
     * Meg�ll�tja a stoppert, t�rli az elemeket.
     */
    public void stop() {
        stopper.stop();
        fallenBricks.clear();
        profile = null;
        display.stop();
        repaint();
    }


    /**
     * Meg�ll�tja a soppert.
     */
    public void pause() {
        stopper.stop();
    }


    /**
     * Megadott szintig felt�lti a p�ly�t fogh�jas sorokkal.
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
     * L�trehoz �s visszaad egy logikai t�mb�t, melynek m�rete megegyezik
     * az oszlopok sz�m�val �s mindenk�ppen tartalmaz egy false �rt�ket.
     * Ez alapj�n lesz felt�ltve a sor t�gl�kkal fogh�jasan.
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
     * Visszaadja, hogy a megadott logikai t�mbben van false �rt�k.
     */
    private boolean isGap(boolean[] oneRow) {
        for (int i = 0; i < oneRow.length; i++) {
            if (oneRow[i] == false)
                return true;
        }
        return false;
    }


    /**
     * L�trehoz �s elind�t egy �j j�t�kot.
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
     * A k�vetkez� idomot(next) �thelyezi a p�ly�ra, be�ll�tja a t�mpontj�t
     * �s l�trehoz egy �j(next) idomot. Ek�zben figyeli, hogy v�ge van-e
     * a j�t�knak. Ha igen, akkor azt jelzi a f� ablaknak.
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
     * Lefel� tolja az idomot. Ha nem tolhat� lejjebb, akkor l�trehoz
     * egy �j idomot.
     */
    public void down() {
        if (!moving(0, 1)) {
            addBricks();
            examine();
            changeProfile();
        }
    }


    /**
     * Kiv�lasztja azokat a sorokat amelyek beteltek, t�rli azokat �s
     * �zenetet k�ld a f� ablaknak a t�rl�s eredm�ny�r�l.
     */
    private void examine() {
        numberOfClearedRows = 0;
        for (int i = 0; i < 4; i++) { // max n�gy sort lehet t�r�lni.
            for (int j = ROWS; j >= 0; j--) { // alulr�l felfel�
                int n = 0;
                for (int k = 0; k < fallenBricks.size(); k++) { // minden t�gla meg lesz viszg�lva
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
     * Ha a megadott sorban mindenhol t�gla tal�lhat�, akkor t�rli
     * az abban a sorban l�v� t�gl�kat.
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
     * A kit�r�lt sor feletti t�gl�kat eggyel lejjebb tolja.
     */
    private void pushDown(int row) {
        for (int i = 0; i < fallenBricks.size(); i++) {
            Brick brick = (Brick) fallenBricks.get(i);
            if (brick.y < row * UNIT)
                brick.translate(0, 1);
        }
    }


    /**
     * A leesett idom t�gl�it regisztr�lja mint leesett t�gl�t.
     */
    private void addBricks() {
        for (int i = 0; i < profile.getBricks().size(); i++)
            fallenBricks.add(profile.getBricks().get(i));
    }


    /**
     * l�trehoz egy �j idomot, amelyet a kijelz�n helyez el.
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
     * Visszaadja az aktu�lis idomot.
     */
    public Profile getprofile() {
        return profile;
    }


    /**
     * Visszaad egy v�letlensz�mot 0 �s max k�z�tt.
     */
    private int rnd(int max) {
        return (int) (Math.random() * max);
    }


    /**
     * Kirajzolja a p�ly�ra az idomot �s a lepotyogott t�gl�kat, valamint
     * a r�csot.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //v�zszintes vonalak
        g.setColor(Color.white);
        for (int i = 0; i < ROWS + 1; i++) {
            g.drawLine(0, i * UNIT, COLUMNS * UNIT, i * UNIT);
        }
        //f�gg�leges vonalak
        for (int i = 0; i < COLUMNS + 1; i++) {
            g.drawLine(i * UNIT, 0, i * UNIT, ROWS * UNIT);
        }
        //leesett tegl�k
        for (int i = 0; i < fallenBricks.size(); i++) {
            Brick brick = (Brick) fallenBricks.get(i);
            paintBrick(brick, g);
        }
        //ha nincs megkezdett j�t�k
        if (profile == null)
            return;
        //idom
        for (int i = 0; i < profile.getBricks().size(); i++) {
            Brick brick = (Brick) profile.getBricks().get(i);
            paintBrick(brick, g);
        }
    }


    /**
     * Megrajzol egy t�gl�t.
     */
    private void paintBrick(Brick brick, Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRoundRect(brick.x + 1, brick.y + 1, brick.width - 1,
                brick.height - 1, 5, 5);
    }
}