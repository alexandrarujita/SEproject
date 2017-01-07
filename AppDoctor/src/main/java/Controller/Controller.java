package Controller;

import GUI.guiAdmin;
import GUI.guiLog;
import GUI.guiMainPage;
import Person.Doctor;
import Person.Nurse;
import Person.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alexandra R on 11/18/2016.
 */
public class Controller {

    private guiLog loginPage;
    private guiMainPage mainPage;
    private guiAdmin adminPage;
    private Doctor doctorLogin;
    private Nurse nurseLogin;
    private employeeService employeeAccess;



    public Controller() {
        loginPage = new guiLog();
        loginPage.cnpField.setVisible(false);
        loginPage.lblCnp.setVisible(false);

        employeeAccess = new employeeService();
        loginActions();

    }

    private void loginActions() {
        loginPage.btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = loginPage.usernameField.getText();
                char[] passw = loginPage.passwordField.getPassword();

                if (username.equals("admin")) {
                    adminPage = new guiAdmin();
                    adminActions();
                } else {
                    Employee loginEmployee = employeeAccess.getEmployeeInfo();

                    if (loginEmployee.getUserName().equals("nou") ) { //aici inca nu stiu sigur cum sa facem altfel
                        JOptionPane.showMessageDialog(null, "Username does not yet exist, please click NEW USER  ", "OK", JOptionPane.OK_OPTION);
                        loginPage.cnpField.setVisible(true);
                        loginPage.lblCnp.setVisible(true);
                    } else {
                        if (!loginEmployee.getPassword().equals(passw)) {
                            JOptionPane.showMessageDialog(null, "Incorrect password! ", "OK", JOptionPane.OK_OPTION);
                        } else {
                            mainPage = new guiMainPage();
                            mainPageActions();
                            if (loginEmployee.getPosition().equals("nurse")) {

                                mainPage.mnPatient.remove(mainPage.mntmNewDisease);
//                        mainPage.diseaseField.setVisible(false);
//                        mainPage.mntmAddDisease.setVisible(false);
//                        mainPage.mntmAddDrug.setVisible(false);

                            }
                        }
                    }
                }
            }
        });

        loginPage.btnNewUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cnp = loginPage.cnpField.getText();

                Employee newEmployee = employeeAccess.getEmployeeInfo(cnp);

                newEmployee.setUserName(loginPage.usernameField.getText());
                newEmployee.setPassword(loginPage.passwordField.getPassword());

                employeeAccess.setEmployeeInfo(newEmployee);
                mainPage = new guiMainPage();

            }
        });


    }

    private void mainPageActions() {

    }

    private void prescriptionActions() {

    }

    private void adminActions() {

        adminPage.btnDeleteEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Employee newEmployee = getEmployeeData();
                employeeAccess.deleteEmployee(newEmployee);
            }
        });

        adminPage.btnUpdateEmployeeInformation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Employee newEmployee = getEmployeeData();
                employeeAccess.updateEmployee(newEmployee);

            }
        });

        adminPage.btnNewEmployee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Employee newEmployee = getEmployeeData();
                employeeAccess.setEmployeeInfo(newEmployee);
            }
        });
    }

    public Employee getEmployeeData(){
        Employee newEmp = new Employee();

        newEmp.setFirstName(adminPage.firstNameField.getText());
        newEmp.setLastName(adminPage.lastNameField.getText());
        newEmp.setCNP(adminPage.cnpField.getText());
        newEmp.setPosition(adminPage.positionField.getText());
        newEmp.setAddress(adminPage.adressField.getText());
        newEmp.setUserName(adminPage.usernameField.getText());
        newEmp.setPassword(adminPage.psswField.getText().toCharArray());

        return newEmp;
    }
}
