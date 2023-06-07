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


    }

}
