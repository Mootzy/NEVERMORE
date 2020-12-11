import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @author Tyler Wallace
 */

@SuppressWarnings("unused")
public class GamePanel extends JPanel implements ActionListener, MouseListener {

    static final int PANEL_WIDTH = 1000;
    static final int PANEL_HEIGHT = 1000;
    static final int UNIT_SIZE = 35;
    static final int GAME_UNITS = (PANEL_WIDTH * PANEL_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 100;

    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];

    /**
     * used for mouselistener on rectangles
     */
    int[] rectOne = {50,350,200,650};
    int[] rectTwo = {550, 200, 300, 450};
    int[] rectThree = {1050, 200, 300, 450};

    boolean running = false;
    boolean selectedClass = false;
    boolean clickedWarrior = false;
    boolean clickedArcher = false;
    boolean clickedMage = false;

    Random random;
    Timer timer;

    char direction = ' ';

    BufferedImage warriorIcon;
    /*ImageIcon imageIcon = new ImageIcon("");
    JLabel label = new JLabel(imageIcon);*/

    //BufferedImage imageTest = returnImage("/Users/admin/Desktop/RPG/GameAssests/barbarian.png");

    //Graphics g = (Graphics) imageTest ;
    GamePanel() {

        super();
        //this.add(drawClickableImage(g,returnImage("/Users/admin/Desktop/RPG/GameAssests/barbarian.png"),50,200,300,450))

        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener(new MyKeyAdapter());
        this.addMouseListener(this);

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawWelcomeScreen(g);
    }

    public void move(){

        switch (direction){

            case 'U':
                break;
            case 'D':
                break;
            case 'R':
                break;
            case 'L':
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }

    }

    public void drawRectangle(Graphics rectangle, Color outlineColor, int xCoordinate, int yCoordinate, int width, int height){
        rectangle.setColor(outlineColor);
        rectangle.drawRect(xCoordinate,yCoordinate,width,height);

    }

    public void drawFloor(Graphics ground){
        ground.setColor(new Color(23,23,23));
        ground.fillRect(0,700,100000,200);

    }

    public void drawString(Graphics welcomeString,String welcomeStringText,int xCoordinate, int yCoordinate,int fontSize) {

        welcomeString.setColor(Color.white);
        welcomeString.setFont(new Font(null, Font.BOLD,fontSize));
        welcomeString.drawString(welcomeStringText,xCoordinate,yCoordinate);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
            //System.out.println("mouse clicked");

        /*
        int[] rectOne = {50,350,200,650};
        int[] rectTwo = {550, 200, 300, 450};
        */
        //drawRectangle(g, Color.white,50,200,300,450);

           if (e.getX() >= rectOne[0] && e.getX() <= rectOne[1] && e.getY() >= rectOne[2] && e.getY() <= rectOne[3]){
                System.out.println("mouse-clicked in region of warrior rectangle");
                this.repaint(rectOne[0],rectOne[1],rectOne[2],rectOne[3]);
                this.setVisible(false);
                this.getRootPane().getTopLevelAncestor().setVisible(false);
                new Level();
                clickedWarrior = !clickedWarrior;
                selectedClass = !selectedClass;
                System.out.println(clickedWarrior);

               if (clickedWarrior == true) {
                   this.invalidate();
                   new Level();
                   this.removeAll();
                   this.repaint();
               }
            }
    }
    //550, 200, 300, 450
    public void archerMouseClicked(MouseEvent e){
        if (e.getX() >= 550 && e.getX() <= 200 && e.getY() >= 300 && e.getY() <= 450){
            System.out.println("mouseclicked in region of archer rectangle");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
            System.out.println("holding mouse down");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
System.out.println("release mouse");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("mouse enter area of listener");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("mouse left area of listener");
    }

    public class MyKeyAdapter extends KeyAdapter{

    @Override
    public void keyPressed(KeyEvent e) throws IllegalStateException {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> direction = 'U';
            case KeyEvent.VK_DOWN -> direction = 'D';
            case KeyEvent.VK_RIGHT -> direction = 'R';
            case KeyEvent.VK_LEFT -> direction = 'L';
            default -> {
                throw new IllegalStateException("Unexpected value: " + e.getKeyCode());
            }
        }
    }
}

    public void drawStringSlowly(Graphics welcomeString) {
        String welcomeMessage = "Welcome to NeverMore, Traveler...";
        char[] welcomeChar = welcomeMessage.toCharArray();



        welcomeString.setColor(Color.white);
        welcomeString.setFont(new Font(null, Font.BOLD,50));

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

        //drawClickableImage(g,returnImage("/Users/admin/Desktop/RPG/GameAssests/barbarian.png"),50,200,300,450  );
        drawRectangle(g, Color.white,50,200,300,450);
        drawRectangle(g, Color.white, 550, 200, 300, 450);
        drawRectangle(g, Color.white, 1050, 200, 300, 450);
        drawImage(g,returnImage("/Users/admin/Desktop/RPG/GameAssests/barbarian.png"),50,250,300,350 );
        drawImage(g,returnImage("/Users/admin/Desktop/RPG/GameAssests/archer.png"),550,250,300,350 );
        drawImage(g,returnImage("/Users/admin/Desktop/RPG/GameAssests/pointy-hat.png"),1050,250,300,350 );

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

    public void drawImage(Graphics image, Image imageToDraw,int coordinateX, int coordinateY, int width, int height){
        //???? intellij recommended 'lambda' and made this all sorts of difficult to read..
        // the '-> false' is in relation to the "image observer" still unknown what this means
        image.drawImage(imageToDraw, coordinateX, coordinateY, width, height, (img, infoflags, x, y, width1, height1) -> false);

    }

    public void drawClickableImage(Graphics image, Image imageToDraw,int coordinateX, int coordinateY, int width, int height){
        JButton imageButton = new JButton();
        imageButton.setIcon((Icon) imageToDraw);

    }

    public void drawWelcomeScreen(Graphics g){
        String welcomeText = "Welcome to Nevermore, Traveler...";
        String whatWillBeYourFate = " What Will Be Your Fate...?";

        drawFloor(g);
        drawString(g, welcomeText, 325, 100,50);
        drawClassRectangles(g);
        drawString(g, whatWillBeYourFate, 555, 135,20 );

    }

    public BufferedImage returnImage(String imagePath){


        BufferedImage image = null;


        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }


        BufferedImage warriorIcon = new BufferedImage(200,200,BufferedImage.TYPE_USHORT_565_RGB);
        Graphics g = warriorIcon.getGraphics();

        return image;
    }

    public void drawButton(String buttonName, int coordinateX, int coordinateY, int width, int height){
      //JButton buttonName = new JButton();

    }

    public void clickableImage(){
        JButton clickableImage = new JButton();


    }

    public Boolean getSelectedClass(){
        System.out.println(selectedClass);
        return selectedClass;
    }

}