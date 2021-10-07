package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import views.ApplicatieView;

public class ApplicatieController implements Controller {

    ApplicatieView applicatieView = new ApplicatieView();

    public void setStage(Stage primaryStage) {
        applicatieView.setStage(primaryStage);
    }

}
