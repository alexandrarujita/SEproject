package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Patient.Patient;

/**
 * Created by Alexandra R on 11/18/2016.
 */
public class patientService {
    Statement stmt = null;
    Connection conn;
    public patientService(Connection conn){
        this.conn=conn;
    }
    public void addPatient(Patient patient){
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

    public Patient getPatientInfo(String Empcnp){
        Patient patientData = new Patient();
        System.out.println("Creating statement..."+conn);
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Patient";
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
}
