package com.example.onlineauction.controller.seller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class FinishesLotsSellerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPaneWinningSeller;

    @FXML
    private TableView<?> TableViewFinishesLots;

    @FXML
    private TableColumn<?, ?> col_PriceLotsFinish;

    @FXML
    private TableColumn<?, ?> col_categoryLotsFinish;

    @FXML
    private TableColumn<?, ?> col_finalStatusLotsFinish;

    @FXML
    private TableColumn<?, ?> col_nameBuyerLotsFinish;

    @FXML
    private TableColumn<?, ?> col_nameLotsFinish;

    @FXML
    void initialize() {
        assert AnchorPaneWinningSeller != null : "fx:id=\"AnchorPaneWinningSeller\" was not injected: check your FXML file 'finish-products-seller.fxml'.";
        assert TableViewFinishesLots != null : "fx:id=\"TableViewFinishesLots\" was not injected: check your FXML file 'finish-products-seller.fxml'.";
        assert col_PriceLotsFinish != null : "fx:id=\"col_PriceLotsFinish\" was not injected: check your FXML file 'finish-products-seller.fxml'.";
        assert col_categoryLotsFinish != null : "fx:id=\"col_categoryLotsFinish\" was not injected: check your FXML file 'finish-products-seller.fxml'.";
        assert col_finalStatusLotsFinish != null : "fx:id=\"col_finalStatusLotsFinish\" was not injected: check your FXML file 'finish-products-seller.fxml'.";
        assert col_nameBuyerLotsFinish != null : "fx:id=\"col_nameBuyerLotsFinish\" was not injected: check your FXML file 'finish-products-seller.fxml'.";
        assert col_nameLotsFinish != null : "fx:id=\"col_nameLotsFinish\" was not injected: check your FXML file 'finish-products-seller.fxml'.";

    }

}
