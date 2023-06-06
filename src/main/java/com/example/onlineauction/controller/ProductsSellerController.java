package com.example.onlineauction.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.onlineauction.WindowsManager;
import com.example.onlineauction.constants.Role;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
        WindowsManager.openWindow("/com/example/onlineauction/AllUsers/add-edit-products.fxml","Добавление лота");
    }

    @FXML
    void DeleteLotsSeller(ActionEvent event) {

    }

    @FXML
    void EditLotsSeller(ActionEvent event) {
        WindowsManager.openWindow("/com/example/onlineauction/AllUsers/add-edit-products.fxml","Редактирование лота");
    }

    @FXML
    void FinishLotsSeller(ActionEvent event) {

    }

    @FXML
    void MoreInfoDetailsLots(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/onlineauction/AllUsers/details-products.fxml"));
        Parent root = loader.load();

        DetailProductsController detailProductsController = loader.getController();
        detailProductsController.setRole(Role.SELLER);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Детали лота");
        stage.show();
    }

    @FXML
    void initialize() {

    }

}
