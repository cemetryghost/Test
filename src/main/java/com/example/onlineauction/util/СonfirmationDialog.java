package com.example.onlineauction.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class СonfirmationDialog {
    public static boolean showConfirmationDialog(String title, String headerText, String contentText, String confirmButtonText, String cancelButtonText) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        ButtonType confirmButton = new ButtonType(confirmButtonText);
        ButtonType cancelButton = new ButtonType(cancelButtonText, ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(confirmButton, cancelButton);

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == confirmButton;
    }
}
