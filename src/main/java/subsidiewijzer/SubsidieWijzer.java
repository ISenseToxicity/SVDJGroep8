package subsidiewijzer;

import controllers.*;
import javafx.application.Application;
import javafx.stage.Stage;


public class SubsidieWijzer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Register all Controllers into ControllerRegistry
        ControllerRegistry.register(new AnswerController());
        ControllerRegistry.register(new ReformRequestController());
        ControllerRegistry.register(new RequestController());
        ControllerRegistry.register(new ResultController());
        ControllerRegistry.register(new RouteController());
        ControllerRegistry.register(new ApplicationController());
        ControllerRegistry.register(new CategoryListController());
        ControllerRegistry.register(new CategoryController());
        ControllerRegistry.register(new QuestionListController());
        ControllerRegistry.register(new QuestionOrderController());
        ControllerRegistry.register(new GivenAnswerController());
        ControllerRegistry.register(new FormController());
        ControllerRegistry.register(new GrantController());
        ControllerRegistry.register(new QuestionListController());
        ControllerRegistry.register(new QuestionController());



        ApplicationController applicationController = (ApplicationController) ControllerRegistry.get(ApplicationController.class);
        applicationController.setStage(primaryStage);
        applicationController.checkConnection();

    }
}

