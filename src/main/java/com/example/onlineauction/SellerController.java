package com.example.onlineauction;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class SellerController {

    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button LotsSellerButton;
    @FXML private AnchorPane anchorPaneRulesSeller;
    @FXML private Label dateTimeLabel;
    @FXML private Button exitSellerButton;
    @FXML private Button rulesSellerButton;
    @FXML private Button winningSellerButton;
    private Timeline timeline;

    @FXML
    void ExitSeller(ActionEvent event) {
        System.exit(1);
    }

    @FXML
    void GoToSellerLots(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("seller/products-seller.fxml"));
            AnchorPane newPane = fxmlLoader.load();
            anchorPaneRulesSeller.getChildren().setAll(newPane.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void GoToSellerWinning(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("seller/finish-products-seller.fxml"));
            AnchorPane newPane = fxmlLoader.load();
            anchorPaneRulesSeller.getChildren().setAll(newPane.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void rulesSeller(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("seller/rulesSeller.fxml"));
            AnchorPane newPane = fxmlLoader.load();
            anchorPaneRulesSeller.getChildren().setAll(newPane.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        DateTimeUtil.setupDateTimeUpdate(dateTimeLabel);
    }
}
