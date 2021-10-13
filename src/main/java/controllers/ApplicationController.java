package controllers;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import services.AnimationService;
import views.ApplicationView;

public class ApplicationController implements Controller {

    ApplicationView applicationView = new ApplicationView();

    @FXML Button beginButton;
    @FXML Label beginLabel;

    public void setStage(Stage primaryStage) {
        applicationView.setStage(primaryStage);
    }

    @FXML
    private void initialize() {
        AnimationService.createButtonAnimation(beginButton, beginLabel);

        beginButton.setOnAction(e -> {
            Stage primaryStage = applicationView.getStage();
            FormController formController = (FormController) ControllerRegistry.get(FormController.class);
            formController.setStage(primaryStage);
        });
    }

}
