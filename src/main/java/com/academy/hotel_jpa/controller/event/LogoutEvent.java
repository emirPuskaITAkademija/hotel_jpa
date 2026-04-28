package com.academy.hotel_jpa.controller.event;

import com.academy.hotel_jpa.controller.Controller;
import com.academy.hotel_jpa.gui.login.LoginView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

class LogoutEvent implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Controller controller = Controller.instance();

        LoginView loginView = new LoginView();
        controller.setLoginView(loginView);
        Scene scene = new Scene(loginView, 650, 180);
        controller.getStage().setScene(scene);

        controller.clearOnLogout();
    }
}
