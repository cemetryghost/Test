package com.example.onlineauction;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class ProductsSellerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPaneLotsSeller;

    @FXML
    private Button addLotsSeller;

    @FXML
    private TableColumn<?, ?> col_categoryLotsSeller;

    @FXML
    private TableColumn<?, ?> col_currentPriceLotsSeller;

    @FXML
    private TableColumn<?, ?> col_nameLotsSeller;

    @FXML
    private TableColumn<?, ?> col_startPriceLotsSeller;

    @FXML
    private TableColumn<?, ?> col_statusLotsSeller;

    @FXML
    private Button deleteLotsSeller;

    @FXML
    private Button editLotsSeller;

    @FXML
    private Button finishLotsSeller;

    @FXML
    private Button moreDetailLots;

    @FXML
    private TableView<?> tableViewLotsSeller;

    @FXML
    void AddLotsSeller(ActionEvent event) {
        WindowsManager.openWindow("AllUsers/add-edit-products.fxml","Добавление лота");
    }

    @FXML
    void DeleteLotsSeller(ActionEvent event) {

    }

    @FXML
    void EditLotsSeller(ActionEvent event) {
        WindowsManager.openWindow("AllUsers/add-edit-products.fxml","Редактирование лота");
    }

    @FXML
    void FinishLotsSeller(ActionEvent event) {

    }

    @FXML
    void MoreInfoDetailsLots(ActionEvent event) {
        WindowsManager.openWindow("AllUsers/details-products.fxml","Детали лота");
    }

    @FXML
    void initialize() {

    }

}
