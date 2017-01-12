package Controller;

import Database.ConnectionToDatabase;
import GUI.guiAdmin;
import GUI.guiCalendar;
import GUI.guiLog;
import GUI.guiMainPage;
import Patient.Patient;
import Person.Doctor;
import Person.Nurse;
import Person.*;
import Patient.Drug;
import org.joda.time.DateTime;
import org.joda.time.chrono.StrictChronology;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

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
    private doctorService doctorAccess;
    private guiCalendar calendarPage;
    private dateService dateAccess;
    private int day;
    private ConnectionToDatabase conn;


    public Controller(ConnectionToDatabase conn) {
        this.conn=conn;
        loginPage = new guiLog();
        loginPage.cnpField.setVisible(false);
        loginPage.lblCnp.setVisible(false);

        employeeAccess = new employeeService(conn.getConn());
        loginActions();

    }

    private void loginActions() {
        loginPage.btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = loginPage.usernameField.getText();
                char[] passw = loginPage.passwordField.getPassword();

                if (passw.length == 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a password");
                } else {

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
                            if (loginEmployee.getPassword()==null) {
                                JOptionPane.showMessageDialog(null, "Incorrect password! ", "OK", JOptionPane.OK_OPTION);
                            } else {
                                mainPage = new guiMainPage();
                                mainPageActions();
                                if (loginEmployee.getPosition().equals("nurse")) {

//                        mainPage.diseaseField.setVisible(false);
//                        mainPage.mntmAddDisease.setVisible(false);
//                        mainPage.mntmAddDrug.setVisible(false);

                                }
                                loginPage.frmApplicationForFamily.setVisible(false);
                            }
                        }
                    }
                }
            }
        });

        loginPage.btnNewUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginPage.cnpField.setVisible(true);
                loginPage.lblCnp.setVisible(true);

                String cnp = loginPage.cnpField.getText();

                if (!cnp.matches("[0-9]+"))
                    JOptionPane.showMessageDialog(null, "CNP must contain only digits");
                else {
                    Employee newEmployee = employeeAccess.getEmployeeInfo(cnp);

                    newEmployee.setUserName(loginPage.usernameField.getText());
                    newEmployee.setPassword(loginPage.passwordField.getPassword());

                    employeeAccess.setEmployeeInfo(newEmployee);
                    mainPage = new guiMainPage();
                    mainPageActions();
                    loginPage.frmApplicationForFamily.setVisible(false);
                }

            }
        });


    }

    private void mainPageActions() {

        final Calendar events = Calendar.getInstance();

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

        mainPage.btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPage.mainPage.setVisible(false);
                loginPage.frmApplicationForFamily.setVisible(true);
            }
        });

        mainPage.mntmAddPrescription.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Person patient = getPatientInfo();
                mainPage.guiPrescription();
                prescriptionActions(patient);
            }
        });

        mainPage.mntmAddDrug.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String drug = JOptionPane.showInputDialog(null, "Enter new drug");
                doctorAccess.addNewDrug(drug);
            }
        });

        mainPage.mntmSeeEvents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DateTime[] events = dateAccess.getEvents();
                calendarPage = new guiCalendar();
                calendarPage.setEvents(events);

            }
        });

        mainPage.mntmAddNewEvent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String details =  JOptionPane.showInputDialog(null,"Add events details");
                calendarPage = new guiCalendar();
                getAppointmentDate();
                DateTime appointment = new DateTime(calendarPage.getYy(), calendarPage.getMm(), day, 1, 1);
                dateAccess.addNewEvent(appointment,details);

            }
        });

        mainPage.mntmNewDisease.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String disease = JOptionPane.showInputDialog(null, "Enter new disease");
                doctorAccess.addDisease(disease);
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
//        mainPage.btnSeeDrugs.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String[] columnNames = {"name",
//                        "price"};
//                ArrayList<Drug> drugs =employeeAccess.seeAllDrugs();
//                Object[][] data=new Object[drugs.size()][2];
//                int i=0;
//                for(Drug d: drugs){
//                    data[i][0]=d.getName();
//                    data[i][1]=d.getPrice();
//                    System.out.println(data[i][0]);
//                    System.out.println(data[i][1]);
//                    i++;
//                }
//                JTable table = new JTable(data, columnNames);
 //           }
//        });


        mainPage.mntmAddResult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        mainPage.mntmAddAppointmentForPatient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calendarPage = new guiCalendar();
                getAppointmentDate();
                DateTime appointment = new DateTime(calendarPage.getYy(), calendarPage.getMm(), day, 1, 1);
                Person patient = getPatientInfo();
                dateAccess.addNewAppointment(appointment,patient);
                patientAccess.addAppointment(appointment,patient);
            }
        });


    }

    private void prescriptionActions(final Patient patientsPrescr) {

        mainPage.lblPatientName.setText(patientsPrescr.getFirstName() + " " + patientsPrescr.getLastName());
        mainPage.lblDate.setText(new Date().toString());

        mainPage.btnSeeDrugs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //new frame with a table that contains all the drugs
            }
        });

        mainPage.btnAddPrescription.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //get all the fields
                String disease = mainPage.diseaseField.getText();
                String drug = mainPage.drugField.getText();
                int quantity = Integer.parseInt(mainPage.quantityField.getText());
                String directions = mainPage.directionsField.getText();
                
                patientAccess.addDisease(disease,patientsPrescr);
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

    private Employee getEmployeeData() {
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

    private Patient getPatientInfo() {
        Patient patient = new Patient();

        patient.setFirstName(mainPage.firstNameField.getText());
        patient.setLastName(mainPage.lastNameField.getText());
        patient.setCNP(mainPage.cnpField.getText());

        return patient;
    }

    private void getAppointmentDate() {

        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 7; j++) {
                calendarPage.labs[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String num = e.getActionCommand();
                        if (!num.equals("")) {
                            day = Integer.parseInt(num);

                        }
                    }
                });
            }
    }

}
