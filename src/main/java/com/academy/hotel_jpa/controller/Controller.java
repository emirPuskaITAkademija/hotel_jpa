package com.academy.hotel_jpa.controller;

import com.academy.hotel_jpa.controller.event.EventBus;
import com.academy.hotel_jpa.entity.user.User;
import com.academy.hotel_jpa.gui.admin.AdminView;
import com.academy.hotel_jpa.gui.employee.EmployeeView;
import com.academy.hotel_jpa.gui.login.LoginView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * State Manager : EventBus
 */
public class Controller {
    private Stage stage;
    private LoginView loginView;
    private AdminView adminView;
    private EmployeeView employeeView;
    private User loggedUser;

    private final EventBus eventBus = new EventBus();


    private Controller() {
        /**
         * SINGLETON
         */
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public AdminView getAdminView() {
        return adminView;
    }

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

    public EmployeeView getEmployeeView() {
        return employeeView;
    }

    public void setEmployeeView(EmployeeView employeeView) {
        this.employeeView = employeeView;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public EventHandler<ActionEvent> getLoginEvent(){
        return eventBus.getLoginEvent();
    }

    public EventHandler<ActionEvent> getLogoutEvent(){
        return eventBus.getLogoutEvent();
    }

    public EventHandler<ActionEvent> getCancelEvent(){
        return eventBus.getCancelEvent();
    }


    public void clearOnLogout(){
        adminView = null;
        employeeView = null;
        loggedUser = null;
    }

    /**** SINGLETON ****/
    private static Controller INSTANCE = null;

    public static Controller instance() {
        if (INSTANCE == null) {
            INSTANCE = new Controller();
        }
        return INSTANCE;
    }
}
