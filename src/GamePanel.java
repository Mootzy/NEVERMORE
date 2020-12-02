import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener {
    static final int PANEL_WIDTH = 1000;
    static final int PANEL_HEIGHT = 1000;

    static final int UNIT_SIZE = 35;
    static final int GAME_UNITS = (PANEL_WIDTH * PANEL_HEIGHT) / UNIT_SIZE;

    static final int DELAY = 100;

    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];

    boolean running = false;

    Random random;
    Timer timer;

    char direction = ' ';

    GamePanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
    }

    public void move(){


        switch (direction){

            case 'U':




        }

    }

    public void add(){

    }










public class MyKeyAdapter extends KeyAdapter{

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> direction = 'U';
            case KeyEvent.VK_DOWN -> direction = 'D';
            case KeyEvent.VK_RIGHT -> direction = 'R';
            case KeyEvent.VK_LEFT -> direction = 'L';
            default -> throw new IllegalStateException("Unexpected value: " + e.getKeyCode());

        }
    }

}




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
