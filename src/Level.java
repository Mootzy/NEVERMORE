import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Level extends JPanel implements ActionListener {

    static final int PANEL_WIDTH = 1000;
    static final int PANEL_HEIGHT = 1000;
    static final int UNIT_SIZE = 35;
    static final int GAME_UNITS = (PANEL_WIDTH * PANEL_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 100;

    boolean paused = false;
    char direction = ' ';
    JFrame frame;

    Level(){
        super();
        frame = new JFrame();

        setLevelConstants();
        setFrameConstants();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void setLevelConstants(){

    this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    this.setBackground(Color.RED);
    this.setFocusable(true);
    this.requestFocus();
    this.addKeyListener(new MyKeyAdapter());

}

    public void setFrameConstants(){
    frame.add(this);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setTitle("Tales of Nevermore");
    frame.pack();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.addKeyListener(new MyKeyAdapter());
}

    public void pauseGame(){

}

    public void resumeGame(){

}
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){

                case KeyEvent.VK_LEFT  :

                    direction = 'L';
                    break;

                //prevent 180
                case KeyEvent.VK_RIGHT:

                    direction = 'R';
                    break;

                case KeyEvent.VK_UP:

                    direction = 'U';
                    break;

                case KeyEvent.VK_DOWN:

                    direction = 'D';
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + e.getKeyCode());
            }
            //duplicate to allow player to used WASD as opposed to arrows
            switch (e.getKeyChar()) {

                case 'a':
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;

                case 'd':
                    if (direction != 'L') {

                        direction = 'R';
                    }
                    break;

                case 'w':
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;

                case 's':

                    direction = 'D';
                    break;
                case ' ':
                    paused = !paused;
                    System.out.println(paused);
                    System.out.println("paused");
                    if (paused) {
                        pauseGame();
                    }
                    if (!paused){
                        resumeGame();
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + e.getKeyChar());
            }
        }
    }
}
