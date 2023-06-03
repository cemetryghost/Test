package com.example.onlineauction;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class ParticipationsBuyerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPaneparticipationsBuyer;

    @FXML
    private TableView<?> TableViewParticipationsBuyer;

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
    void initialize() {
        assert AnchorPaneparticipationsBuyer != null : "fx:id=\"AnchorPaneparticipationsBuyer\" was not injected: check your FXML file 'participations-products-buyer.fxml'.";
        assert TableViewParticipationsBuyer != null : "fx:id=\"TableViewParticipationsBuyer\" was not injected: check your FXML file 'participations-products-buyer.fxml'.";
        assert col_betParticipationsBuyer != null : "fx:id=\"col_betParticipationsBuyer\" was not injected: check your FXML file 'participations-products-buyer.fxml'.";
        assert col_currentPriceLotsParticipationsBuyer != null : "fx:id=\"col_currentPriceLotsParticipationsBuyer\" was not injected: check your FXML file 'participations-products-buyer.fxml'.";
        assert col_nameLotsParticipationsBuyer != null : "fx:id=\"col_nameLotsParticipationsBuyer\" was not injected: check your FXML file 'participations-products-buyer.fxml'.";
        assert col_nameSellerLotsParticipationsBuyer != null : "fx:id=\"col_nameSellerLotsParticipationsBuyer\" was not injected: check your FXML file 'participations-products-buyer.fxml'.";
        assert col_statusLotsParticipationsBuyer != null : "fx:id=\"col_statusLotsParticipationsBuyer\" was not injected: check your FXML file 'participations-products-buyer.fxml'.";
        assert dateTimeField != null : "fx:id=\"dateTimeField\" was not injected: check your FXML file 'participations-products-buyer.fxml'.";

    }

}
