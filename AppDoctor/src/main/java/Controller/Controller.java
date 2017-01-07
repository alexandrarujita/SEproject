package Controller;

import GUI.guiAdmin;
import GUI.guiLog;
import GUI.guiMainPage;
import Patient.Patient;
import Person.Doctor;
import Person.Nurse;
import Person.*;
import sun.util.resources.CalendarData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
    private patientService patientAccess;


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
                    loginPage.frmApplicationForFamily.setVisible(false);
                    adminActions();
                } else {
                    Employee loginEmployee = employeeAccess.getEmployeeInfo();

                    if (loginEmployee.getUserName().equals("nou")) { //aici inca nu stiu sigur cum sa facem altfel
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
                            loginPage.frmApplicationForFamily.setVisible(false);
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
                loginPage.frmApplicationForFamily.setVisible(false);

            }
        });


    }

    private void mainPageActions() {

        mainPage.btnAddNewPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Person patient = getPatientInfo();
                patientAccess.newPatient(patient);

            }
        });

        mainPage.btnRemovePatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Person patient = getPatientInfo();
                patientAccess.removePatient(patient);
            }
        });

        mainPage.btnUpdatePatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Person patient = getPatientInfo();
                if (patientAccess.checkForPatient(patient.getCNP()))
                    patientAccess.updatePatient(patient);
                else {
                    JOptionPane.showMessageDialog(null, "Patient is not yet in the database", "Add patient", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        mainPage.mntmAddPrescription.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Person patient = getPatientInfo();
                mainPage.guiPrescription();
                prescriptionActions(patient);
            }
        });


        mainPage.btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPage.mainPage.setVisible(false);
                loginPage.frmApplicationForFamily.setVisible(true);
            }
        });

        mainPage.mntmBasicInformation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        mainPage.mntmRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        mainPage.mntmAddPrescription.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        mainPage.mntmAddDisease.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        mainPage.mntmAddResult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        mainPage.mntmAddDrug.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        mainPage.mntmSeeCurrentEvents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        mainPage.mntmAddNewEvent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        mainPage.mntmSeeNextWeeks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        mainPage.mntmNewDisease.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        mainPage.mntmAddVisit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        //add new disease si add appointment for patient
    }

    private void prescriptionActions(final Person patientsPrescr) {

        mainPage.lblPatientName.setText(patientsPrescr.getFirstName() + " " + patientsPrescr.getLastName());
        mainPage.lblDate.setText(new GregorianCalendar().toString());

        mainPage.btnSeeDrugs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //new frame with a table that contains all the drugs
            }
        });

        mainPage.btnAddPrescription.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //get all the fields
                patientAccess.addPrescriptionFor(patientsPrescr);
            }
        });
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

    public Employee getEmployeeData() {
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

    public Patient getPatientInfo() {
        Patient patient = new Patient();

        patient.setFirstName(mainPage.firstNameField.getText());
        patient.setLastName(mainPage.lastNameField.getText());
        patient.setCNP(mainPage.cnpField.getText());
        patient.setAddress(mainPage.adressField.getText());

        return patient;
    }
}
