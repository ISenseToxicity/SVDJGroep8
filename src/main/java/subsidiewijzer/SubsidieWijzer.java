package subsidiewijzer;

import controllers.*;
import javafx.application.Application;
import javafx.stage.Stage;


public class SubsidieWijzer extends Application {

        public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
            // Register all Controllers into ControllerRegistry
        ControllerRegistry.register(new AnswerController());
        ControllerRegistry.register(new ApplicationController());
        ControllerRegistry.register(new CategoryController());
        ControllerRegistry.register(new FormController());
        ControllerRegistry.register(new GivenAnswerController());
        ControllerRegistry.register(new GrantController());
        ControllerRegistry.register(new QuestionListController());
        ControllerRegistry.register(new QuestionController());
        ControllerRegistry.register(new ReformRequestController());
        ControllerRegistry.register(new RequestController());
        ControllerRegistry.register(new ResultController());
        ControllerRegistry.register(new RouteController());


        ApplicationController applicationController = (ApplicationController) ControllerRegistry.get(ApplicationController.class);
        applicationController.setStage(primaryStage);

    }
}

