package Person;

/**
 * Created by Alexandra R on 12/9/2016.
 */
public class Employee extends Person{
    private String position;
    private String userName;
    private String password;


    public Employee(String firstName, String lastName, String CNP, String position, String userName, String password) {
        super(firstName, lastName, CNP);
        this.position = position;
        this.userName = userName;
        this.password = password;
    }
    public Employee(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


}
