package GUI;/**
 * Created by Alexandra R on 11/4/2016.
 */

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class guiMainPage extends Application {

    public Button addEmployee;
    public Button removeEmployee;
    public Button editEmployeeInfo;

    public Button logout;
    public Button addEvent;
    public Button removeEvent;
    public Button addPatient;
    public Button removePatient;

    public Button editPatientInfo;

    public Button addPrescription;
    public Button addAppointment;

  //  public guiLog g = new guiLog();


    public static void main(String[] args) {
        launch(args);
    }

    public guiMainPage(){
        new guiLog();
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
