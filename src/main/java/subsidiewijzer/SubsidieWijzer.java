package subsidiewijzer;

import controllers.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;

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
        ControllerRegistry.register(new QuestionController());
        ControllerRegistry.register(new QuestionListController());
        ControllerRegistry.register(new ReformRequestController());
        ControllerRegistry.register(new RequestController());
        ControllerRegistry.register(new ResultController());
        ControllerRegistry.register(new RouteController());


        ApplicationController applicationController = (ApplicationController) ControllerRegistry.get(ApplicationController.class);
        applicationController.setStage(primaryStage);

        tempTestShit();

    }
    private void tempTestShit(){
        ArrayList<String> questionID = new ArrayList<>();
        ArrayList<String> questionText = new ArrayList<>();
        QuestionController questionController = new QuestionController();
        for(int i = 0; i<100; i++){
            questionID.add(String.valueOf(i));
            questionText.add(i + "TEXTNDOJNSGDHUFSDIGSKOGMDSJOFDISJKO{DSLPMFJOHSFUH");
        }
        questionController.setQuestionID(questionID);
        questionController.setQuestionText(questionText);
    }
}

