package com.example.onlineauction.controller.seller;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.onlineauction.DatabaseConnector;
import com.example.onlineauction.dao.LotDAO;
import com.example.onlineauction.model.Lot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import com.example.onlineauction.dao.UserDAO;
import com.example.onlineauction.model.User;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class FinishesLotsSellerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPaneWinningSeller;

    @FXML
    private TableView<Lot> TableViewFinishesLots;

    @FXML
    private TableColumn<Lot, String> col_PriceLotsFinish;

    @FXML
    private TableColumn<Lot, String> col_categoryLotsFinish;

    @FXML
    private TableColumn<Lot, String> col_finalStatusLotsFinish;

    @FXML
    private TableColumn<Lot, String> col_nameBuyerLotsFinish;

    @FXML
    private TableColumn<Lot, String> col_nameLotsFinish;

    @FXML
    void initialize() throws Exception{
        LotDAO lotDAO = new LotDAO(DatabaseConnector.ConnectDb());
        ProductsSellerController.closeLots = lotDAO.getInactiveLots();
//        assert AnchorPaneWinningSeller != null : "fx:id=\"AnchorPaneWinningSeller\" was not injected: check your FXML file 'finish-products-seller.fxml'.";
//        assert TableViewFinishesLots != null : "fx:id=\"TableViewFinishesLots\" was not injected: check your FXML file 'finish-products-seller.fxml'.";
//        assert col_PriceLotsFinish != null : "fx:id=\"col_PriceLotsFinish\" was not injected: check your FXML file 'finish-products-seller.fxml'.";
//        assert col_categoryLotsFinish != null : "fx:id=\"col_categoryLotsFinish\" was not injected: check your FXML file 'finish-products-seller.fxml'.";
//        assert col_finalStatusLotsFinish != null : "fx:id=\"col_finalStatusLotsFinish\" was not injected: check your FXML file 'finish-products-seller.fxml'.";
//        assert col_nameBuyerLotsFinish != null : "fx:id=\"col_nameBuyerLotsFinish\" was not injected: check your FXML file 'finish-products-seller.fxml'.";
//        assert col_nameLotsFinish != null : "fx:id=\"col_nameLotsFinish\" was not injected: check your FXML file 'finish-products-seller.fxml'.";
        col_nameLotsFinish.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_categoryLotsFinish.setCellValueFactory(new PropertyValueFactory<>("category"));
        col_PriceLotsFinish.setCellValueFactory(new PropertyValueFactory<>("currentPrice"));
        col_nameBuyerLotsFinish.setCellValueFactory(new PropertyValueFactory<>("buyerId"));
        col_finalStatusLotsFinish.setCellValueFactory(new PropertyValueFactory<>("statusString"));

        ObservableList<Lot> lots = FXCollections.observableArrayList(ProductsSellerController.closeLots);
        TableViewFinishesLots.setItems(lots);
    }

}
