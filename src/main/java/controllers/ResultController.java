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
    @FXML Label emailMessageLabel;

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

        // Open the web page for the Grant.
//        readMoreButton.setOnAction(e -> );

        // Open the web page for other Grant funds
//        differentFundButton.setOnAction(e -> );

        downloadPDFButton.setOnAction(e -> downloadPDF());
        sendResultButton.setOnAction(e -> sendResults());

        // TODO: get result
        // TODO: check if the result has an available Grant or datasource and asign function
    }

    private void setGrantResult() {
        grantBox.setVisible(true);
        dataSourceBox.setVisible(false);

        // TODO: add the right Grant info.
        grantTitle.setText("Titel for the Grant");
        periodLabel.setText("Period this grant is available in?");
        grantDescription.setText("A summary description for this grant that introduces the user to request or learn more");
    }

    private void setOtherResult() {
        grantBox.setVisible(false);
        dataSourceBox.setVisible(true);

        // TODO: Decide if we can add this quickly and import the right data from the right source.
        dataSourceLabel.setText("Sorry, maar helaas hebben we geen bijpassend Subsidie voor u gevonden");
        dataSourceDescription.setText("Dit is de reden waarom we niks hebben kunnen vinden, ...");
    }

    private void downloadPDF() {

    }

    private void sendResults() {

    }

}
