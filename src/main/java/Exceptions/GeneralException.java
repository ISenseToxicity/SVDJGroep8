package Exceptions;

import controllers.ControllerRegistry;
import controllers.ExceptionController;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogEvent;

public class GeneralException extends Exception{
Alert alert = new Alert(Alert.AlertType.ERROR);
ExceptionController exceptionController = (ExceptionController) ControllerRegistry.get(ExceptionController.class);

public GeneralException(){
    alert.setTitle(String.valueOf(exceptionController.getStatus()));
    alert.setHeaderText(exceptionController.getErrorMessage()+exceptionController.getPath());
    alert.setContentText(exceptionController.getTrace());
    alert.setOnCloseRequest(exitAplication);
}

    private EventHandler<DialogEvent> exitAplication = event -> {
        System.exit(exceptionController.getStatus());
    };
}

