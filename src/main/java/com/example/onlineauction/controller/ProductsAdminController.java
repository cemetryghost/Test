package com.example.onlineauction.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class ProductsAdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPaneLotsAdmin;

    @FXML
    private TableView<?> TableViewAdminLots;

    @FXML
    private TableColumn<?, ?> col_categoryLotsAdmin;

    @FXML
    private TableColumn<?, ?> col_currentPriceLotsAdmin;

    @FXML
    private TableColumn<?, ?> col_nameLotsAdmin;

    @FXML
    private TableColumn<?, ?> col_startPriceLotsAdmin;

    @FXML
    private TableColumn<?, ?> col_statusLotsAdmin;

    @FXML
    private Button deleteLotsButton;

    @FXML
    private Button editLotsButton;

    @FXML
    private Button editStatusLotsButton;

    @FXML
    private Button moreDetailLots;

    @FXML
    private ComboBox<?> statusLotsComboBox;

    @FXML
    void DeleteLots(ActionEvent event) {

    }

    @FXML
    void EditLots(ActionEvent event) {

    }

    @FXML
    void EditStatusLots(ActionEvent event) {

    }

    @FXML
    void MoreInfoDetailsLots(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AnchorPaneLotsAdmin != null : "fx:id=\"AnchorPaneLotsAdmin\" was not injected: check your FXML file 'all-products-administrator.fxml'.";
        assert TableViewAdminLots != null : "fx:id=\"TableViewAdminLots\" was not injected: check your FXML file 'all-products-administrator.fxml'.";
        assert col_categoryLotsAdmin != null : "fx:id=\"col_categoryLotsAdmin\" was not injected: check your FXML file 'all-products-administrator.fxml'.";
        assert col_currentPriceLotsAdmin != null : "fx:id=\"col_currentPriceLotsAdmin\" was not injected: check your FXML file 'all-products-administrator.fxml'.";
        assert col_nameLotsAdmin != null : "fx:id=\"col_nameLotsAdmin\" was not injected: check your FXML file 'all-products-administrator.fxml'.";
        assert col_startPriceLotsAdmin != null : "fx:id=\"col_startPriceLotsAdmin\" was not injected: check your FXML file 'all-products-administrator.fxml'.";
        assert col_statusLotsAdmin != null : "fx:id=\"col_statusLotsAdmin\" was not injected: check your FXML file 'all-products-administrator.fxml'.";
        assert deleteLotsButton != null : "fx:id=\"deleteLotsButton\" was not injected: check your FXML file 'all-products-administrator.fxml'.";
        assert editLotsButton != null : "fx:id=\"editLotsButton\" was not injected: check your FXML file 'all-products-administrator.fxml'.";
        assert editStatusLotsButton != null : "fx:id=\"editStatusLotsButton\" was not injected: check your FXML file 'all-products-administrator.fxml'.";
        assert moreDetailLots != null : "fx:id=\"moreDetailLots\" was not injected: check your FXML file 'all-products-administrator.fxml'.";
        assert statusLotsComboBox != null : "fx:id=\"statusLotsComboBox\" was not injected: check your FXML file 'all-products-administrator.fxml'.";

    }

}
