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
        employeeData.setUserName(null);
        return employeeData;
    }

    public Employee getEmployeeInfo(String cnp){
        Employee employeeData = new Employee();
        employeeData.setUserName(null);
        return employeeData;
    }

    public void setEmployeeInfo(Employee newUser){

    }
}
