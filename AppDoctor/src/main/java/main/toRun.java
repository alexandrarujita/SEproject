package main;

import Controller.*;
import Database.ConnectionToDatabase;


/**
 * Created by Alexandra R on 1/5/2017.
 */
public class toRun {

    public static void main(String[] args) {

        ConnectionToDatabase connectionToDatabase = new ConnectionToDatabase();
        connectionToDatabase.startConnection();
        new Controller(connectionToDatabase);
        //  new guiAdmin();
    //new guiMainPage();
//        new guiCalendar();
    }
}
