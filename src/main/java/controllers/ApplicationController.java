package controllers;

import com.google.gson.JsonElement;
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
import models.Category;
import models.Grant;
import models.QuestionList;
import services.AnimationService;
import views.ApplicationView;

import java.util.ArrayList;

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

    public void checkConnection(){
        putNewGrant();
        RequestController requestController =(RequestController) ControllerRegistry.get(RequestController.class);
        if(requestController.establishConnection()){
            System.out.println("There is an Connection with the database established");
        }
        else{
            System.out.println("There is no Connection");

        }

    }

    public void putNewGrant(){
        RequestController requestController =(RequestController) ControllerRegistry.get(RequestController.class);
        ArrayList<Category> grants = new ArrayList<>();
                grants.add(new Category(9L,"number9","Alleen voor die die rijk willen wordden"));
         requestController.makeRequestWithCategory(grants, "","POST");
    }

}
