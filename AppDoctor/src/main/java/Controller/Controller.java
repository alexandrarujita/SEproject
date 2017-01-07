package Controller;

import GUI.guiAdmin;
import GUI.guiLog;
import GUI.guiMainPage;
import Person.Doctor;
import Person.Nurse;
import Person.*;

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



    public Controller(){
      loginPage = new guiLog();

    }

    private void loginActions(){
        loginPage.btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username  = loginPage.usernameField.getText();
                char[] passw = loginPage.passwordField.getPassword();
                if( username == "admin"){
                    adminPage = new guiAdmin();
                }else{
                    Employee loginEmployee = new Employee();
                    //call to method in employee service
                    if(loginEmployee.getPosition() == "doctor")
                        mainPage = new guiMainPage();
                    else{
                        mainPage = new guiMainPage();
                        mainPage.diseaseField.setVisible(false);
                        mainPage.mntmAddDisease.setVisible(false);
                        mainPage.mntmAddDrug.setVisible(false);
                    }
                }
            }
        });

        loginPage.btnNewUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               String cnp = loginPage.cnpField.getText();
                /*
                if ( cnp exista in baza de date )
                        return an employee
                 */
                Employee newEmployee = new Employee();
                newEmployee.setUserName(loginPage.usernameField.getText());
                newEmployee.setPassword(loginPage.passwordField.getPassword());

            }
        });



    }

    private void mainPageActions(){

    }

    private void prescriptionActions(){

    }
}
