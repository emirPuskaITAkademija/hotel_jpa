package com.academy.hotel_jpa.controller.event;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//public klasa u paketu event i svima i van ovog paketa je dostupna
public class EventBus {
    private final LoginEvent loginEvent = new LoginEvent();
    private final CancelEvent cancelEvent = new CancelEvent();
    private final LogoutEvent logoutEvent = new LogoutEvent();


    public EventHandler<ActionEvent> getLoginEvent() {
        //tipa LoginEvent(paketno privatna), EventHandler<ActionEvent>
        return loginEvent;
    }

    public EventHandler<ActionEvent> getCancelEvent() {
        return cancelEvent;
    }

    public EventHandler<ActionEvent> getLogoutEvent() {
        return logoutEvent;
    }
}
