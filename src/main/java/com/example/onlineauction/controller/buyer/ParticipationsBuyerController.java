package com.example.onlineauction.controller.buyer;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.onlineauction.DatabaseConnector;
import com.example.onlineauction.controller.authentication.AuthorizationController;
import com.example.onlineauction.dao.BidDAO;
import com.example.onlineauction.dao.CategoryDAO;
import com.example.onlineauction.dao.UserDAO;
import com.example.onlineauction.model.Bid;
import com.example.onlineauction.model.Category;
import com.example.onlineauction.model.Lot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class ParticipationsBuyerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPaneparticipationsBuyer;

    @FXML
    private TableView<Lot> TableViewParticipationsBuyer;

    @FXML
    private TableColumn<?, ?> col_betParticipationsBuyer;

    @FXML
    private TableColumn<?, ?> col_currentPriceLotsParticipationsBuyer;

    @FXML
    private TableColumn<?, ?> col_nameLotsParticipationsBuyer;

    @FXML
    private TableColumn<?, ?> col_nameSellerLotsParticipationsBuyer;

    @FXML
    private TableColumn<?, ?> col_statusLotsParticipationsBuyer;

    @FXML
    private Label dateTimeField;

    @FXML
    void initialize() throws Exception{
//        assert AnchorPaneparticipationsBuyer != null : "fx:id=\"AnchorPaneparticipationsBuyer\" was not injected: check your FXML file 'participations-products-buyer.fxml'.";
//        assert TableViewParticipationsBuyer != null : "fx:id=\"TableViewParticipationsBuyer\" was not injected: check your FXML file 'participations-products-buyer.fxml'.";
//        assert col_betParticipationsBuyer != null : "fx:id=\"col_betParticipationsBuyer\" was not injected: check your FXML file 'participations-products-buyer.fxml'.";
//        assert col_currentPriceLotsParticipationsBuyer != null : "fx:id=\"col_currentPriceLotsParticipationsBuyer\" was not injected: check your FXML file 'participations-products-buyer.fxml'.";
//        assert col_nameLotsParticipationsBuyer != null : "fx:id=\"col_nameLotsParticipationsBuyer\" was not injected: check your FXML file 'participations-products-buyer.fxml'.";
//        assert col_nameSellerLotsParticipationsBuyer != null : "fx:id=\"col_nameSellerLotsParticipationsBuyer\" was not injected: check your FXML file 'participations-products-buyer.fxml'.";
//        assert col_statusLotsParticipationsBuyer != null : "fx:id=\"col_statusLotsParticipationsBuyer\" was not injected: check your FXML file 'participations-products-buyer.fxml'.";
//        assert dateTimeField != null : "fx:id=\"dateTimeField\" was not injected: check your FXML file 'participations-products-buyer.fxml'.";

        ObservableList<Lot> lotus = FXCollections.observableArrayList();
        UserDAO userDAO = new UserDAO(DatabaseConnector.ConnectDb());
        BidDAO bidDAO = new BidDAO(DatabaseConnector.ConnectDb());
        for(Lot lot : bidDAO.getLotsByBuyerid(AuthorizationController.userId)){
            lot.setMyBet(bidDAO.getBetByLotId(lot.getId(), AuthorizationController.userId));
            if(lot.getMyBet() != 0){
                lot.setSeller(userDAO.getNameAndSurnameById(lot.getSellerId()));
                lotus.add(lot);
            }
        }

        col_nameLotsParticipationsBuyer.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_currentPriceLotsParticipationsBuyer.setCellValueFactory(new PropertyValueFactory<>("currentPrice"));
        col_betParticipationsBuyer.setCellValueFactory(new PropertyValueFactory<>("myBet"));
        col_nameSellerLotsParticipationsBuyer.setCellValueFactory(new PropertyValueFactory<>("seller"));
        col_statusLotsParticipationsBuyer.setCellValueFactory(new PropertyValueFactory<>("statusString"));

        TableViewParticipationsBuyer.setItems(lotus);
    }

}
