package com.example.onlineauction.controller;

import com.example.onlineauction.model.Category;
import com.example.onlineauction.dao.CategoryDAO;
import com.example.onlineauction.DatabaseConnector;
import com.example.onlineauction.util.СonfirmationDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static com.example.onlineauction.util.AlertUtil.showAlert;

public class CategoryAdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPaneCategory;

    @FXML
    private TableView<Category> TableViewCategory;

    @FXML
    private Button addCategoryButton;

    @FXML
    private TableColumn<Category, String> col_nameCategory;

    @FXML
    private Button deleteCategoryButton;

    @FXML
    private Button editCategoryButton;

    @FXML
    private TextField nameCategoryField;

    private CategoryDAO categoryDAO;

    private ObservableList<Category> categoryList;

    @FXML
    void AddCategory(ActionEvent event) {
        String categoryName = nameCategoryField.getText();

        if (categoryName != null && !categoryName.isEmpty()) {
            // Проверка на уникальность имени категории
            if (isCategoryNameUnique(categoryName)) {
                Category category = new Category(0, categoryName);

                try {
                    categoryDAO.create(category);
                    showAlert(Alert.AlertType.CONFIRMATION, "Успешно", "Категория добавлена!");
                    nameCategoryField.clear();
                    loadCategories();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                // Имя категории уже существует, выполните действия для обработки этой ситуации
                showAlert(Alert.AlertType.WARNING, "Предупреждение", "Категория с таким именем уже существует!");
            }
        } else {
            // Поле ввода пустое, вывод предупреждения
            showAlert(Alert.AlertType.WARNING, "Предупреждение", "Введите имя категории!");
        }
    }

    private boolean isCategoryNameUnique(String categoryName) {
        try {
            List<Category> categories = categoryDAO.getAllCategories();
            for (Category category : categories) {
                if (category.getName().equalsIgnoreCase(categoryName)) {
                    return false; // Имя категории уже существует
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true; // Имя категории уникально
    }

    @FXML
    void EditCategory(ActionEvent actionEvent) {
        Category selectedCategory = TableViewCategory.getSelectionModel().getSelectedItem();

        if (selectedCategory != null) {
            String newName = nameCategoryField.getText();

            if (newName != null && !newName.isEmpty()) {
                selectedCategory.setName(newName);

                try {
                    categoryDAO.update(selectedCategory);
                    showAlert(Alert.AlertType.CONFIRMATION, "Успешно", "Категория отредактирована");
                    loadCategories();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            // Категория не выбрана, выполните действия для обработки этой ситуации
            showAlert(Alert.AlertType.WARNING, "Предупреждение", "Выберите категорию для редактирования");
        }
    }

    @FXML
    void DeleteCategory(ActionEvent event) {
        Category selectedCategory = TableViewCategory.getSelectionModel().getSelectedItem();

        if (selectedCategory != null) {
            try {
                if (categoryDAO.isCategoryUsed(selectedCategory.getId())) {
                    showAlert(Alert.AlertType.WARNING, "Предупреждение", "Невозможно удалить категорию, так как она уже использована хотя бы одним лотом");
                    return;
                }
                if (СonfirmationDialog.showConfirmationDialog(
                        "Предупреждение",
                        "Предупреждение!",
                        "Вы уверены, что хотите удалить категорию?",
                        "Удалить",
                        "Отмена"
                )) {
                    categoryDAO.delete(selectedCategory.getId());
                    showAlert(Alert.AlertType.CONFIRMATION, "Успешно", "Категория удалена");
                    loadCategories();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            // Категория не выбрана, выполните действия для обработки этой ситуации
            showAlert(Alert.AlertType.WARNING, "Предупреждение","Выберите категорию для удаления");
        }
    }

    @FXML
    void initialize() throws Exception {
        // Создание экземпляра CategoryDAO
        Connection connection = DatabaseConnector.ConnectDb();

        // Создание экземпляра CategoryDAO
        categoryDAO = new CategoryDAO(connection);

        // Инициализация колонки таблицы
        col_nameCategory.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        // Инициализация списка категорий и загрузка данных
        categoryList = FXCollections.observableArrayList();
        loadCategories();
        // Привязка списка категорий к таблице
        TableViewCategory.setItems(categoryList);
        // Обработка выбора элемента в таблице
        TableViewCategory.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                nameCategoryField.setText(newValue.getName());
            }
        });
    }

    private void loadCategories() {
        try {
            List<Category> categories = categoryDAO.getAllCategories();
            categoryList.clear();
            categoryList.addAll(categories);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
