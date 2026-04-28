package com.academy.hotel_jpa.gui.admin.room;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class RoomAdminPanel extends VBox {
    private final Label titleLable = new Label("Administracija Soba");

    public RoomAdminPanel() {
        setSpacing(5);
        setPadding(new Insets(10, 10, 10, 10));
        titleLable.setFont(new Font("Arial", 20));

        getChildren().add(titleLable);
    }
}
