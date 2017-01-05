package GUI;/**
 * Created by Alexandra R on 11/4/2016.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;

public class guiLog {

    private JFrame frmApplicationForFamily;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField textField;
    private JButton btnLogin;
    private JButton btnNewUser;

    /**
     * Create the application.
     */

    public guiLog() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmApplicationForFamily = new JFrame();
        frmApplicationForFamily.setTitle("Application for family doctors");
        frmApplicationForFamily.setBounds(100, 100, 450, 300);
        frmApplicationForFamily.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmApplicationForFamily.getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(77, 83, 84, 38);
        frmApplicationForFamily.getContentPane().add(lblUsername);

        JLabel lblNewLabel = new JLabel("Password:");
        lblNewLabel.setBounds(77, 123, 84, 23);
        frmApplicationForFamily.getContentPane().add(lblNewLabel);

        usernameField = new JTextField();
        usernameField.setBounds(176, 92, 152, 20);
        frmApplicationForFamily.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(176, 124, 152, 20);
        frmApplicationForFamily.getContentPane().add(passwordField);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(64, 193, 89, 38);
        frmApplicationForFamily.getContentPane().add(btnLogin);

        JLabel lblCnp = new JLabel("CNP:");
        lblCnp.setBounds(77, 58, 46, 14);
        frmApplicationForFamily.getContentPane().add(lblCnp);

        textField = new JTextField();
        textField.setBounds(176, 61, 152, 20);
        frmApplicationForFamily.getContentPane().add(textField);
        textField.setColumns(10);

        btnNewUser = new JButton("New user");
        btnNewUser.setBounds(211, 193, 89, 38);
        frmApplicationForFamily.getContentPane().add(btnNewUser);

        frmApplicationForFamily.setVisible(true);
    }
}
