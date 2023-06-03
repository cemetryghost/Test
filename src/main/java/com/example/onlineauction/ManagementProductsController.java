package com.example.onlineauction;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import com.example.onlineauction.CategoryDAO;
import com.example.onlineauction.LotDAO;
import com.example.onlineauction.DatabaseConnector;
import com.example.onlineauction.Category;
import com.example.onlineauction.Lot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ManagementProductsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButtonManageLots;

    @FXML
    private ComboBox<Category> categoryComboBox;

    @FXML
    private DatePicker dateFinish;

    @FXML
    private DatePicker datePublication;

    @FXML
    private TextArea descriptionLotsArea;

    @FXML
    private TextField nameLotsField;

    @FXML
    private Button saveButtonManageLots;

    @FXML
    private TextField sellerField;

    @FXML
    private TextField startPriceField;

    @FXML
    private TextField stepPriceField;

    @FXML
    private TextField conditionField;

    private CategoryDAO categoryDAO;
    private LotDAO lotDAO;

    @FXML
    void BackManageLots(ActionEvent event) {

    }

    @FXML
    void SaveManageLots(ActionEvent event) {
        String name = nameLotsField.getText();
        String description = descriptionLotsArea.getText();
        LocalDate publicationDate = datePublication.getValue();
        LocalDate finishDate = dateFinish.getValue();
        double startPrice = Double.parseDouble(startPriceField.getText());
        double stepPrice = Double.parseDouble(stepPriceField.getText());
        String condition = conditionField.getText();

        Category selectedCategory = categoryComboBox.getValue();
        int categoryId = selectedCategory.getId();

        // Создаем объект лота
        Lot lot = new Lot(name, description, startPrice, startPrice, stepPrice, publicationDate.toString(), finishDate.toString(), condition);

        // Получаем идентификатор продавца
        int sellerId = lot.getSellerId();

        lot.setSellerId(sellerId);
        lot.setCategoryId(categoryId);

        // Сохраняем лот в базе данных
        try {
            lotDAO.create(lot);
            System.out.println("Лот успешно сохранен в базе данных.");
        } catch (SQLException e) {
            e.printStackTrace();
            // Обработка ошибки сохранения лота
        }
    }

    @FXML
    void initialize() {
        try {
            Connection connection = DatabaseConnector.ConnectDb(); // Получаем подключение к базе данных
            categoryDAO = new CategoryDAO(connection);
            lotDAO = new LotDAO(connection);

            // Заполняем ComboBox категориями из базы данных
            ObservableList<Category> categories = FXCollections.observableArrayList(categoryDAO.getAllCategories());
            categoryComboBox.setItems(categories);
        } catch (Exception e) {
            e.printStackTrace();
            // Обработка ошибки подключения к базе данных
        }
    }

}
