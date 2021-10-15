package controllers;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.AnimationService;
import views.FormView;

public class FormController implements Controller {

    FormView formView = new FormView();


    // FXML id's
    @FXML javafx.scene.control.Button nextButton;
    @FXML javafx.scene.control.Button previousButton;

    @FXML javafx.scene.control.Label nextLabel;
    @FXML javafx.scene.control.Label previousLabel;

    @FXML javafx.scene.control.Label moreInfoButton;
    @FXML javafx.scene.control.Button closeButton;
    @FXML ScrollPane moreInfoPane;

    @FXML WebView infoVideo;
    @FXML WebEngine webEngine;


    public void setStage(Stage primaryStage) {
        formView.setStage(primaryStage);
    }

    @FXML
    private void initialize() {

        // This sets the animation for the colors of the buttons.
        AnimationService.createButtonAnimation(nextButton, nextLabel);
        AnimationService.createButtonAnimation(previousButton, previousLabel);

        moreInfoButton.setOnMouseClicked(e -> showPopup());
        closeButton.setOnMouseClicked(e -> closePopup());

        infoVideo.setContextMenuEnabled(false);
        webEngine = infoVideo.getEngine();


    }

    private void showPopup() {
        moreInfoPane.setVisible(true);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), moreInfoPane);
        translateTransition.setByX(-620);
        translateTransition.play();

        // TODO: Example video, DELETE LATER
        webEngine.load("https://www.youtube.com/embed/WPyOl4Equpw");
        // ^^^^^^^^^^^^^^^^^^^^^^^^^^^
    }

    private void closePopup() {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), moreInfoPane);
        translateTransition.setByX(620);
        translateTransition.play();

        translateTransition.setOnFinished(e -> moreInfoPane.setVisible(false));

        webEngine.load("");
    }

}
