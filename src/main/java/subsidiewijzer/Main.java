package subsidiewijzer;

import controllers.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.Route;

public class Main extends Application {

        public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
            // Register all Controllers into ControllerRegistry
        ControllerRegistry.register(new AdminPanelController());
        ControllerRegistry.register(new AnswerController());
        ControllerRegistry.register(new ApplicatieController());
        ControllerRegistry.register(new CategoryController());
        ControllerRegistry.register(new EndController());
        ControllerRegistry.register(new GivenAnswerController());
        ControllerRegistry.register(new InfoPopupController());
        ControllerRegistry.register(new QuestionController());
        ControllerRegistry.register(new RouteController());
        ControllerRegistry.register(new StartController());
        ControllerRegistry.register(new SubsidieController());

        // Hello world
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}

