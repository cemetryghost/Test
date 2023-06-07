package com.example.onlineauction.controller.admin;

import com.example.onlineauction.DatabaseConnector;
import com.example.onlineauction.constants.StatusLot;
import com.example.onlineauction.dao.CategoryDAO;
import com.example.onlineauction.dao.LotDAO;
import com.example.onlineauction.dao.UserDAO;
import com.example.onlineauction.model.Lot;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ProductsAdminController implements Initializable {

    @FXML
    private AnchorPane AnchorPaneLotsAdmin;

    @FXML
    private TableView<Lot> TableViewAdminLots;

    @FXML
    private TableColumn<Lot, String> col_categoryLotsAdmin;

    @FXML
    private TableColumn<Lot, Double> col_currentPriceLotsAdmin;

    @FXML
    private TableColumn<Lot, String> col_nameLotsAdmin;

    @FXML
    private TableColumn<Lot, Double> col_startPriceLotsAdmin;

    @FXML
    private TableColumn<Lot, String> col_statusLotsAdmin;

    @FXML
    private Button deleteLotsButton;

    @FXML
    private Button editLotsButton;

    @FXML
    private Button editStatusLotsButton;

    @FXML
    private Button moreDetailLots;

    @FXML
    private ComboBox<StatusLot> statusLotsComboBox;

    @FXML
    void DeleteLots(ActionEvent event) {
        // Обработчик события удаления лота
    }

    @FXML
    void EditLots(ActionEvent event) {
        // Обработчик события редактирования лота
    }

    @FXML
    void EditStatusLots(ActionEvent event) {
        // Обработчик события редактирования статуса лота
    }

    @FXML
    void MoreInfoDetailsLots(ActionEvent event) {
        // Обработчик события просмотра подробной информации о лоте
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Инициализация при загрузке FXML-файла

        Connection connection = null;
        try {
            connection = DatabaseConnector.ConnectDb();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Создание экземпляра CategoryDAO
        LotDAO lotDAO = new LotDAO(connection);
        UserDAO userDAO = new UserDAO(connection);

        // Установка соответствия между полями класса Lot и столбцами таблицы
        col_nameLotsAdmin.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_categoryLotsAdmin.setCellValueFactory(new PropertyValueFactory<>("category"));
        col_startPriceLotsAdmin.setCellValueFactory(new PropertyValueFactory<>("startPrice"));
        col_currentPriceLotsAdmin.setCellValueFactory(new PropertyValueFactory<>("currentPrice"));
        col_statusLotsAdmin.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Заполнение ComboBox статусами лотов
        List<Lot> lots = null; // Предположим, что у вас есть метод getAllLots() в LotDAO
        try {
            lots = lotDAO.getAllLots();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        TableViewAdminLots.setItems(FXCollections.observableArrayList(lots));
    }
}

