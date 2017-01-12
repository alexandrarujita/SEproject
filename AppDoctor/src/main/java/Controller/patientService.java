package Controller;

import Patient.Patient;
import Person.Person;
import org.joda.time.DateTime;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Patient.Patient;
import Patient.Disease;
import Patient.Drug;
import Patient.MedicalRecord;
/**
 * Created by Alexandra R on 11/18/2016.
 */
public class patientService {
    Statement stmt = null;
    Connection conn;
    public patientService(){

    }
    public patientService(Connection conn){
        this.conn=conn;
    }
    public void newPatient(Patient patient){
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO Patient " +
                    "        VALUES ("+patient.getFirstName()+","+patient.getLastName()+","+patient.getCNP()+");";
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Patient getPatientInfo(String empcnp){
        Patient patientData = new Patient();
        System.out.println("Creating statement..."+conn);
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Patient WHERE cnp LIKE "+empcnp;
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String cnp = rs.getString("cnp");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", FirstName " + firstName);
                patientData.setFirstName(firstName);
                System.out.print(", LastName " + lastName);
                patientData.setLastName(lastName);
                System.out.print(", cnp " + cnp);
                patientData.setCNP(cnp);
            }
            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return patientData;
    }

    public void removePatient(Person oldPatient){

        System.out.println("Creating statement..."+conn);
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "Delete FROM Patient where cnp LIKE "+oldPatient.getCNP();
            stmt.executeQuery(sql);
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePatient(Person oldPatient,String name,String cnp){
        System.out.println("Creating statement..."+conn);
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "UPDATE Patient SET name="+name+",cnp="+cnp+"where cnp LIKE "+oldPatient.getCNP();
            stmt.executeQuery(sql);
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public boolean checkForPatient(String cnp){
        //if it exists in the data base
        return false;
    }

    public void addPrescriptionFor(Patient patient, Disease disease,Drug drug, int quantity,String directions){
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO Prescription " +
                    "        VALUES ("+getMedicalRecordIdForPatient(patient)+","+getConditionID(disease)+","+quantity+","+directions+","+getIdForDrug(drug)+");";
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getMedicalRecordIdForPatient(Patient patient){
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT medical_record_id FROM Patient WHERE cnp LIKE "+patient.getCNP();
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                return rs.getInt("id");

            }
            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int getIdForDrug(Drug drug){
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id FROM drug WHERE name LIKE "+drug.getName();
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                return rs.getInt("id");

            }
            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int getIdForPatient(Patient patient){
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT medical_record_id FROM patient WHERE cnp LIKE "+patient.getCNP();
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                return rs.getInt("id");

            }
            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int getMedicalRecordIDforPatient(int id){
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id FROM medical_record WHERE id LIKE "+id;
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                return rs.getInt("id");

            }
            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int getConditionID(Disease disease){
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id FROM disease WHERE name LIKE "+disease.getName();
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                return rs.getInt("id");

            }
            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addDisease(String disease, Patient patient) {
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO disease " +
                    "        VALUES ("+disease+","+getMedicalRecordIDforPatient(getIdForPatient(patient))+");";
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAppointment(DateTime date, Person Patient){

    }
}
