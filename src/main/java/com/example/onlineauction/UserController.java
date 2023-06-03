package com.example.onlineauction;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class UserController {

    @FXML private ResourceBundle resources;
    @FXML private Label dateTimeLabel;
    @FXML private URL location;
    @FXML private AnchorPane AnchorPaneAccountsAdmin;
    @FXML private TableView<?> TableViewAccounts;
    @FXML private Button blockAccountsButton;
    @FXML private TableColumn<?, ?> col_loginUser;
    @FXML private TableColumn<?, ?> col_nameUser;
    @FXML private TableColumn<?, ?> col_passwordUser;
    @FXML private TableColumn<?, ?> col_statusUser;
    @FXML private TableColumn<?, ?> col_surnameUser;
    @FXML private Button deleteAccountsButton;
    @FXML private Button unblockAccountsButton;

    @FXML
    void BlockAccounts(ActionEvent event) {

    }

    @FXML
    void DeleteAccounts(ActionEvent event) {

    }

    @FXML
    void UnblockAccounts(ActionEvent event) {

    }

    @FXML
    void initialize() {
        DateTimeUtil.setupDateTimeUpdate(dateTimeLabel);
    }

}
