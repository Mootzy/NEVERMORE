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

    final String welcomeText = "Welcome to Nevermore, Traveler...";
    Random random;
    Timer timer;

    char direction = ' ';

    GamePanel(){
        super();
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new MyKeyAdapter());
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawFloor(g);
        drawString(g, welcomeText);
        /*drawRectangle(g, Color.white,50,200,300,450);
        drawRectangle(g, Color.white, 150, 200, 300, 450);
        drawRectangle(g, Color.white, 250, 200, 300, 450);
        */
        drawClassRectangles(g);
    }

    public void move(){


        switch (direction){

            case 'U':




        }

    }

    public void drawRectangle(Graphics rectangle,Color outlineColor, int xCoordinate, int yCoordinate, int width, int height){
        rectangle.setColor(outlineColor);
        rectangle.drawRect(xCoordinate,yCoordinate,width,height);
    }

    public void drawFloor(Graphics ground){
        ground.setColor(new Color(23,23,23));
        ground.fillRect(0,700,100000,200);

    }

    public void drawString(Graphics welcomeString,String welcomeStringText) {

        welcomeString.setColor(Color.white);
        welcomeString.setFont(new Font(null, Font.BOLD,50));
        welcomeString.drawString(welcomeStringText,225,100);

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

    public void drawStringSlowly(Graphics welcomeString) throws InterruptedException {
        String welcomeMessage = "Welcome to NeverMore, Traveler...";
        char[] welcomeChar = welcomeMessage.toCharArray();



        welcomeString.setColor(Color.white);
        welcomeString.setFont(new Font(null, Font.BOLD,50));
        //welcomeString.drawString("Welcome to NeverMore, Traveler...",225,100);

        int x = 225, y = 100;


        for (int i = 0 ; i < welcomeChar.length; i ++){
            if (i == 0){
                welcomeString.drawString(String.valueOf(welcomeChar[i]), x  , y);
            }
            welcomeString.drawString(String.valueOf(welcomeChar[i]), x + (i * 20), y);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void drawClassRectangles(Graphics g){

        drawRectangle(g, Color.white,50,200,300,450);
        drawRectangle(g, Color.white, 550, 200, 300, 450);
        drawRectangle(g, Color.white, 1050, 200, 300, 450);



    }

    public void drawCleric(){

    }
    public void drawArcher(){

    }
    public void drawWarrior(){

    }
    public void randomSpawn(){

    }
    public void drawEnemy(){

    }
    public void gravity(){

    }




}