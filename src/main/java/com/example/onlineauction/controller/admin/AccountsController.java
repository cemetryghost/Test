package com.example.onlineauction.controller.admin;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import com.example.onlineauction.DatabaseConnector;
import com.example.onlineauction.model.User;
import com.example.onlineauction.dao.UserDAO;
import com.example.onlineauction.util.СonfirmationDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import static com.example.onlineauction.util.AlertUtil.showAlert;

public class AccountsController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private Label dateTimeLabel;
    @FXML
    private URL location;
    @FXML
    private AnchorPane AnchorPaneAccountsAdmin;

    @FXML private TableView<User> TableViewAccounts;

    @FXML
    private Button blockAccountsButton;
    @FXML
    private TableColumn<User, String> col_loginUser;
    @FXML
    private TableColumn<User, String> col_roleUser;
    @FXML
    private TableColumn<User, String> col_nameUser;
    @FXML
    private TableColumn<User, String> col_passwordUser;
    @FXML
    private TableColumn<User, String> col_statusUser;
    @FXML
    private TableColumn<User, String> col_surnameUser;
    @FXML
    private Button deleteAccountsButton;
    @FXML
    private Button unblockAccountsButton;
    private UserDAO userDAO;

    @FXML
    void BlockAccounts(ActionEvent event) {
        User selectedUser = TableViewAccounts.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            try {
                showAlert(Alert.AlertType.CONFIRMATION, "Успешно", "Аккаунт заблокирован");
                userDAO.blockUser(selectedUser.getId());
                refreshUserList();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            showAlert(Alert.AlertType.WARNING, "Предупреждение", "Выберите аккаунт для блокироваки!");
        }
    }

    @FXML
    void DeleteAccounts(ActionEvent event) {
        User selectedUser = TableViewAccounts.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            if (СonfirmationDialog.showConfirmationDialog(
                    "Предупреждение",
                    "Предупреждение!",
                    "Удаление аккаунта приводит к полному удалению всех данных, относящихся к нему! Вы уверены, что хотите продолжить?",
                    "Удалить аккаунт",
                    "Отмена"
            )) {
                try {
                    userDAO.deleteUser(selectedUser.getId());
                    showAlert(Alert.AlertType.INFORMATION, "Информация", "Аккаунт был успешно удален.");
                    refreshUserList();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            showAlert(Alert.AlertType.WARNING, "Предупреждение", "Выберите аккаунт удаления!");
        }
    }

    @FXML
    void UnblockAccounts(ActionEvent event) {
        User selectedUser = TableViewAccounts.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            try {
                showAlert(Alert.AlertType.CONFIRMATION, "Успешно", "Аккаунт разблокирован");
                userDAO.unblockUser(selectedUser.getId());
                refreshUserList();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            showAlert(Alert.AlertType.WARNING, "Предупреждение", "Выберите аккаунт для разблокирования!");
        }
    }

    @FXML
    void initialize() throws Exception {
        Connection connection = DatabaseConnector.ConnectDb(); // Получаем соединение с базой данных
        userDAO = new UserDAO(connection); // Создаем экземпляр UserDAO с переданным соединением

        try {
            List<User> userList = userDAO.getAllUsers();

            col_loginUser.setCellValueFactory(new PropertyValueFactory<>("login"));
            col_nameUser.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_surnameUser.setCellValueFactory(new PropertyValueFactory<>("surname"));
            col_passwordUser.setCellValueFactory(new PropertyValueFactory<>("password"));
            col_statusUser.setCellValueFactory(new PropertyValueFactory<>("status"));
            col_roleUser.setCellValueFactory(new PropertyValueFactory<>("role"));

            ObservableList<User> users = FXCollections.observableArrayList(userList);
            TableViewAccounts.setItems(users);
        } catch (SQLException e) {
            e.printStackTrace();
            // Обработайте исключение по необходимости
        }
    }

    private void refreshUserList() {
        try {
            List<User> userList = userDAO.getAllUsers();
            ObservableList<User> users = FXCollections.observableArrayList(userList);
            TableViewAccounts.setItems(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
