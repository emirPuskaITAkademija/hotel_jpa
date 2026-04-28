package com.academy.hotel_jpa.controller.event;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

class CancelEvent implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        System.exit(0);
    }
}
