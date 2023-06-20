package com.example.onlineauction.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.example.onlineauction.*;
import com.example.onlineauction.constants.Role;
import com.example.onlineauction.controller.authentication.AuthorizationController;
import com.example.onlineauction.controller.authentication.RegistrationController;
import com.example.onlineauction.controller.seller.ProductsSellerController;
import com.example.onlineauction.dao.CategoryDAO;
import com.example.onlineauction.dao.LotDAO;
import com.example.onlineauction.dao.UserDAO;
import com.example.onlineauction.model.Category;
import com.example.onlineauction.model.Lot;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import static com.example.onlineauction.util.AlertUtil.showAlert;

public class ManagementProductsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backButtonManageLots;

    private static final Logger LOGGER = Logger.getLogger(ManagementProductsController.class.getName());

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
    private TextField startPriceField;

    @FXML
    private TextField stepPriceField;

    @FXML
    private TextField conditionField;
    @FXML
    private ImageView backButton;

    private CategoryDAO categoryDAO = new CategoryDAO();
    private UserDAO userDAO;
    private int userId;
    private LotDAO lotDAO;
    public static int sellerId;

    private ProductsSellerController productsSellerController;

    public void setProductsSellerController(ProductsSellerController controller) {
        this.productsSellerController = controller;
    }

    public Lot lot = ProductsSellerController.lot;

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public ManagementProductsController() throws SQLException {
    }

    @FXML
    void BackManageLots(ActionEvent event) {
        Stage currentStage = (Stage) backButtonManageLots.getScene().getWindow();
        currentStage.close();
    }
    UserDAO userDAO1 = new UserDAO(DriverManager.getConnection("jdbc:mysql://localhost:3306/auction?serverTimezone=Europe/Moscow", "root", "12345"));
    @FXML
    void SaveManageLots(ActionEvent event) throws SQLException {
        String name = nameLotsField.getText();
        String description = descriptionLotsArea.getText();
        LocalDate publicationDate = datePublication.getValue();
        LocalDate finishDate = dateFinish.getValue();
        String startPriceText = startPriceField.getText();
        String stepPriceText = stepPriceField.getText();
        String condition = conditionField.getText();

        Category selectedCategory = categoryComboBox.getValue();

        if (name.isEmpty() || description.isEmpty() || publicationDate == null || finishDate == null ||
                startPriceText.isEmpty() || stepPriceText.isEmpty() || condition.isEmpty() ||
                selectedCategory == null) {
            showAlert(Alert.AlertType.ERROR, "Ошибка!", "Пожалуйста, заполните все поля!");
            return; // Прерываем выполнение метода, если найдены пустые поля
        }

        double startPrice;
        double stepPrice;

        try {
            startPrice = Double.parseDouble(startPriceText);
            stepPrice = Double.parseDouble(stepPriceText);
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Ошибка!", "Пожалуйста, введите числа в поля цены и шага!");
            return; // Прерываем выполнение метода, если введены неверные числовые значения
        }

        int categoryId = selectedCategory.getId();

        int sellerId = 0;
        if (RegistrationController.isRegistred){
            sellerId = RegistrationController.registeredUserId;
        }
        else if(userDAO1.getUserRole(AuthorizationController.login, AuthorizationController.password) == Role.SELLER) {
            String login = AuthorizationController.login;
            sellerId = userDAO1.getIdByLogin(login);
        }

        int buyerId = 49;

        // Создание объекта лота
        Lot lot = new Lot(name, description, startPrice, startPrice, stepPrice, publicationDate.toString(), finishDate.toString(), condition);
        lot.setSellerId(sellerId);
        lot.setCurrentBuyerId(buyerId); // Установка фиктивного покупателя
        lot.setCategoryId(categoryId);

        // Сохраняем лот в базе данных
        try {
            lotDAO = new LotDAO(DatabaseConnector.ConnectDb());
            lotDAO.create(lot);
            showAlert(Alert.AlertType.INFORMATION, "Успешно!", "Лот успешно добавлен!");
            Stage stageClose = (Stage) saveButtonManageLots.getScene().getWindow();
            stageClose.close();

            WindowsManager.openWindow("seller/products-seller.fxml","Окно продавца");

        } catch (SQLException e) {
            e.printStackTrace();
            // Обработка ошибки сохранения лота
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void initialize() throws Exception {
        if(lot != null){
            nameLotsField.setText(lot.getName());
            descriptionLotsArea.setText(lot.getDescription());
            startPriceField.setText(String.valueOf(lot.getStartPrice()));
            stepPriceField.setText(String.valueOf(lot.getStepPrice()));
            String publish = lot.getDatepublicationDate();
            String close = lot.getDatelosingDate();
            datePublication.setValue(LocalDate.of(Integer.parseInt(publish.split("-")[0]),
                    Integer.parseInt(publish.split("-")[1]),
                    Integer.parseInt(publish.split("-")[2])));
            dateFinish.setValue(LocalDate.of(Integer.parseInt(close.split("-")[0]),
                    Integer.parseInt(close.split("-")[1]),
                    Integer.parseInt(close.split("-")[2])));
            conditionField.setText(lot.getCondition());
        }

        categoryComboBox.setValue(categoryDAO.getAllCategoriesList().get(0));
        categoryComboBox.setItems(categoryDAO.getAllCategoriesObservable());

//        try {
//            Connection connection = DatabaseConnector.ConnectDb(); // Получаем подключение к базе данных
//            categoryDAO = new CategoryDAO(connection);
//            lotDAO = new LotDAO(connection);
//            // Создаем экземпляр UserDAO
//            userDAO = new UserDAO(connection);
//            // Заполняем ComboBox категориями из базы данных
//            ObservableList<Category> categories = FXCollections.observableArrayList(categoryDAO.getAllCategories());
//            categoryComboBox.setItems(categories);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Обработка ошибки подключения к базе данных
//        }
    }

    @FXML
    public void goBack() {
        Stage stageClose = (Stage) backButton.getScene().getWindow();
        stageClose.close();

        WindowsManager.openWindow("seller/products-seller.fxml","Окно продавца");
    }
}