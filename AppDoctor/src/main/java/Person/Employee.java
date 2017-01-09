package Person;

/**
 * Created by Alexandra R on 12/9/2016.
 */
public class Employee extends Person{
    private String position;
    private String userName;
    private char[] password;


    public Employee(String firstName, String lastName, String CNP, String address, String position, String userName, char[] password) {
        super(firstName, lastName, CNP, address);
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

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


}
