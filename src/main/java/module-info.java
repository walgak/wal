module com.example.wal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.wal to javafx.fxml;
    exports com.example.wal;
    exports controllers;
    opens controllers to javafx.fxml;
}