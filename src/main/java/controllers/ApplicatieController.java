package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import views.ApplicatieView;

public class ApplicatieController implements Controller {

    ApplicatieView applicatieView = new ApplicatieView();

    @FXML private Button beginButton;

    public void setStage(Stage primaryStage) {
        applicatieView.setStage(primaryStage);
    }

    @FXML
    private void initialize() {

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage primaryStage = applicatieView.getStage();
                StartController startController = (StartController) ControllerRegistry.get(StartController.class);
                startController.setStage(primaryStage);
            }
        };

        beginButton.setOnAction(event);
    }

}
