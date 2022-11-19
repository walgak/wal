package com.example.wal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWAL extends Application {

    public static final String currency = "KSH ";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainWAL.class.getResource("mainWal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("WAL PHARMACEUTICALS");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}