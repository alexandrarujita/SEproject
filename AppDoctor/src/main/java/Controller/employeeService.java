package Controller;

import Person.Employee;

/**
 * Created by Alexandra R on 12/9/2016.
 */

public class employeeService {

    public employeeService(){

    }

    public Employee getEmployeeInfo(){
        Employee employeeData = new Employee();
        employeeData.setUserName("nou"); //numa o idee, putem incerca si ceva mai flexibil
        employeeData.setPassword(null);
        return employeeData;
    }

    public Employee getEmployeeInfo(String cnp){
        Employee employeeData = new Employee();
        employeeData.setCNP(cnp);

        //access database for an employee with given CNP

        // do this even after database access is implemented because they do not exist
        employeeData.setUserName("nou");
        employeeData.setPassword(null);

        return employeeData;
    }

    public void setEmployeeInfo(Employee newUser){ //pentru new employee

    }

    public void deleteEmployee(Employee deleteEmployee){

    }

    public void updateEmployee(Employee updateEmployee){ //trebuie neaparat CNP pt ca ii unic

    }


}
