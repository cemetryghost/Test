package com.example.onlineauction;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class RunApplication extends Application {
    @Override
    public void start(Stage stage)  {
        WindowsManager.openWindow("AllUsers/authorization.fxml", "Окно авторизации");
    }

    public static void main(String[] args) {
        launch();
    }
}