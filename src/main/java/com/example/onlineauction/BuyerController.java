package com.example.onlineauction;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BuyerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPaneRulesBuyer;

    @FXML
    private Label dateTimeLabel;

    @FXML
    private Button LotsButtonBuyer;

    @FXML
    private Button exitBuyerButton;

    @FXML
    private Button participationsBuyerButton;

    @FXML
    private Button rulesBuyerButton;

    @FXML
    void ExitBuyer(ActionEvent event) {
        System.exit(1);
    }

    @FXML
    void LotsBuyer(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("buyer/products-buyer.fxml"));
            AnchorPane newPane = fxmlLoader.load();
            AnchorPaneRulesBuyer.getChildren().setAll(newPane.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ParticipationsBuyer(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("buyer/participations-products-buyer.fxml"));
            AnchorPane newPane = fxmlLoader.load();
            AnchorPaneRulesBuyer.getChildren().setAll(newPane.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void RulesBuyer(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("buyer/rulesBuyer.fxml"));
            AnchorPane newPane = fxmlLoader.load();
            AnchorPaneRulesBuyer.getChildren().setAll(newPane.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        DateTimeUtil.setupDateTimeUpdate(dateTimeLabel);
    }

}
