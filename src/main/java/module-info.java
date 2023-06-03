module com.example.onlineauction {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.jfoenix;
    requires java.sql;

    opens com.example.onlineauction to javafx.fxml;
    exports com.example.onlineauction;
}