package com.academy.hotel_jpa.gui.admin;

import com.academy.hotel_jpa.controller.Controller;
import com.academy.hotel_jpa.entity.user.User;
import com.academy.hotel_jpa.gui.admin.room.RoomAdminPanel;
import com.academy.hotel_jpa.gui.admin.user.UserAdminPanel;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class AdminView extends BorderPane {

    private final ToggleButton userToggleButton = new ToggleButton("Users");
    private final ToggleButton roomToggleButton = new ToggleButton("Rooms");
    private final Button logoutButton = new Button("Logout");

    private UserAdminPanel userAdminPanel = new UserAdminPanel();
    private RoomAdminPanel roomAdminPanel = new RoomAdminPanel();

    public AdminView() {

        userToggleButton.setOnAction(this::onUserToggleButtonClick);
        roomToggleButton.setOnAction(this::onRoomToggleButtonClick);

        ToggleGroup toggleGroup = new ToggleGroup();
        userToggleButton.setToggleGroup(toggleGroup);
        roomToggleButton.setToggleGroup(toggleGroup);
        userToggleButton.setSelected(true);

        HBox mainMenu = new HBox();
        mainMenu.setSpacing(5);
        mainMenu.setPadding(new Insets(10, 10, 10, 10));
        mainMenu.getChildren().addAll(userToggleButton, roomToggleButton);

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
        setCenter(userAdminPanel);
    }

    private void onRoomToggleButtonClick(ActionEvent actionEvent) {
        roomAdminPanel = new RoomAdminPanel();
        setCenter(roomAdminPanel);
    }

    private void onUserToggleButtonClick(ActionEvent actionEvent) {
        userAdminPanel = new UserAdminPanel();
        setCenter(userAdminPanel);
    }

}
