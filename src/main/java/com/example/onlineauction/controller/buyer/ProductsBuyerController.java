package com.example.onlineauction.controller.buyer;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import com.example.onlineauction.DatabaseConnector;
import com.example.onlineauction.WindowsManager;
import com.example.onlineauction.constants.Role;
import com.example.onlineauction.controller.DetailProductsController;
import com.example.onlineauction.dao.CategoryDAO;
import com.example.onlineauction.dao.LotDAO;
import com.example.onlineauction.model.Category;
import com.example.onlineauction.model.Lot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ProductsBuyerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane AnchorPaneLotsBuyer;

    @FXML
    private TableView<Lot> TableViewLotsBuyer;

    @FXML
    private TableColumn<Lot, String> col_betBuyer;
    @FXML
    private TableColumn<Lot, Double> col_currentPriceLotsBuyer;

    @FXML
    private TableColumn<Lot, String> col_endDateLots;

    @FXML
    private TableColumn<Lot, String> col_nameLotsBuyer;

    @FXML
    private TableColumn<Lot, Double> col_startPriceLotsBuyer;

    @FXML
    private Button detailNBetButton;

    @FXML
    private ComboBox<Category> selectCategoriesBuyer;

    private DetailProductsController detailProductsController;
    private CategoryDAO categoryDAO;
    private LotDAO lotDAO;

    public void setDetailProductsController(DetailProductsController controller) {
        detailProductsController = controller;
    }

    @FXML
    void DetailNBet(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/onlineauction/AllUsers/details-products.fxml"));
        Parent root = loader.load();

        detailProductsController = loader.getController();
        detailProductsController.setProductsBuyerController(this);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Детали лота");
        stage.show();
    }

    @FXML
    void SelectCategories(ActionEvent event) {
        try {
            Category selectedCategory = selectCategoriesBuyer.getValue();
            List<Lot> lots = lotDAO.getLotsByCategory(selectedCategory.getId());
            TableViewLotsBuyer.getItems().clear();
            TableViewLotsBuyer.getItems().addAll(lots);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() throws Exception {
        Connection connection = DatabaseConnector.ConnectDb(); // Получаем подключение к базе данных
        categoryDAO = new CategoryDAO(connection);
        lotDAO = new LotDAO(connection);

        try {
            List<Category> categories = categoryDAO.getAllCategories();
            selectCategoriesBuyer.getItems().addAll(categories);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
