package com.academy.hotel_jpa.controller.event;

import com.academy.hotel_jpa.controller.Controller;
import com.academy.hotel_jpa.entity.user.User;
import com.academy.hotel_jpa.entity.user.UserDao;
import com.academy.hotel_jpa.entity.user.privilege.Privilege;
import com.academy.hotel_jpa.gui.admin.AdminView;
import com.academy.hotel_jpa.gui.employee.EmployeeView;
import com.academy.hotel_jpa.gui.login.LoginView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

//paketno privatna klasa LoginEvent i nije nikom osim klasam u ovom paketu dostupna
//Izložićemo objekat kreiran po šablonu ove klase putem interfejsa EventHandler koji je public
class LoginEvent implements EventHandler<ActionEvent> {

    //objekat.handle(event)
    @Override
    public void handle(ActionEvent actionEvent) {
        Controller controller = Controller.instance();
        LoginView loginView = controller.getLoginView();

        String username = loginView.getUsername();
        String password = loginView.getPassword();

        if (username.isEmpty() || password.isEmpty()) {
            loginView.setErrorMessage("Username and/or password are empty");
            return;
        }
        UserDao userDao = new UserDao();
        User loggedUser = userDao.login(username, password);
        if (loggedUser == null) {
            loginView.setErrorMessage("Invalid combination of username and password");
            return;
        }
        controller.setLoggedUser(loggedUser);
        Privilege privilege = loggedUser.getPrivilege();
        if (privilege.getName().equalsIgnoreCase("admin")) {
            AdminView adminView = new AdminView();
            controller.setAdminView(adminView);
            setNewSceneOnStage(adminView);
        } else {
            EmployeeView employeeView = new EmployeeView();
            controller.setEmployeeView(employeeView);
            setNewSceneOnStage(employeeView);
        }
    }


    private void setNewSceneOnStage(BorderPane borderPane) {
        Controller controller = Controller.instance();
        Scene scene = new Scene(borderPane);
        controller.getStage().setScene(scene);
    }

}
