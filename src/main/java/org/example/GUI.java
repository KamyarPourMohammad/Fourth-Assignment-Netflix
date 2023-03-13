package org.example;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
//
public class GUI implements ActionListener {

    private static JLabel userLabel;
    private static JTextField  userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;

    public static void startMenu(){

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80,25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(10, 100, 80, 25);
        button.addActionListener( new GUI());
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10, 120, 300, 25);
        panel.add(success);

        frame.setVisible(true);
    }
//----------------------------------------------------------------------------------------------------------------------
    @Override
    public void actionPerformed (ActionEvent e){ // this code gets run whenever button clicked
        String user = userText.getText();
        String password = passwordText.getText();

        if (user.equals("Shayan") && password.equals("1234")){ // check for correct user
            success.setText("Login successful.");
            JFrame frame = new JFrame();
            frame.dispose();
            NewWindow myWindow = new NewWindow();
        }
        else {
            success.setText("Login failed!");
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    public void test(){



    }

}
