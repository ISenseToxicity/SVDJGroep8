package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.AnimationService;
import views.ResultView;

public class ResultController implements Controller {
    ResultView resultView = new ResultView();

    @FXML
    Label resultTitle;

    @FXML VBox grantBox;
    @FXML Label grantTitle;
    @FXML Label periodLabel;
    @FXML Label grantDescription;
    @FXML Button readMoreButton;
    @FXML Label readMoreLabel;

    @FXML VBox dataSourceBox;
    @FXML Label dataSourceLabel;
    @FXML Label dataSourceDescription;
    @FXML Button differentFundButton;
    @FXML Label differentFundLabel;

    @FXML Button downloadPDFButton;
    @FXML Label downloadPDFLabel;
    @FXML TextField emailField;
    @FXML Button sendResultButton;

    @FXML HBox questionAnswerBox;
    @FXML Label questionTitle;
    @FXML Label questionAnswer;
    @FXML Label moreInfoButton;

    public void setStage(Stage primaryStage) {
        resultView.setStage(primaryStage);
    }

    @FXML
    public void initialize() {
        AnimationService.createButtonAnimation(readMoreButton, readMoreLabel);
        AnimationService.createButtonAnimation(differentFundButton, differentFundLabel);
        AnimationService.createButtonAnimation(downloadPDFButton, downloadPDFLabel);

    // TODO: get result
    }

}
