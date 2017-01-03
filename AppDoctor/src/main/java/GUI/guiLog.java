package GUI;/**
 * Created by Alexandra R on 11/4/2016.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class guiLog extends Application {

    public Button button;
    public TextField username;
    public PasswordField password;
    private Alert wrongLogin;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        button = new Button();
        username = new TextField();
        password = new PasswordField();
        wrongLogin = new Alert(Alert.AlertType.ERROR);

        button.setText("Login");

        wrongLogin.setTitle("Wrong login information");
        wrongLogin.setContentText("Wrong ID or password");
        //wrongLogin.showAndWait();

        GridPane layout = new GridPane();
        layout.add(button,3,5);
        layout.add(username,3,1);
        layout.add(password,3,3);

        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
