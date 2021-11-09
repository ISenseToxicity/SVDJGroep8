package controllers;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
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

    @FXML javafx.scene.control.Label question;

    @FXML javafx.scene.control.CheckBox answer1;
    @FXML javafx.scene.control.CheckBox answer2;
    @FXML javafx.scene.control.CheckBox answer3;
    @FXML javafx.scene.control.CheckBox answer4;

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
        initializefirstQuestion();
    }

    private void initializefirstQuestion(){
        QuestionController questionController = new QuestionController();
        changeQuestionText(questionController.getQuestionTitle(0));
        changeAnswerTitle(questionController.getAnswerTitle(0,0),0);
        changeAnswerTitle(questionController.getAnswerTitle(0,1),1);
        makeAnswerInvisible(2);
        makeAnswerInvisible(3);

    }
    private void showPopup() {
        moreInfoPane.setVisible(true);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), moreInfoPane);
        translateTransition.setByX(-620);
        translateTransition.play();

        // Example video, DELETE LATER
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

    private void changeQuestionText(String questionTitle){
        question.setText(questionTitle);
    }
    private void makeAnswerInvisible(int answerNumber){
        switch (answerNumber){
            case 0:
                answer1.setVisible(false);
                break;
            case 1:
                answer2.setVisible(false);
                break;
            case 2:
                answer3.setVisible(false);
                break;
            case 3:
                answer4.setVisible(false);
                break;
        }
    }
    private void changeAnswerTitle(String answerTitle,int answerNumber){
        switch (answerNumber){
            case 0:
                answer1.setText(answerTitle);
                break;
            case 1:
                answer2.setText(answerTitle);
                break;
            case 2:
                answer3.setText(answerTitle);
                answer4.setVisible(true);
                break;
            case 3:
                answer4.setText(answerTitle);
                answer4.setVisible(true);
                break;
        }
    }
}
