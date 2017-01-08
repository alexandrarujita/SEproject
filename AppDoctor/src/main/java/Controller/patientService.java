package Controller;

import Patient.Patient;
import Person.Person;
import org.joda.time.DateTime;

/**
 * Created by Alexandra R on 11/18/2016.
 */
public class patientService {

    public patientService(){

    }

    public void newPatient(Person newPatient){

    }

    public void removePatient(Person oldPatient){

    }

    public void updatePatient(Person updatePatient){

    }

    public Person getPatientInfo(String cnp){
        Person patient = new Patient();

        return patient;
    }

    public boolean checkForPatient(String cnp){
        //if it exists in the data base
        return false;
    }

    public void addPrescriptionFor(Person patient){

    }

    public void addDisease(String disease) {
    }

    public void addAppointment(DateTime date, Person Patient){

    }
}
