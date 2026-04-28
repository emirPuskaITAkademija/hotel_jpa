package com.academy.hotel_jpa.gui.employee;

import com.academy.hotel_jpa.controller.Controller;
import com.academy.hotel_jpa.entity.user.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class EmployeeView extends BorderPane {

    private final ToggleButton reservationToggleButton = new ToggleButton("Reservations");
    private final Button logoutButton = new Button("Logout");


    public EmployeeView() {

        HBox mainMenu = new HBox();
        mainMenu.setSpacing(5);
        mainMenu.setPadding(new Insets(10, 10, 10, 10));
        mainMenu.getChildren().addAll(reservationToggleButton);

        Controller controller = Controller.instance();
        User loggedUser = controller.getLoggedUser();
        logoutButton.setText("Odjava (%s)".formatted(loggedUser.getName()));
        logoutButton.setOnAction(controller.getLogoutEvent());
        HBox logoutBox = new HBox();
        logoutBox.setAlignment(Pos.CENTER_RIGHT);
        logoutBox.setPadding(new Insets(10, 10, 10, 10));
        logoutBox.getChildren().addAll(logoutButton);


        GridPane topPane = new GridPane();
        topPane.add(mainMenu, 0, 0);
        topPane.add(logoutBox, 1, 0);

        setTop(topPane);
    }

}
