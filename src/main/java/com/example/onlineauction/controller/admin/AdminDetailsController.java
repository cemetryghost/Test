package com.example.onlineauction.controller.admin;

import com.example.onlineauction.DatabaseConnector;
import com.example.onlineauction.controller.seller.ProductsSellerController;
import com.example.onlineauction.dao.CategoryDAO;
import com.example.onlineauction.dao.LotDAO;
import com.example.onlineauction.dao.UserDAO;
import com.example.onlineauction.model.Lot;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDetailsController implements Initializable {

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Lot lot = ProductsAdminController.lot;

        try{
            UserDAO userDAO = new UserDAO(DatabaseConnector.ConnectDb());
            LotDAO lotDAO = new LotDAO(DatabaseConnector.ConnectDb());

            Lot selectedLot = lotDAO.getLotById(lot.getId());

            nameLotsLabel.setText(selectedLot.getName());
            descriptionLotsLabel.setText(selectedLot.getDescription());
            sellerLotsLabel.setText(userDAO.getNameAndSurnameById(selectedLot.getSellerId()));
            categoryLotsLabel.setText(CategoryDAO.getCategoryById(Integer.parseInt(selectedLot.getCategory())));
            startPriceLotsLabel.setText(String.valueOf(selectedLot.getStartPrice()));
            stepPriceLotsLabel.setText(String.valueOf(selectedLot.getStepPrice()));
            dateLotsLabel.setText(selectedLot.getDatepublicationDate());
            finishLotsLabel.setText(selectedLot.getDatelosingDate());
            conditionLotsLabel.setText(selectedLot.getCondition());
            statusLotsLabel.setText(selectedLot.getStatusString());
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
