package controllers;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import views.ResultView;

public class ResultController implements Controller {
    ResultView resultView = new ResultView();

    public void setStage(Stage primaryStage) {
        resultView.setStage(primaryStage);
    }

    @FXML
    public void initialize() {

    }

}
