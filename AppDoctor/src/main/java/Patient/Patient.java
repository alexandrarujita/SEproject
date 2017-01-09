package Patient;

/**
 * Created by Alexandra R on 11/4/2016.
 */

public class Patient extends Person.Person {

    public Prescription prescription;
    public MedicalRecord medicalRecord;

    public Patient(String firstName, String lastName, String CNP) {
        super(firstName, lastName, CNP);
    }
    public Patient(){

    }
}


