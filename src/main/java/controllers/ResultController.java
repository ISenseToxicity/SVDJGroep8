package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Category;
import models.Grant;
import services.AnimationService;
import views.ResultView;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class ResultController implements Controller {
    ResultView resultView = new ResultView();

    private final CategoryListController categoryListController = (CategoryListController) ControllerRegistry.get(CategoryListController.class);
    private final GrantController grantController = (GrantController) ControllerRegistry.get(GrantController.class);

    @FXML
    Label resultTitle;

    @FXML VBox grantBox;
    @FXML Label grantTitle;
    @FXML Label periodLabel;
    @FXML Label grantDescription;
    @FXML Button readMoreButton;
    @FXML Label readMoreLabel;

    @FXML VBox dataSourceBox;
    @FXML Label dataSourceLabel;
    @FXML Label dataSourceDescription;
    @FXML Button differentFundButton;
    @FXML Label differentFundLabel;

    @FXML Button downloadPDFButton;
    @FXML Label downloadPDFLabel;
    @FXML TextField emailField;
    @FXML Button sendResultButton;
    @FXML Label emailMessageLabel;

    @FXML HBox questionAnswerBox;
    @FXML Label questionTitle;
    @FXML Label questionAnswer;
    @FXML Label moreInfoButton;

    private Grant resultGrant;

    public void setStage(Stage primaryStage) {
        resultView.setStage(primaryStage);
    }

    @FXML
    public void initialize() {
        AnimationService.createButtonAnimation(readMoreButton, readMoreLabel);
        AnimationService.createButtonAnimation(differentFundButton, differentFundLabel);
        AnimationService.createButtonAnimation(downloadPDFButton, downloadPDFLabel);

        readMoreButton.setOnAction(e -> openGrantPage());

        // Open the web page for other Grant funds
//        differentFundButton.setOnAction(e -> );

        downloadPDFButton.setOnAction(e -> downloadPDF());
        sendResultButton.setOnAction(e -> sendResults());

        resultGrant = getFinalResult();

        if (resultGrant == null) {
            setOtherResult();
            return;
        }
        setGrantResult();
    }

    private Grant getFinalResult() {
        ArrayList<Grant> grantList = grantController.getAllGrants();
        ArrayList<String> activeCategoriesID = convertToIDArray(categoryListController.getActiveCategories());

        for (Grant grant : grantList) {
            ArrayList<String> grantCategoriesID = convertToIDArray(grant.getCategories());
            if (activeCategoriesID.containsAll(grantCategoriesID)) {
                return grant;
            }
        }
        return null;
    }

    private ArrayList<String> convertToIDArray(ArrayList<Category> categories) {
        ArrayList<String> categoriesID = new ArrayList<>();
        for (Category category : categories) {
            categoriesID.add(category.getId());
        }
        return categoriesID;
    }

    private void setGrantResult() {
        grantBox.setVisible(true);
        dataSourceBox.setVisible(false);

        grantTitle.setText(resultGrant.getName());
        periodLabel.setText(resultGrant.getPeriod());
        grantDescription.setText(resultGrant.getInfo());
    }

    private void setOtherResult() {
        grantBox.setVisible(false);
        dataSourceBox.setVisible(true);

        // TODO: Decide if we can add this quickly and import the right data from the right source.
        dataSourceLabel.setText("Sorry, maar helaas hebben we geen bijpassend Subsidie voor u gevonden");
        dataSourceDescription.setText("Hier onder staat een samenvatting van uw antwoorden op onze vragen. \n" +
                "Als u op de knop hier onder klikt krijgt u een verwijzing naar een ander fonds");
    }

    private void openGrantPage() {
        String grantName = resultGrant.getName().replace(' ', '-');
        String url = "https://www.svdj.nl/regeling/" + grantName;

        try {
            Desktop.getDesktop().browse(new URL(url).toURI());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void downloadPDF() {

    }

    private void sendResults() {

    }

}
