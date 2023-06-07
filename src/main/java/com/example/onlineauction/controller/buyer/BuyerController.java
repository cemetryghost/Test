package com.example.onlineauction.controller.buyer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.onlineauction.util.DateTimeUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/onlineauction/buyer/products-buyer.fxml"));
            AnchorPane newPane = fxmlLoader.load();
            AnchorPaneRulesBuyer.getChildren().setAll(newPane.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ParticipationsBuyer(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/onlineauction/buyer/participations-products-buyer.fxml"));
            AnchorPane newPane = fxmlLoader.load();
            AnchorPaneRulesBuyer.getChildren().setAll(newPane.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void RulesBuyer(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/onlineauction/buyer/rulesBuyer.fxml"));
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
