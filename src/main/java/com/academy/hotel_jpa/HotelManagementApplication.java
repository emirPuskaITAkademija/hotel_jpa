package com.academy.hotel_jpa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HotelManagementApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label label = new Label("Hotel Management Application");

        Scene scene = new Scene(label, 600, 400);
        stage.setTitle("Hotel Management Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
