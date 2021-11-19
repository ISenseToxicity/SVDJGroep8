package views;

import controllers.ControllerRegistry;
import controllers.ResultController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class ResultView implements PrimaryStage {

    private Stage primaryStage;

    public ResultView() {

    }

    private void createPrimaryStage() throws IOException {
        final int WIDTH = 1350;
        final int HEIGHT = 750;
        final String TITLE = "SVDJ - Subsidie Wijzer";
        final String ICONURL = "fxml/icons/icon_SVDJ.png";

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ResultView.fxml"));
        loader.setController(ControllerRegistry.get(ResultController.class));
        Parent root = loader.load();

        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.setMinWidth(WIDTH);
        primaryStage.setMinHeight(HEIGHT);
        primaryStage.setResizable(true);
        primaryStage.setTitle(TITLE);
        primaryStage.getIcons().add(new Image(ICONURL));

        primaryStage.show();
    }


    @Override
    public void setStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        try {
            createPrimaryStage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getStage() {
        return primaryStage;
    }

}
