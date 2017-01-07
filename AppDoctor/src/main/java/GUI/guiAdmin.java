package GUI;

/**
 * Created by Alexandra R on 1/7/2017.
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class guiAdmin {

    public JFrame adminFrame;
    private JPanel contentPane;
    private JButton btnUpdateEmployeeInformation;
    private JButton btnNewButton;
    private JButton btnDeleteEmployee;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField cnpField;
    private JTextField positionField;

    public guiAdmin() {
        adminFrame.setTitle("Admin page");
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setBounds(100, 100, 681, 353);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        adminFrame.setContentPane(contentPane);
        contentPane.setLayout(null);

        btnNewButton = new JButton("Add new employee");
        btnNewButton.setBounds(466, 48, 137, 45);
        contentPane.add(btnNewButton);

        btnUpdateEmployeeInformation = new JButton("Update employee info");
        btnUpdateEmployeeInformation.setBounds(466, 104, 137, 45);
        contentPane.add(btnUpdateEmployeeInformation);

        btnDeleteEmployee = new JButton("Delete employee");
        btnDeleteEmployee.setBounds(466, 160, 137, 45);
        contentPane.add(btnDeleteEmployee);

        firstNameField = new JTextField();
        firstNameField.setBounds(185, 60, 171, 20);
        contentPane.add(firstNameField);
        firstNameField.setColumns(10);

        JLabel lblFirstName = new JLabel("First name:");
        lblFirstName.setBounds(100, 60, 77, 20);
        contentPane.add(lblFirstName);

        JLabel lblLastName = new JLabel("Last name:");
        lblLastName.setBounds(100, 100, 77, 20);
        contentPane.add(lblLastName);

        JLabel lblCnp = new JLabel("CNP:");
        lblCnp.setBounds(100, 141, 77, 20);
        contentPane.add(lblCnp);

        JLabel lblPosition = new JLabel("Position:");
        lblPosition.setBounds(100, 180, 77, 20);
        contentPane.add(lblPosition);

        lastNameField = new JTextField();
        lastNameField.setColumns(10);
        lastNameField.setBounds(185, 100, 171, 20);
        contentPane.add(lastNameField);

        cnpField = new JTextField();
        cnpField.setColumns(10);
        cnpField.setBounds(185, 141, 171, 20);
        contentPane.add(cnpField);

        positionField = new JTextField();
        positionField.setColumns(10);
        positionField.setBounds(185, 180, 171, 20);
        contentPane.add(positionField);

        adminFrame.setVisible(true);
    }
}
