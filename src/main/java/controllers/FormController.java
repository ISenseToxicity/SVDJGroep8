package controllers;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.AnimationService;
import views.FormView;

public class FormController implements Controller {
    QuestionOrderController questionOrderController = (QuestionOrderController) ControllerRegistry.get(QuestionOrderController.class);
    FormView formView = new FormView();

    @FXML Button nextButton;
    @FXML Button previousButton;

    @FXML Label nextLabel;
    @FXML Label previousLabel;

    @FXML Label moreInfoButton;
    @FXML Button closeButton;

    @FXML Label question;

    @FXML CheckBox answer1;
    @FXML CheckBox answer2;
    @FXML CheckBox answer3;
    @FXML CheckBox answer4;

    @FXML Label extraInfoDescription;

    @FXML ScrollPane moreInfoPane;

    @FXML WebView infoVideo;
    @FXML WebEngine webEngine;


    public void setStage(Stage primaryStage) {
        formView.setStage(primaryStage);
    }

    @FXML
    private void initialize() {
        QuestionListController questionListController = (QuestionListController) ControllerRegistry.get(QuestionListController.class);
        questionListController.getQuestionListFromAPI();

        AnimationService.createButtonAnimation(nextButton, nextLabel);
        AnimationService.createButtonAnimation(previousButton, previousLabel);

        moreInfoButton.setOnMouseClicked(e -> showPopup());
        closeButton.setOnMouseClicked(e -> closePopup());
        nextButton.setOnMouseClicked(event -> changeToNextQuestion());

        infoVideo.setContextMenuEnabled(false);
        webEngine = infoVideo.getEngine();

        listeners();
       changeToNextQuestion();
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

    private void listeners(){
        answer1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (answer1.isSelected()) {
                unSelectOtherCheckBoxes(answer1.getId());
            }
        });
        answer2.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(answer2.isSelected()){
                unSelectOtherCheckBoxes(answer2.getId());
            }
        });
        answer3.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(answer3.isSelected()){
                unSelectOtherCheckBoxes(answer3.getId());
            }
        });
        answer4.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(answer4.isSelected()){
                unSelectOtherCheckBoxes(answer4.getId());
            }
        });
    }

    private void unSelectOtherCheckBoxes(String checkBoxID){
      if(!checkBoxID.equals("answer1")){
          answer1.setSelected(false);
      }
        if(!checkBoxID.equals("answer2")){
            answer2.setSelected(false);
        }
        if(!checkBoxID.equals("answer3")){
            answer3.setSelected(false);
        }
        if(!checkBoxID.equals("answer4")){
            answer4.setSelected(false);
        }
    }

    private void closePopup() {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), moreInfoPane);
        translateTransition.setByX(620);
        translateTransition.play();

        translateTransition.setOnFinished(e -> moreInfoPane.setVisible(false));

        webEngine.load("");
    }

    private void changeQuestionText(){
        question.setText(this.questionOrderController.getCurrentQuestion().getQuestionText());
    }

    private void changeextraInfoDescription(){
        extraInfoDescription.setText(this.questionOrderController.getCurrentQuestion().getExtraInfoTile());
    }

    private void changeToNextQuestion(){
         this.questionOrderController.calculateNextQuestion();
        changeAnswerTitle();
        changeQuestionText();
        changeextraInfoDescription();
        makeAnswerInvisible();
    }

    private void changeAnswerTitle(){
        for(int i = 0; this.questionOrderController.getCurrentQuestion().getAnswers().size() > i; i++){
            String answerTitle = this.questionOrderController.getCurrentQuestion().getAnswers().get(i).getAnswerText();
            switch (i) {
                case 0 -> answer1.setText(answerTitle);
                case 1 -> answer2.setText(answerTitle);
                case 2 -> {
                    answer3.setText(answerTitle);
                    answer3.setVisible(true);
                }
                case 3 -> {
                    answer4.setText(answerTitle);
                    answer4.setVisible(true);
                }
            }
        }
    }

    private void makeAnswerInvisible(){
       int numberOfAnswers = this.questionOrderController.getCurrentQuestion().getAnswers().size();
        for(int i = numberOfAnswers; i<4; i++){
            switch (i) {
                case 0 -> answer1.setVisible(false);
                case 1 -> answer2.setVisible(false);
                case 2 -> answer3.setVisible(false);
                case 3 -> answer4.setVisible(false);
            }
        }
    }
}
