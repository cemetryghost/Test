package com.example.onlineauction;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CategoryAdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPaneCategory;

    @FXML
    private TableView<?> TableViewCategory;

    @FXML
    private Button addCategoryButton;

    @FXML
    private TableColumn<?, ?> col_nameCategory;

    @FXML
    private Button deleteCategoryButton;

    @FXML
    private Button editCategoryButton;

    @FXML
    private TextField nameCategoryField;

    @FXML
    void AddCategory(ActionEvent event) {

    }

    @FXML
    void DeleteCategory(ActionEvent event) {

    }

    @FXML
    void EditGategory(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert AnchorPaneCategory != null : "fx:id=\"AnchorPaneCategory\" was not injected: check your FXML file 'category-view.fxml'.";
        assert TableViewCategory != null : "fx:id=\"TableViewCategory\" was not injected: check your FXML file 'category-view.fxml'.";
        assert addCategoryButton != null : "fx:id=\"addCategoryButton\" was not injected: check your FXML file 'category-view.fxml'.";
        assert col_nameCategory != null : "fx:id=\"col_nameCategory\" was not injected: check your FXML file 'category-view.fxml'.";
        assert deleteCategoryButton != null : "fx:id=\"deleteCategoryButton\" was not injected: check your FXML file 'category-view.fxml'.";
        assert editCategoryButton != null : "fx:id=\"editCategoryButton\" was not injected: check your FXML file 'category-view.fxml'.";
        assert nameCategoryField != null : "fx:id=\"nameCategoryField\" was not injected: check your FXML file 'category-view.fxml'.";

    }

}
