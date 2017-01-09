package main;

import Controller.Controller;
import Database.ConnectionToDatabase;
import GUI.guiAdmin;
import GUI.guiLog;
import GUI.guiMainPage;


/**
 * Created by Alexandra R on 1/5/2017.
 */
public class toRun {

    public static void main(String[] args) {

       // launch(args);
        ConnectionToDatabase connectionToDatabase = new ConnectionToDatabase();
        connectionToDatabase.startConnection();
       new Controller(connectionToDatabase);
        //connectionToDatabase.closeConnection();
      //  new guiAdmin();
    //new guiMainPage();
    }
}
