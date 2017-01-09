package GUI;

/**
 * Created by Alexandra R on 1/7/2017.
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class guiAdmin {

    public JFrame adminFrame;
    private JPanel contentPane;
    public JButton btnUpdateEmployeeInformation;
    public JButton btnNewEmployee;
    public JButton btnDeleteEmployee;
    public JTextField firstNameField;
    public JTextField lastNameField;
    public JTextField cnpField;
    public JTextField positionField;
    public JTextField adressField;
    public JTextField usernameField;
    public JTextField psswField;

    public guiAdmin() {

        adminFrame = new JFrame();

        adminFrame.setTitle("Admin page");
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setBounds(100, 100, 681, 353);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        adminFrame.setContentPane(contentPane);
        contentPane.setLayout(null);

        btnNewEmployee = new JButton("Add new employee");
        btnNewEmployee.setBounds(52, 216, 137, 45);
        contentPane.add(btnNewEmployee);

        btnUpdateEmployeeInformation = new JButton("Update employee");
        btnUpdateEmployeeInformation.setBounds(264, 216, 137, 45);
        contentPane.add(btnUpdateEmployeeInformation);

        btnDeleteEmployee = new JButton("Delete employee");
        btnDeleteEmployee.setBounds(471, 216, 137, 45);
        contentPane.add(btnDeleteEmployee);

        firstNameField = new JTextField();
        firstNameField.setBounds(116, 48, 171, 20);
        contentPane.add(firstNameField);
        firstNameField.setColumns(10);

        JLabel lblFirstName = new JLabel("First name:");
        lblFirstName.setBounds(29, 48, 77, 20);
        contentPane.add(lblFirstName);

        JLabel lblLastName = new JLabel("Last name:");
        lblLastName.setBounds(29, 85, 77, 20);
        contentPane.add(lblLastName);

        JLabel lblCnp = new JLabel("CNP:");
        lblCnp.setBounds(29, 116, 77, 20);
        contentPane.add(lblCnp);

        JLabel lblPosition = new JLabel("Position:");
        lblPosition.setBounds(29, 152, 77, 20);
        contentPane.add(lblPosition);

        lastNameField = new JTextField();
        lastNameField.setColumns(10);
        lastNameField.setBounds(116, 85, 171, 20);
        contentPane.add(lastNameField);

        cnpField = new JTextField();
        cnpField.setColumns(10);
        cnpField.setBounds(116, 116, 171, 20);
        contentPane.add(cnpField);

        positionField = new JTextField();
        positionField.setColumns(10);
        positionField.setBounds(116, 152, 171, 20);
        contentPane.add(positionField);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(359, 48, 77, 20);
        contentPane.add(lblAddress);

        adressField = new JTextField();
        adressField.setColumns(10);
        adressField.setBounds(432, 48, 171, 20);
        contentPane.add(adressField);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(359, 88, 87, 14);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(359, 119, 87, 14);
        contentPane.add(lblPassword);

        usernameField = new JTextField();
        usernameField.setColumns(10);
        usernameField.setBounds(432, 85, 171, 20);
        contentPane.add(usernameField);

        psswField = new JTextField();
        psswField.setColumns(10);
        psswField.setBounds(432, 116, 171, 20);
        contentPane.add(psswField);

        adminFrame.setVisible(true);
    }
}
