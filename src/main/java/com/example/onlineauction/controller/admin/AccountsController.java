package com.example.onlineauction.controller.admin;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import com.example.onlineauction.DatabaseConnector;
import com.example.onlineauction.constants.Role;
import com.example.onlineauction.constants.Status;
import com.example.onlineauction.model.User;
import com.example.onlineauction.dao.UserDAO;
import com.example.onlineauction.util.СonfirmationDialog;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.transformation.FilteredList;
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
            if (!selectedUser.getLogin().equals("admin")) {
                try {
                    showAlert(Alert.AlertType.CONFIRMATION, "Успешно", "Аккаунт заблокирован");
                    userDAO.blockUser(selectedUser.getId());
                    refreshUserList();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                showAlert(Alert.AlertType.WARNING, "Предупреждение", "Блокировка аккаунта администратора невозможна!");
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Предупреждение", "Выберите аккаунт для блокировки!");
        }
    }

    @FXML
    void DeleteAccounts(ActionEvent event) {
        User selectedUser = TableViewAccounts.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            if (!selectedUser.getLogin().equals("admin")) { // Добавленная проверка
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
            } else {
                showAlert(Alert.AlertType.WARNING, "Предупреждение", "Удаление данного аккаунта запрещено!");
            }
        } else {
            showAlert(Alert.AlertType.WARNING, "Предупреждение", "Выберите аккаунт для удаления!");
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
        Connection connection = DatabaseConnector.ConnectDb();
        userDAO = new UserDAO(connection);

        try {
            List<User> userList = userDAO.getAllUsers();

            col_loginUser.setCellValueFactory(new PropertyValueFactory<>("login"));
            col_nameUser.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_surnameUser.setCellValueFactory(new PropertyValueFactory<>("surname"));
            col_passwordUser.setCellValueFactory(new PropertyValueFactory<>("password"));

            col_statusUser.setCellValueFactory(cellData -> {
                Status status = cellData.getValue().getStatus();
                String russianStatus = getStatusRussian(String.valueOf(status));
                return new SimpleStringProperty(russianStatus);
            });

            col_roleUser.setCellValueFactory(cellData -> {
                Role role = cellData.getValue().getRole();
                String russianRole = getRoleRussian(String.valueOf(role));
                return new SimpleStringProperty(russianRole);
            });

            ObservableList<User> users = FXCollections.observableArrayList(userList);
            TableViewAccounts.setItems(users);

            // Создаем фильтрованный список
            FilteredList<User> filteredList = new FilteredList<>(users);
            filteredList.setPredicate(user -> !user.getLogin().equals("unknown"));

            // Устанавливаем фильтрованный список в качестве элементов для отображения в TableView
            TableViewAccounts.setItems(filteredList);
        } catch (SQLException e) {
            e.printStackTrace();
            // Обработайте исключение по необходимости
        }
    }

    private String getRoleRussian(String role) {
        if (role.equals("ADMIN")) {
            return "Админ";
        } else if (role.equals("BUYER")) {
            return "Покупатель";
        } else if (role.equals("SELLER")) {
            return "Продавец";
        } else {
            return "Неизвестная роль";
        }
    }

    private String getStatusRussian(String status) {
        if (status.equals("ACTIVE")) {
            return "Активный";
        } else if (status.equals("BLOCK")) {
            return "Заблокирован";
        } else {
            return "Неизвестный статус";
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
