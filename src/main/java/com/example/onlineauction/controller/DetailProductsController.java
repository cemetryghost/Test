package com.example.onlineauction.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.onlineauction.constants.Role;
import com.example.onlineauction.controller.buyer.ProductsBuyerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class DetailProductsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane PaneBettingBuyerVisible;

    @FXML
    private Button backDetailLots;

    @FXML
    private Button buyerBettingButton;

    @FXML
    private TextField buyerBettingField;

    @FXML
    private Label categoryLotsLabel;

    @FXML
    private Label conditionLotsLabel;

    @FXML
    private Label dateLotsLabel;

    @FXML
    private Label descriptionLotsLabel;

    @FXML
    private Label finishLotsLabel;

    @FXML
    private Label nameLotsLabel;

    @FXML
    private Label sellerLotsLabel;

    @FXML
    private Label startPriceLotsLabel;

    @FXML
    private Label statusLotsLabel;

    @FXML
    private Label stepPriceLotsLabel;

    private ProductsBuyerController productsBuyerController;

    public void setProductsBuyerController(ProductsBuyerController controller) {
        productsBuyerController = controller;
    }

    public void setRole(Role role) {
        boolean isBuyer = role == Role.BUYER;
        PaneBettingBuyerVisible.setVisible(isBuyer);
    }

    @FXML
    void BackDetail(ActionEvent event) {

    }

    @FXML
    void BuyerBet(ActionEvent event) {

    }

}
