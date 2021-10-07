package subsidiewijzer;

import controllers.*;
import javafx.application.Application;
import javafx.stage.Stage;
import views.StartView;

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
        StartView startView = new StartView();
        startView.setStage(primaryStage);
    }
}

