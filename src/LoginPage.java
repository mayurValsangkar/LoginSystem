import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    // Initializing frame, button, Text filed and label
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField  userIDField = new JFormattedTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIdLabel = new JLabel("userId:");
    JLabel userPasswordLabel = new JLabel("password");
    JLabel messageLabel = new JLabel();


    // Global hashmap
    HashMap<String, String> loginInfo = new HashMap<>();

    // Parameterized Constructor
    LoginPage(HashMap<String, String> loginInfoOriginal) {

        loginInfo = loginInfoOriginal;

        // Setting dimension
        userIdLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        // Adding all the tabs in frame
        frame.add(userIdLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);

        // This will close when we exit out of it.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Setting dimension of frame
        frame.setSize(420, 420);
        frame.setLayout(null);
        // Making frame visible
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==resetButton) {

            // Setting userId and password field empty
            userIDField.setText("");
            userPasswordField.setText("");
        }

        if(e.getSource()==loginButton) {

            String userId = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            // If user id and password field are empty
            if(userId.isEmpty() && password.isEmpty()) {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Please enter login info");
            } else if (userId.isEmpty()) {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("userId is empty");
            } else if (password.isEmpty()) {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("password is empty");
            }
            else {
                // Check if hash map contain login id
                if(loginInfo.containsKey(userId)) {
                    // Check if user id and its password match or not
                    if(loginInfo.get(userId).equals(password)) {
                        messageLabel.setForeground(Color.green);
                        messageLabel.setText("Login successful");
                        frame.dispose();
                        WelcomePage welcomePage  = new WelcomePage(userId);
                    }else{
                        messageLabel.setForeground(Color.red);
                        messageLabel.setText("Wrong password");
                    }
                }
                else {
                    messageLabel.setForeground(Color.black);
                    messageLabel.setText("Username not found");
                }
            }


        }

    }
}
