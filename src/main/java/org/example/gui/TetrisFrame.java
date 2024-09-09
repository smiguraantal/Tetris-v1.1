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

import org.example.log.Data;
import org.example.log.Recorder;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.Container;
import java.awt.Event;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.util.Locale;


/**
 * Az alkalmazás fő ablaka
 */
public class TetrisFrame extends JFrame implements Data {


    /**
     * A következő idomot mutató kijelző.
     */
    private Display display = new Display();


    /**
     * A pálya amelyen lepotyognak az idomok.
     */
    private GameArea gameArea = new GameArea(this, display);


    /**
     * Egy vékony sáv amely elválasztja a pályát a kijelzőtől.
     */
    private Separator separator =
            new Separator(3, gameArea.ROWS * gameArea.UNIT + 1);


    /**
     * A PAUSE címke.
     */
    private MonospacedLabel lbPause =
            new MonospacedLabel("PAUSE", MonospacedLabel.CENTER, 15);


    /**
     * A törölt sorok számát megjelenítő címke.
     */
    private MonospacedLabel lbNumberOfLines =
            new MonospacedLabel("0", MonospacedLabel.RIGHT, 18);


    /**
     * A pontok számát megjelenítő címke.
     */
    private MonospacedLabel lbNumberOfPoints =
            new MonospacedLabel("0", MonospacedLabel.RIGHT, 18);


    /**
     * A játék típusát megjelenítő címke.
     */
    private MonospacedLabel lbValueOfMode =
            new MonospacedLabel("A", MonospacedLabel.CENTER, 15);


    /**
     * A sebességet megjelenítő címke.
     */
    private MonospacedLabel lbValueOfSpeed =
            new MonospacedLabel("0", MonospacedLabel.CENTER, 15);


    /**
     * A szintet megjelenítő cimke.
     */
    private MonospacedLabel lbValueOfLevel =
            new MonospacedLabel("0", MonospacedLabel.CENTER, 15);


    /**
     * A forgatás irányát jelző cimke.
     */
    private JLabel lbSwing = new JLabel(SWING_LEFT);


    /**
     * A kávét megjelenítő cimke.
     */
    private JLabel lbCoffee = new JLabel(COFFEE);


    /**
     * A játék állapota.
     */
    private int state = STOP;


    /**
     * A játék típusa;
     */
    private String mode = MODE_A;


    /**
     * A gyűjtött pontok.
     */
    private int points;


    /**
     * A törölt sorok.
     */
    private int lines;


    /**
     * Az idomok potyogásának sebessége.
     */
    private int speed;


    /**
     * A téglákból előre felépített foghíjas sorok száma.
     */
    private int level;


    /**
     * A forgatás iránya. Kezdetben balra.
     */
    private boolean turn = true;


    /**
     * A csúcstartó.
     */
    private Recorder recorder;


    /**
     * Dialógus új rekord esetére.
     */
    private NewRecordDialog newRecordDialog = new NewRecordDialog(this);


    /**
     * Segítség a használathoz dialógus.
     */
    private HowToUseDialog howToUseDialog = new HowToUseDialog(this);


    /**
     * Névjegy dialógus.
     */
    private AboutDialog aboutDialog = new AboutDialog(this);


    /**
     * A legjobb eredményeket megjelenítő dialógus.
     */
    private BestResultDialog bestResultDialog = new BestResultDialog(this);

    /**
     * Konstruktor.
     */
    public TetrisFrame() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setTitle("Tetris 1.1");

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        JMenu mGame = new JMenu("Game");
        mGame.setMnemonic(KeyEvent.VK_G);
        JMenu mHelp = new JMenu("Help");
        mHelp.setMnemonic(KeyEvent.VK_H);
        mb.add(mGame);
        mb.add(mHelp);

        JMenuItem miNewGame = new JMenuItem("New game/Clear game", 'N');
        miNewGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK));
        JMenuItem miRecord = new JMenuItem("Best result", 'B');
        miRecord.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, Event.CTRL_MASK));
        JMenuItem miExit = new JMenuItem("Exit");
        miExit.setAccelerator(KeyStroke.getKeyStroke("ESCAPE"));
        //miUse.setAccelerator(KeyStroke.getKeyStroke("F1"));
        mGame.add(miNewGame);
        mGame.add(miRecord);
        mGame.add(miExit);

        JMenuItem miHowToUse = new JMenuItem("How to use?", 'H');
        miHowToUse.setAccelerator(KeyStroke.getKeyStroke("F1"));
        JMenuItem miAbout = new JMenuItem("About", 'A');
        miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
        mHelp.add(miHowToUse);
        mHelp.add(miAbout);

        miNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                play_stop();
            }
        });

        miRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showBestResultDialog();
            }
        });

        miExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showExitDialog();
            }
        });

        miHowToUse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                howToUseDialog.showDialog();
            }
        });

        miAbout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aboutDialog.showDialog();
            }
        });

        Container contentPane = getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        contentPane.setLayout(gridbag);
        c.fill = GridBagConstraints.HORIZONTAL;

        //lbLines
        MonospacedLabel lbLines = new MonospacedLabel("LINES", 15);
        c.gridx = 0;
        c.gridy = 0;
        gridbag.setConstraints(lbLines, c);
        contentPane.add(lbLines);

        //lbScore
        MonospacedLabel lbScore = new MonospacedLabel("SCORE", 15);
        c.gridx = 0;
        c.gridy = 1;
        gridbag.setConstraints(lbScore, c);
        contentPane.add(lbScore);

        //lbNumberOfLines
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 3;
        gridbag.setConstraints(lbNumberOfLines, c);
        contentPane.add(lbNumberOfLines);

        //lbNumberOfPoints
        c.gridx = 1;
        c.gridy = 1;
        gridbag.setConstraints(lbNumberOfPoints, c);
        contentPane.add(lbNumberOfPoints);

        //gameArea
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.gridheight = 11;
        gridbag.setConstraints(gameArea, c);
        contentPane.add(gameArea);

        //separator
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        gridbag.setConstraints(separator, c);
        contentPane.add(separator);

        //display
        c.gridx = 3;
        c.gridy = 2;
        c.gridheight = 1;
        gridbag.setConstraints(display, c);
        contentPane.add(display);

        //lbMode
        MonospacedLabel lbMode =
                new MonospacedLabel("MODE", MonospacedLabel.CENTER, 15);
        c.gridx = 3;
        c.gridy = 3;
        gridbag.setConstraints(lbMode, c);
        contentPane.add(lbMode);

        //lbValueOfMode
        c.gridx = 3;
        c.gridy = 4;
        gridbag.setConstraints(lbValueOfMode, c);
        contentPane.add(lbValueOfMode);


        //lbSpeed
        MonospacedLabel lbSpeed =
                new MonospacedLabel("SPEED", MonospacedLabel.CENTER, 15);
        c.gridx = 3;
        c.gridy = 5;
        gridbag.setConstraints(lbSpeed, c);
        contentPane.add(lbSpeed);

        //lbValueOfSpeed
        c.gridx = 3;
        c.gridy = 6;
        gridbag.setConstraints(lbValueOfSpeed, c);
        contentPane.add(lbValueOfSpeed);

        //lbLevel
        MonospacedLabel lbLevel =
                new MonospacedLabel("LEVEL", MonospacedLabel.CENTER, 15);
        c.gridx = 3;
        c.gridy = 7;
        gridbag.setConstraints(lbLevel, c);
        contentPane.add(lbLevel);

        //lbValueOfLevel
        c.gridx = 3;
        c.gridy = 8;
        gridbag.setConstraints(lbValueOfLevel, c);
        contentPane.add(lbValueOfLevel);

        //lbRotate
        MonospacedLabel lbRotate =
                new MonospacedLabel("ROTATE", MonospacedLabel.CENTER, 15);
        c.gridx = 3;
        c.gridy = 9;
        gridbag.setConstraints(lbRotate, c);
        contentPane.add(lbRotate);

        //lbSwing
        c.gridx = 3;
        c.gridy = 10;
        c.fill = GridBagConstraints.CENTER;
        gridbag.setConstraints(lbSwing, c);
        contentPane.add(lbSwing);

        //lbPause
        c.gridx = 3;
        c.gridy = 11;
        gridbag.setConstraints(lbPause, c);
        contentPane.add(lbPause);
        lbPause.setEnabled(false);

        //lbCoffee
        c.gridx = 3;
        c.gridy = 12;
        gridbag.setConstraints(lbCoffee, c);
        contentPane.add(lbCoffee);
        lbCoffee.setEnabled(false);
        lbValueOfMode.setText("\'" + mode + "\'");

        windowListening();
        keyListening();
        readRecorder();

        pack();
        WindowLocation.center(this);
        show();
    }


    /**
     * Létrehozza a billentyű figyelőt.
     */
    private void keyListening() {
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                    right();
                if (e.getKeyCode() == KeyEvent.VK_LEFT)
                    left();
                if (e.getKeyCode() == KeyEvent.VK_DOWN)
                    down();
                if (e.getKeyCode() == KeyEvent.VK_SPACE)
                    turn();
                if (e.getKeyCode() == KeyEvent.VK_F2)
                    play_stop();
                if (e.getKeyCode() == KeyEvent.VK_F3)
                    pause();
            }
        });
    }


    /**
     * Létrehozza az ablakbecsukás figyelőt.
     */
    private void windowListening() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                showExitDialog();
            }
        });
    }


    /**
     * Beolvassa fájlból a rekordert.
     */
    private void readRecorder() {
        try {
            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream("recorder.dat"));
            Recorder recorder = (Recorder) in.readObject();
            this.recorder = recorder;
            in.close();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            recorder = new Recorder("???", 0, 0);
            System.out.println(e.getMessage());
        }
    }


    /**
     * Kiírja fájlba a rekordert.
     */
    private void writeRecorder() {
        try {
            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream("recorder.dat"));
            out.writeObject(recorder);
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Frissíti az eredményeket.
     */
    public void setValues(int numberOfClearedRows) {
        int previousPoints = points;
        points += calculatePoints(numberOfClearedRows);
        lines += numberOfClearedRows;
        lbNumberOfPoints.setText(format(points));
        calculateSpeed(previousPoints);
        gameArea.setDelay(speed);
        lbValueOfSpeed.setText("" + speed);
        lbNumberOfLines.setText(format(lines));
    }


    /**
     * Stringként adja vissza a megformázott számot.
     */
    private String format(int number) {
        Locale locale = Locale.US;
        NumberFormat nf = NumberFormat.getNumberInstance(locale);
        return nf.format(number);
    }


    /**
     * A A ponszámokból kiszámítja a sebességet.
     */
    private void calculateSpeed(int previousPoints) {
        int previous = (int) (previousPoints / 50000.0);
        int now = (int) (points / 50000.0);
        int increment = now - previous;
        int newSpeed = speed + increment;
        speed = newSpeed < 9 ? newSpeed : 9;
    }


    /**
     * Kiszámolja, hogy a törölt sorokért hány pont jár.
     */
    private int calculatePoints(int numberOfClearedRows) {
        int givenPoints = 0;
        switch (numberOfClearedRows) {
            case 1:
                givenPoints = 1000;
                break;
            case 2:
                givenPoints = 3000;
                break;
            case 3:
                givenPoints = 7000;
                break;
            case 4:
                givenPoints = 15000;
                break;
        }
        return givenPoints;
    }


    /**
     * Lépteti és megjeleníti az aktuális sebességet.
     */
    private void changeSpeed() {
        if (++speed > 9)
            speed = 0;
        lbValueOfSpeed.setText("" + speed);
    }


    /**
     * Lépteti és megjeleníti az aktuális szintet.
     */
    private void changeLevel() {
        if (++level > 12)
            level = 0;
        lbValueOfLevel.setText("" + level);
    }


    /**
     * A forgatás irányát az ellenkezőjére állítja.
     */
    private void changeTurn() {
        turn = !turn;
    }


    /**
     * Megváltoztatja a játék típusát.
     */
    private void changeMode() {
        mode = mode == MODE_A ? MODE_B : MODE_A;
        lbValueOfMode.setText("\'" + mode + "\'");
    }


    /**
     * Lekezeli a jobbra gomb lenyomását.
     */
    private void right() {
        if (state == PLAY)
            gameArea.right();
        if (state == STOP)
            changeSpeed();
    }


    /**
     * Lekezeli a balra gomb lenyomását.
     */
    public void left() {
        if (state == PLAY)
            gameArea.left();
        if (state == STOP)
            changeLevel();
    }


    /**
     * Lekezeli a le gomb lenyomását.
     */
    public void down() {
        if (state == PLAY)
            gameArea.down();
        if (state == STOP) {
            changeMode();
        }
    }


    /**
     * Lekezeli a forgató gomb lenyomását.
     */
    public void turn() {
        if (state == PLAY)
            gameArea.turn(turn);
        if (state == STOP) {
            changeTurn();
            lbSwing.setIcon(turn ? SWING_LEFT : SWING_RIGHT);
        }
    }


    /**
     * Végetvet a játéknak, illetve elindítja azt.
     */
    public void play_stop() {
        if (state != STOP) {
            gameArea.stop();
            lbNumberOfLines.setText(format(lines = 0));
            lbNumberOfPoints.setText(format(points = 0));
            lbPause.setEnabled(false);
            lbCoffee.setEnabled(false);
            setState(STOP);
        } else if (state == STOP) {
            gameArea.newGame(level, speed);
            setState(PLAY);
        }
    }


    /**
     * Felfüggeszti vagy folytatja a játékot.
     */
    public void pause() {
        if (state == PAUSE) {
            gameArea.play();
            lbPause.setEnabled(false);
            lbCoffee.setEnabled(false);
            setState(PLAY);
        } else if (state == PLAY) {
            gameArea.pause();
            lbPause.setEnabled(true);
            lbCoffee.setEnabled(true);
            setState(PAUSE);
        }
    }


    /**
     * Beállítja az állapotot a kapott állapotra.
     */
    public void setState(int state) {
        this.state = state;
    }


    /**
     * Megvizsgálja, hogy született-e új rekord. Ha igen, és a játékos
     * is úgy akarja, akkor el lesz tárolva a neve és az eredménye.
     */
    public void recordExamination() {
        if (points > recorder.getPoints())
            newRecordDialog.showDialog();
    }


    /**
     * Eltárolja a megadott nevű játékos nevét, pontját és a sorok számát.
     */
    public void newRecord(String name) {
        recorder = new Recorder(name, lines, points);
        writeRecorder();
    }


    /**
     * Visszaadja a játék típusát.
     */
    public String getMode() {
        return mode;
    }


    /**
     * A program befejezése.
     */
    private void showExitDialog() {
        if (JOptionPane.showConfirmDialog(
                this, "Are you sure to exit?",
                "Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }


    /**
     * Megjeleníti a legjobb eredményt mutató dialógust.
     */
    public void showBestResultDialog() {
        bestResultDialog.showDialog(recorder.getName(),
                recorder.getLines(), recorder.getPoints());
    }


    /**
     * Megjelenít egy szövegbeviteli ablakot.
     */
    public String showInputDialog(String message) {
        return JOptionPane.showInputDialog(
                this, message, "", JOptionPane.QUESTION_MESSAGE);
    }
}