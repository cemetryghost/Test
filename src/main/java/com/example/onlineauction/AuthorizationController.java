package com.example.onlineauction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static com.example.onlineauction.AlertUtil.showAlert;

public class AuthorizationController {

    @FXML
    private Button authorizationButtonUser;

    @FXML
    private Button exitButtonAuthorization;

    @FXML
    private Button goToRegistrationButton;

    @FXML
    private TextField loginUserFieldAuth;

    @FXML
    private PasswordField passwordUserFieldAuth;

    private int userId;


    @FXML
    void Authorization(ActionEvent event) throws Exception {
        String login = loginUserFieldAuth.getText();
        String password = passwordUserFieldAuth.getText();

        // Проверка заполнения полей логина и пароля
        if (login.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Ошибка", "Пожалуйста, заполните все поля.");
            return;
        }

        Connection connection = DatabaseConnector.ConnectDb();
        UserDAO userDAO = new UserDAO(connection);

        try {
            // Проверка аутентификации пользователя
            User.Role userRole = userDAO.getUserRole(login, password);
            if (userRole != null) {
                // Аутентификация успешна
                String fxmlPath;
                String title;
                switch (userRole) {
                    case BUYER:
                        fxmlPath = "buyer/buyer-view.fxml";
                        title = "Окно покупателя";
                        break;
                    case SELLER:
                        fxmlPath = "seller/seller-view.fxml";
                        title = "Окно продавца";
                        break;
                    case ADMIN:
                        fxmlPath = "administrator/administrator-view.fxml";
                        title = "Окно администратора";
                        break;
                    default:
                        return;
                }
                WindowsManager.openWindow(fxmlPath, title);
                Stage stageCLose = (Stage) goToRegistrationButton.getScene().getWindow();
                stageCLose.close();
            } else {
                // Неверные учетные данные
                showAlert(Alert.AlertType.ERROR, "Ошибка", "Неверный логин или пароль.");
            }
        } catch (SQLException e) {
            // Обработка ошибки
            showAlert(Alert.AlertType.ERROR, "Ошибка", "Ошибка при выполнении запроса к базе данных.");
            e.printStackTrace();
        }
    }

    @FXML
    void ExitAuthorization(ActionEvent event) throws IOException {
        System.exit(1);
    }

    @FXML
    void GoToRegistraton(ActionEvent event) throws IOException {
        Stage stageCLose = (Stage) goToRegistrationButton.getScene().getWindow();
        stageCLose.close();
        WindowsManager.openWindow("AllUsers/registration-view.fxml", "Окно регистрации");
    }

    @FXML
    void initialize() {

    }

}
