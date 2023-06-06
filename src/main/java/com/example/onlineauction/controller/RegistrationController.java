package com.example.onlineauction.controller;

import com.example.onlineauction.*;
import com.example.onlineauction.constants.Role;
import com.example.onlineauction.constants.Status;
import com.example.onlineauction.dao.UserDAO;
import com.example.onlineauction.model.User;
import com.example.onlineauction.util.AlertUtil;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.stage.Stage;


public class RegistrationController {

    @FXML private JFXRadioButton buyerRadioButton;
    @FXML private DatePicker dateOfBirthField;
    @FXML private Button exitButtonRegistration;
    @FXML private TextField loginUserFieldReg;
    @FXML private TextField nameUserField;
    @FXML private PasswordField passwordUserFieldReg;
    @FXML private Button registrationButton;
    @FXML private JFXRadioButton sellerRadioButton;
    @FXML private TextField surnameUserField;

    @FXML
    void initialize() {
        // Настройка начального состояния элементов интерфейса
        buyerRadioButton.setSelected(false);
        sellerRadioButton.setSelected(false);
    }

    @FXML
    void ChoiceBuyer(ActionEvent event) {
        buyerRadioButton.setSelected(true);
        sellerRadioButton.setSelected(false);
    }

    @FXML
    void ChoiceSeller(ActionEvent event) {
        sellerRadioButton.setSelected(true);
        buyerRadioButton.setSelected(false);
    }

    @FXML
    void ExitRegistration(ActionEvent event) {
        System.exit(1);
    }

    @FXML
    void Registration(ActionEvent event) throws IOException, SQLException {
        String firstName = nameUserField.getText();
        String lastName = surnameUserField.getText();
        String username = loginUserFieldReg.getText();
        String password = passwordUserFieldReg.getText();
        LocalDate dateOfBirth = dateOfBirthField.getValue();

        // Проверка заполнения всех полей
        if (firstName.isEmpty() || lastName.isEmpty() || username.isEmpty() || password.isEmpty() || dateOfBirth == null) {
            showAlert(Alert.AlertType.ERROR, "Ошибка", "Заполните все поля");
            return;
        }

        // Получение текущей даты
        LocalDate currentDate = LocalDate.now();

        // Проверка возраста пользователя (18 лет и старше)
        if (dateOfBirth.isAfter(currentDate.minusYears(18))) {
            showAlert(Alert.AlertType.ERROR, "Ошибка!", "Принимать участия в аукционах можно только с 18 лет!");
            return;
        }

        Role role;
        if (buyerRadioButton.isSelected()) {
            role = Role.BUYER;
        } else if (sellerRadioButton.isSelected()) {
            role = Role.SELLER;
        } else {
            showAlert(Alert.AlertType.ERROR, "Ошибка", "Пожалуйста, выберите роль!");
            return;
        }

        // Создание нового пользователя
        User newUser = new User(firstName, lastName, username, password, dateOfBirth, role, Status.ACTIVE);

        // Установка соединения с базой данных
        Connection connection = null;
        try {
            connection = DatabaseConnector.ConnectDb();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Ошибка", "Ошибка соединения с базой данных");
            return;
        }

        // Инициализация UserDAO с передачей соединения
        UserDAO userDAO = new UserDAO(connection);

        try {
            if (userDAO.isUserExist(username)) {
                showAlert(Alert.AlertType.ERROR, "Ошибка регистрации", "Аккаунт с таким логином уже существует!");
                return;
            }
            // Сохранение пользователя в базе данных
            userDAO.saveUser(newUser);

            // Очистка полей ввода
            clearInputFields();

            showAlert(Alert.AlertType.INFORMATION, "Успешно", "Аккаунт зарегистрирован");

            // Проверка роли пользователя и открытие соответствующего окна
            if (role == Role.BUYER) {
                Stage stageCLose = (Stage) registrationButton.getScene().getWindow();
                stageCLose.close();

                WindowsManager.openWindow("/com/example/onlineauction/buyer/buyer-view.fxml","Окно покупателя");
            } else if (role == Role.SELLER) {
                Stage stageCLose = (Stage) registrationButton.getScene().getWindow();
                stageCLose.close();

                WindowsManager.openWindow("/com/example/onlineauction/seller/seller-view.fxml","Окно продавца");
            }
        } catch (SQLException e) {
            showAlert(Alert.AlertType.ERROR, "Ошибка", "Ошибка регистрации: " + e.getMessage());
        }
    }

    private void clearInputFields() {
        nameUserField.clear();
        surnameUserField.clear();
        loginUserFieldReg.clear();
        passwordUserFieldReg.clear();
        dateOfBirthField.setValue(null);
    }

    @FXML
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        AlertUtil.showAlert(alertType, title, message);
    }
}
