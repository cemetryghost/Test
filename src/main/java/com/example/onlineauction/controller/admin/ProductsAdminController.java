package com.example.onlineauction.controller.admin;

import com.example.onlineauction.DatabaseConnector;
import com.example.onlineauction.WindowsManager;
import com.example.onlineauction.constants.StatusLot;
import com.example.onlineauction.dao.CategoryDAO;
import com.example.onlineauction.dao.LotDAO;
import com.example.onlineauction.dao.UserDAO;
import com.example.onlineauction.model.Category;
import com.example.onlineauction.model.Lot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    private ComboBox<String> statusLotsComboBox;
    private Lot lot;
    private int id;
    private LotDAO lotDAO;
    Connection connection = DatabaseConnector.ConnectDb();

    public ProductsAdminController() throws Exception {
    }

    @FXML
    void DeleteLots(ActionEvent event) throws Exception{
        lotDAO = new LotDAO(connection);
        lotDAO.delete(id);
        update();
    }

    @FXML
    void EditLots(ActionEvent event) {
        WindowsManager.openWindow("AllUsers/add-edit-products.fxml", "Редактирование лота");
    }

    @FXML
    void EditStatusLots(ActionEvent event) throws Exception{
        lotDAO = new LotDAO(connection);
        String newStatus = statusLotsComboBox.getSelectionModel().getSelectedItem();
        Lot lot = lotDAO.getLotById(id);
        if(newStatus.equals("Ожидает подтверждения")){
            lotDAO.updateLotStatus(lot.getId(), StatusLot.AWAITING_CONFIRMATION);

        }
        else if(newStatus.equals("Завершен")){
            lotDAO.updateLotStatus(lot.getId(), StatusLot.COMPLETED);
        }
        else if(newStatus.equals("Активный")){
            lotDAO.updateLotStatus(lot.getId(), StatusLot.ACTIVE);
        }

        update();
    }

    @FXML
    void MoreInfoDetailsLots(ActionEvent event) {
        // Обработчик события просмотра подробной информации о лоте
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        update();
    }
    public void update(){
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
        col_statusLotsAdmin.setCellValueFactory(new PropertyValueFactory<>("statusString"));

        // Заполнение ComboBox статусами лотов
        List<Lot> lots = null; // Предположим, что у вас есть метод getAllLots() в LotDAO
        ObservableList<String> status = FXCollections.observableArrayList("Ожидает подтверждения", "Активный", "Завершен");
        ObservableList<Lot> lotus = FXCollections.observableArrayList();
        try {
            lots = lotDAO.getAllLots();
            for(Lot lot : lots){
                lotus.add(lot);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        TableViewAdminLots.setItems(lotus);
        statusLotsComboBox.setItems(status);
    }

    public void getSelected(MouseEvent mouseEvent) {
        lot = TableViewAdminLots.getSelectionModel().getSelectedItem();
        id = lot.getId();
        System.out.println(id);
    }
}

