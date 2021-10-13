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

        beginButton.setOnMouseEntered(e -> enterButton(beginButton, beginLabel));
        beginButton.setOnMouseExited(e -> exitButton(beginButton, beginLabel));

        EventHandler<ActionEvent> event = actionEvent -> {
            Stage primaryStage = applicationView.getStage();
            FormController formController = (FormController) ControllerRegistry.get(FormController.class);
            formController.setStage(primaryStage);
        };

        beginButton.setOnAction(event);
    }


    private void background(Color bColor, Color tColor, Button button, javafx.scene.control.Label label) {
        button.setBackground(new Background(new BackgroundFill(bColor, CornerRadii.EMPTY, Insets.EMPTY)));
        button.setTextFill(tColor);
        BorderWidths svdjBorder = new BorderWidths(2, 2, 0, 0);
        Insets svdjInsets = new Insets(5, 0, 5, 10);
        label.setBorder(new Border(new BorderStroke(
                tColor,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                svdjBorder,
                svdjInsets)));
    }

    private void enterButton(Button button, Label label) {
        final Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(500));
                setInterpolator(Interpolator.EASE_OUT);
            }
            @Override
            protected void interpolate(double frac) {
                Color bColor = new Color(1, 1, 1, frac);
                Color tColor = new Color(0, 0, 0, frac);
                background(bColor, tColor, button, label);
            }
        };
        animation.play();
    }

    private void exitButton(Button button, Label label) {
        final Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(500));
                setInterpolator(Interpolator.EASE_OUT);
            }
            @Override
            protected void interpolate(double frac) {
                Color bColor = new Color(1, 1, 1, 1 - frac);
                Color tColor = new Color(1, 1, 1, frac);
                background(bColor, tColor, button, label);
            }
        };
        animation.play();

    }
}
