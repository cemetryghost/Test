package com.example.onlineauction;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class ProductsBuyerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPaneLotsBuyer;

    @FXML
    private TableView<?> TableViewLotsBuyer;

    @FXML
    private TableColumn<?, ?> col_betBuyer;

    @FXML
    private TableColumn<?, ?> col_ceurrentPriceLotsBuyer;

    @FXML
    private TableColumn<?, ?> col_endDateLots;

    @FXML
    private TableColumn<?, ?> col_nameLotsBuyer;

    @FXML
    private TableColumn<?, ?> col_startPriceLotsBuyer;

    @FXML
    private Button detailNBetButton;

    @FXML
    private ComboBox<?> selectCategoriesBuyer;

    @FXML
    void DetailNBet(ActionEvent event) {

    }

    @FXML
    void SelectCategories(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AnchorPaneLotsBuyer != null : "fx:id=\"AnchorPaneLotsBuyer\" was not injected: check your FXML file 'products-buyer.fxml'.";
        assert TableViewLotsBuyer != null : "fx:id=\"TableViewLotsBuyer\" was not injected: check your FXML file 'products-buyer.fxml'.";
        assert col_betBuyer != null : "fx:id=\"col_betBuyer\" was not injected: check your FXML file 'products-buyer.fxml'.";
        assert col_ceurrentPriceLotsBuyer != null : "fx:id=\"col_ceurrentPriceLotsBuyer\" was not injected: check your FXML file 'products-buyer.fxml'.";
        assert col_endDateLots != null : "fx:id=\"col_endDateLots\" was not injected: check your FXML file 'products-buyer.fxml'.";
        assert col_nameLotsBuyer != null : "fx:id=\"col_nameLotsBuyer\" was not injected: check your FXML file 'products-buyer.fxml'.";
        assert col_startPriceLotsBuyer != null : "fx:id=\"col_startPriceLotsBuyer\" was not injected: check your FXML file 'products-buyer.fxml'.";
        assert detailNBetButton != null : "fx:id=\"detailNBetButton\" was not injected: check your FXML file 'products-buyer.fxml'.";
        assert selectCategoriesBuyer != null : "fx:id=\"selectCategoriesBuyer\" was not injected: check your FXML file 'products-buyer.fxml'.";

    }

}
