package com.academy.hotel_jpa;

import com.academy.hotel_jpa.controller.Controller;
import com.academy.hotel_jpa.gui.login.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFx GUI -> Controller(User, Current View GUI-Stage) -> DB (Entity, EntityDao)
 */
public class HotelManagementApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //Naš mini framework kroz koji ćemo upravljati state-om naše aplikacije
        // CENTRAL STATE MANAGER
        Controller controller = Controller.instance();
        controller.setStage(stage);

        LoginView loginView = new LoginView();
        controller.setLoginView(loginView);

        Scene scene = new Scene(loginView, 650, 180);
        stage.setTitle("Hotel Management");
        stage.setMinWidth(300);
        stage.setMinHeight(300);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        /**
         * Kroz launch JavaFx uradi:
         * <li>1. inicijalizaciju runtime</li>
         * <li>2. kreira Stage(prozor)</li>
         * <li>3. pozove start(Stage stage)</li>
         */
        launch(args);
    }
}
