package Controller;

import Database.ConnectionToDatabase;
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
    private ConnectionToDatabase conn;



    public Controller(ConnectionToDatabase conn){
        this.conn = conn;
       // conn.startConnection();
      loginPage = new guiLog();
        employeeAccess = new employeeService(conn.getConn());
        loginActions();
    }

    private void loginActions(){
        loginPage.btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username  = loginPage.usernameField.getText();
                char[] passw = loginPage.passwordField.getPassword();

                if( username.equals("admin") ){
                    adminPage = new guiAdmin();
                }else{
                    Employee loginEmployee = employeeAccess.getEmployeeInfo();
                    loginPage.cnpField.setVisible(false);
                    loginPage.lblCnp.setVisible(false);

                    if ( loginEmployee.getUserName().equals(null) ) {
                       JOptionPane.showMessageDialog(null,"Username does not yet exist, please click NEW USER  ","OK",JOptionPane.OK_OPTION);
                        loginPage.cnpField.setVisible(true);
                        loginPage.lblCnp.setVisible(true);
                    }else {

                        if (loginEmployee.getPosition().equals("doctor"))
                            mainPage = new guiMainPage();
                        else {
                            mainPage = new guiMainPage();
                            mainPage.mnPatient.remove(mainPage.mntmNewDisease);
//                        mainPage.diseaseField.setVisible(false);
//                        mainPage.mntmAddDisease.setVisible(false);
//                        mainPage.mntmAddDrug.setVisible(false);

                        }
                    }
                }
            }
        });

        loginPage.btnNewUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               String cnp = loginPage.cnpField.getText();

                Employee newEmployee  = employeeAccess.getEmployeeInfo(cnp);

                newEmployee.setUserName(loginPage.usernameField.getText());
                newEmployee.setPassword(String.valueOf(loginPage.passwordField.getPassword()));

                employeeAccess.setEmployeeInfo(newEmployee);

            }
        });



    }

    private void mainPageActions(){

    }

    private void prescriptionActions(){

    }
}
