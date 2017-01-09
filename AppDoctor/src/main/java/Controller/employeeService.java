package Controller;

import Person.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Alexandra R on 12/9/2016.
 */
public class employeeService {

    Statement stmt = null;
    Connection conn;
    public employeeService(Connection conn){
        this.conn=conn;
    }

    public Employee getEmployeeInfo(){
        Employee employeeData = new Employee();
        System.out.println("Creating statement..."+conn);
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Doctor";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String cnp = rs.getString("cnp");
                String username = rs.getString("username");
                String password = rs.getString("password");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", FirstName " + firstName);
                employeeData.setUserName(firstName);
                System.out.print(", LastName " + lastName);
                employeeData.setUserName(lastName);
                System.out.print(", cnp " + cnp);
                employeeData.setUserName(cnp);
                System.out.print(", username " + username);
                employeeData.setUserName(username);
                System.out.print(", password " + password);
                employeeData.setUserName(password);

                employeeData.setPosition("Necunoscut");
            }
            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeData;
    }

    public Employee getEmployeeInfo(String Empcnp){
        Employee employeeData = new Employee();
        System.out.println("Creating statement..."+conn);
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Doctor WHERE cnp LIKE"+Empcnp;
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String cnp = rs.getString("cnp");
                String username = rs.getString("username");
                String password = rs.getString("password");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", FirstName " + firstName);
                employeeData.setFirstName(firstName);
                System.out.print(", LastName " + lastName);
                employeeData.setLastName(lastName);
                System.out.print(", cnp " + cnp);
                employeeData.setCNP(cnp);
                System.out.print(", username " + username);
                employeeData.setUserName(username);
                System.out.print(", password " + password);
                employeeData.setPassword(password);
            }
            rs.close();
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeData;
    }
    public boolean login(String user,String pass){
        try{
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Doctor";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String cnp = rs.getString("cnp");
                String username = rs.getString("username");
                String password = rs.getString("password");
                if(username.equals(user) && password.equals(pass)){
                    rs.close();
                    stmt.close();
                    return true;
                }
            }
            rs.close();
            stmt.close();
            return false;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void setEmployeeInfo(Employee newUser){

    }
}
