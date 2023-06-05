package com.example.onlineauction;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
            Category category = new Category(0, categoryName);

            try {
                categoryDAO.create(category);
                nameCategoryField.clear();
                loadCategories();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void DeleteCategory(ActionEvent event) {
        Category selectedCategory = TableViewCategory.getSelectionModel().getSelectedItem();

        if (selectedCategory != null) {
            try {
                categoryDAO.delete(selectedCategory.getId());
                loadCategories();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

    public void EditGategory(ActionEvent actionEvent) {
        Category selectedCategory = TableViewCategory.getSelectionModel().getSelectedItem();

        if (selectedCategory != null) {
            String newName = nameCategoryField.getText();

            if (newName != null && !newName.isEmpty()) {
                selectedCategory.setName(newName);

                try {
                    categoryDAO.update(selectedCategory);
                    loadCategories();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
