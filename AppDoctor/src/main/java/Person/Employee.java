package Person;

/**
 * Created by Alexandra R on 12/9/2016.
 */
public class Employee extends Person{
    private String position;
    private String userName;
    private String password;


    public Employee(String firstName, String lastName, String CNP, String address, String position, String userName, String password) {
        super(firstName, lastName, CNP, address);
        this.position = position;
        this.userName = userName;
        this.password = password;
    }

}
