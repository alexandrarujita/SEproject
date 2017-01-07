package GUI;/**
 * Created by Alexandra R on 11/4/2016.
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import static javafx.scene.paint.Color.*;


public class guiMainPage {

    public JFrame mainPage, prescriptionPage;
    private JPanel contentPane;
    public JButton btnAddNewPatient;
    public JMenuBar menuBar;
    public JMenu mnMedical;
    public JMenuItem mntmAddNewEvent;
    public JMenuItem mntmSeeNextWeeks;
    public JMenu mnPatient;
    public JMenuItem mntmSeeCurrentEvents;
    public JMenu mnEvents;
    public JMenuItem mntmBasicInformation;
    public JMenuItem mntmRecord;
    public JMenuItem mntmAddPrescription; //the prescription frame will open
    public JMenuItem mntmAddVisit;
    public JMenuItem mntmAddDisease; //cannot be accessed by nurse
    public JMenuItem mntmAddResult; //cannot be accessed by nurse
    public JMenuItem mntmNewDisease;
    public JMenuItem mntmAddDrug; //cannot be accessed by nurse
    public JTextField firstNameField;
    public JTextField lastNameField;
    public JTextField cnpField;
    public JButton btnLogout;

    //prescription
    public JPanel contentPanePrescription;
    public JLabel lblDate; //will be updated with current date
    public JLabel lblPatientName; //will be updated with patient's name
    public JTextField diseaseField;
    public JTextField drugField; //drugs will be separated with commas and then applied regex on the string
    public JTextField quantityField;
    public JTextField directionsField;
    public JButton btnAddPrescription;
    public JButton btnSeeDrugs; // a new window will appear with all the drugs in the database

    //admin page


    public guiMainPage(){

    }

    public void guiDoctor() {
        mainPage = new JFrame();
        mainPage.setTitle("Doctor's page");
        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPage.setBounds(100, 100, 485, 371);

        menuBar = new JMenuBar();
        mainPage.setJMenuBar(menuBar);

        mnMedical = new JMenu("Medical");
        menuBar.add(mnMedical);

        mnPatient = new JMenu("Patient");
        mnMedical.add(mnPatient);

        mntmBasicInformation = new JMenuItem("Basic information");
        mnPatient.add(mntmBasicInformation);

        mntmRecord = new JMenuItem("Record");
        mnPatient.add(mntmRecord);

        mntmAddPrescription = new JMenuItem("Add prescription");
        mnPatient.add(mntmAddPrescription);

        mntmAddVisit = new JMenuItem("Add appointment");
        mnPatient.add(mntmAddVisit);

        mntmAddDisease = new JMenuItem("Add disease");
        mnPatient.add(mntmAddDisease);

        mntmAddResult = new JMenuItem("Add result");
        mnPatient.add(mntmAddResult);

        mntmNewDisease = new JMenuItem("Add new disease");
        mnMedical.add(mntmNewDisease);

        mntmAddDrug = new JMenuItem("Add drug");
        mnMedical.add(mntmAddDrug);

        mnEvents = new JMenu("Events");
        menuBar.add(mnEvents);

        mntmSeeCurrentEvents = new JMenuItem("See current events");
        mnEvents.add(mntmSeeCurrentEvents);

        mntmAddNewEvent = new JMenuItem("Add new event");
        mnEvents.add(mntmAddNewEvent);

        mntmSeeNextWeeks = new JMenuItem("See next week's events");
        mnEvents.add(mntmSeeNextWeeks);


        JButton btnRemovePatient = new JButton("Remove patient");
        btnRemovePatient.setBounds(240, 213, 156, 38);
        contentPane.add(btnRemovePatient);

        btnAddNewPatient = new JButton("Add new patient");
        btnAddNewPatient.setBounds(37, 213, 147, 38);
        contentPane.add(btnAddNewPatient);

        JLabel lblFirstName = new JLabel("First name:");
        lblFirstName.setBounds(22, 34, 106, 24);
        contentPane.add(lblFirstName);

        JLabel lblLastName = new JLabel("Last name:");
        lblLastName.setBounds(21, 69, 106, 24);
        contentPane.add(lblLastName);

        JLabel lblCnp = new JLabel("CNP:");
        lblCnp.setBounds(22, 104, 46, 14);
        contentPane.add(lblCnp);

        firstNameField = new JTextField();
        firstNameField.setBounds(108, 36, 156, 20);
        contentPane.add(firstNameField);
        firstNameField.setColumns(10);

        lastNameField = new JTextField();
        lastNameField.setColumns(10);
        lastNameField.setBounds(108, 71, 156, 20);
        contentPane.add(lastNameField);

        cnpField = new JTextField();
        cnpField.setColumns(10);
        cnpField.setBounds(108, 104, 156, 20);
        contentPane.add(cnpField);

        btnLogout = new JButton("LOGOUT");
        btnLogout.setBounds(370, 11, 89, 23);
        contentPane.add(btnLogout);

        mainPage.setVisible(true);
    }

    public void guiPrescription() {

        prescriptionPage.setTitle("Add prescription");
        prescriptionPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        prescriptionPage.setBounds(100, 100, 704, 292);
        contentPanePrescription = new JPanel();
        contentPanePrescription.setBorder(new EmptyBorder(5, 5, 5, 5));
        prescriptionPage.setContentPane(contentPanePrescription);
        contentPanePrescription.setLayout(null);

        lblDate = new JLabel("Date");
        lblDate.setBounds(552, 11, 126, 28);
        contentPane.add(lblDate);

        lblPatientName = new JLabel("Patient name");
        lblPatientName.setBounds(10, 11, 137, 28);
        contentPane.add(lblPatientName);

        JLabel lblNewLabel_1 = new JLabel("Condition:");
        lblNewLabel_1.setBounds(10, 71, 87, 28);
        contentPane.add(lblNewLabel_1);

        JLabel lblDrugs = new JLabel("Drug:");
        lblDrugs.setBounds(10, 110, 56, 28);
        contentPane.add(lblDrugs);

        JLabel lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(10, 149, 87, 21);
        contentPane.add(lblQuantity);

        JLabel lblDirections = new JLabel("Directions:");
        lblDirections.setBounds(10, 181, 87, 21);
        contentPane.add(lblDirections);

        diseaseField = new JTextField();
        diseaseField.setBounds(85, 75, 196, 20);
        contentPane.add(diseaseField);
        diseaseField.setColumns(10);

        drugField = new JTextField();
        drugField.setColumns(10);
        drugField.setBounds(85, 114, 196, 20);
        contentPane.add(drugField);

        quantityField = new JTextField();
        quantityField.setColumns(10);
        quantityField.setBounds(85, 149, 196, 20);
        contentPane.add(quantityField);

        directionsField = new JTextField();
        directionsField.setColumns(10);
        directionsField.setBounds(85, 181, 196, 20);
        contentPane.add(directionsField);

        btnSeeDrugs = new JButton("See all drugs");
        btnSeeDrugs.setBounds(524, 141, 104, 37);
        contentPane.add(btnSeeDrugs);

        btnAddPrescription = new JButton("Add prescription");
        btnAddPrescription.setBounds(442, 205, 186, 37);
        contentPane.add(btnAddPrescription);

        prescriptionPage.setVisible(true);
    }


}
