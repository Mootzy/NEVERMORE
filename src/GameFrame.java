import javax.swing.*;

public class GameFrame extends JFrame {

    int[] rectOne = {50,350,200,650};
    GamePanel mainMenu;
    Level level;

    GameFrame(){

        this.add(mainMenu = new GamePanel());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Tales of Nevermore");
        this.pack();
    }

}
