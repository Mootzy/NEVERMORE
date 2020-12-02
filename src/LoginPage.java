import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class LoginPage implements ActionListener, KeyListener {

  JFrame loginFrame = new JFrame();
  JButton loginButton = new JButton("login");
  JButton storeButton = new JButton("store");

  JLabel loginBanner = new JLabel(" NEVERMORE ");

  JTextField unField = new JTextField();
  JPasswordField pwField = new JPasswordField();

  JLabel unLabel = new JLabel("Username");
  JLabel pwLabel = new JLabel("Password");

  ImageIcon neverMoverIcon = new ImageIcon("/Users/admin/Desktop/RPG/src/knight-and-squire-wallpaper-preview.jpg");
  JLabel imageLabel = new JLabel(neverMoverIcon);

  HashMap<String, String> loginInfo = new HashMap<String, String>();

  LoginPage(HashMap<String, String> loginInfoOriginal) {


    imageLabel.setBounds(480, 150, 500, 300);
    loginInfo = loginInfoOriginal;
    imageLabel.setVisible(true);

    loginBanner.setBounds(405, 50, 1000, 65);
    loginBanner.setForeground(Color.white);
    loginBanner.setFont(new Font(null, Font.TRUETYPE_FONT, 100));

    unLabel.setBounds(705, 575, 150, 25);
    pwLabel.setBounds(705, 625, 150, 25);
    unLabel.setForeground(Color.white);
    pwLabel.setForeground(Color.white);

    // Create text box area for password and UN input
    unField.setBounds(480, 600, 500, 25);
    pwField.setBounds(480, 650, 500, 25);

    // Create and design Login Button
    loginButton.setBounds(605, 800, 250, 25);
    loginButton.setFocusable(false);
    loginButton.addActionListener(this);
    loginButton.setForeground(Color.white);

    // code to set Default focus of Root Pane to loginButton so user can just press the enter key to
    // submit form
    loginFrame.getRootPane().setDefaultButton(loginButton);
    loginButton.requestFocus();

    loginFrame.getContentPane().setBackground(Color.black);
    loginFrame.setBackground(Color.red);
    loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    loginFrame.setLocationRelativeTo(null);
    loginFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
    loginFrame.setLayout(null);
    loginFrame.setVisible(true);
    loginFrame.add(imageLabel);
    loginFrame.add(loginBanner);
    loginFrame.add(unLabel);
    loginFrame.add(pwLabel);
    loginFrame.add(unField);
    loginFrame.add(pwField);
    loginFrame.add(loginButton);
    loginFrame.setTitle("Login");
    loginFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("skull.jpg"));
    loginFrame.setLocationRelativeTo(null);
  }


  public void doTheStuff(HashMap<String, String> loginInfoOriginal){
    imageLabel.setBounds(480, 150, 500, 300);
    loginInfo = loginInfoOriginal;
    imageLabel.setVisible(true);

    loginBanner.setBounds(405, 50, 1000, 65);
    loginBanner.setForeground(Color.white);
    loginBanner.setFont(new Font(null, Font.TRUETYPE_FONT, 100));

    unLabel.setBounds(705, 575, 150, 25);
    pwLabel.setBounds(705, 625, 150, 25);
    unLabel.setForeground(Color.white);
    pwLabel.setForeground(Color.white);

    // Create text box area for password and UN input
    unField.setBounds(480, 600, 500, 25);
    pwField.setBounds(480, 650, 500, 25);

    // Create and design Login Button
    loginButton.setBounds(605, 800, 250, 25);
    loginButton.setFocusable(false);
    loginButton.addActionListener(this);
    loginButton.setForeground(Color.white);

    // code to set Default focus of Root Pane to loginButton so user can just press the enter key to
    // submit form
    loginFrame.getRootPane().setDefaultButton(loginButton);
    loginButton.requestFocus();

    loginFrame.getContentPane().setBackground(Color.black);
    loginFrame.setBackground(Color.red);
    loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    loginFrame.setLocationRelativeTo(null);
    loginFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
    loginFrame.setLayout(null);
    loginFrame.setVisible(true);
    loginFrame.add(imageLabel);
    loginFrame.add(loginBanner);
    loginFrame.add(unLabel);
    loginFrame.add(pwLabel);
    loginFrame.add(unField);
    loginFrame.add(pwField);
    loginFrame.add(loginButton);
    loginFrame.setTitle("Login");
    loginFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("skull.jpg"));
    loginFrame.setLocationRelativeTo(null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == loginButton) {
      String userID = unField.getText();
      String password = String.valueOf(pwField.getPassword());

      if (loginInfo.containsKey(userID)) {
        if (loginInfo.get(userID).equals(password)) {
          loginFrame.dispose();
          new GameFrame();
        }
      }
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {}

  @Override
  public void keyPressed(KeyEvent e) {}

  @Override
  public void keyReleased(KeyEvent e) {}
}
