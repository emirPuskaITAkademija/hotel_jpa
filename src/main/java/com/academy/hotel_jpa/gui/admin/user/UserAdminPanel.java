package com.academy.hotel_jpa.gui.admin.user;

import com.academy.hotel_jpa.entity.user.User;
import com.academy.hotel_jpa.entity.user.UserDao;
import com.academy.hotel_jpa.entity.user.privilege.Privilege;
import com.academy.hotel_jpa.entity.user.privilege.PrivilegeDao;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

/**
 * vertikalno jednu ispod druge
 */
public class UserAdminPanel extends VBox {

    private final Label titleLable = new Label("Administracija korisnika");
    private final TableView<User> userTableView = new TableView<>();
    private List<User> users;

    private final TextField usernameTextField = new TextField();
    private final PasswordField passwordField = new PasswordField();
    private final TextField nameTextField = new TextField();
    private final TextField surnameTextField = new TextField();
    private final ChoiceBox<Privilege> privilegeChoiceBox = new ChoiceBox<>();

    private final Button addUserButton = new Button("Add User");

    private final UserDao userDao = new UserDao();


    public UserAdminPanel() {
        setSpacing(5);
        setPadding(new Insets(10, 10, 10, 10));
        titleLable.setFont(new Font("Arial", 20));

        this.users = userDao.findAll();

        initUserTableView();

        getChildren().addAll(titleLable, userTableView, getUserForm());
    }

    private HBox getUserForm() {
        HBox form = new HBox();
        form.setSpacing(3);
        form.setPadding(new Insets(10, 10, 10, 10));
        usernameTextField.setPromptText("Username...");
        passwordField.setPromptText("Password...");
        nameTextField.setPromptText("Name...");
        surnameTextField.setPromptText("Surname...");
        List<Privilege> privileges = new PrivilegeDao().findAll();
        privilegeChoiceBox.setItems(FXCollections.observableList(privileges));
        privilegeChoiceBox.getSelectionModel().select(0);
        addUserButton.setOnAction(this::onAddUserButtonClicked);
        form
                .getChildren()
                .addAll(usernameTextField, passwordField, nameTextField, surnameTextField, privilegeChoiceBox, addUserButton);
        return form;
    }

    private void onAddUserButtonClicked(ActionEvent actionEvent) {
        User user = new User();
        user.setUsername(usernameTextField.getText());
        user.setPassword(passwordField.getText());
        user.setName(nameTextField.getText());
        user.setSurname(surnameTextField.getText());
        user.setPrivilege(privilegeChoiceBox.getSelectionModel().getSelectedItem());

        UserDao userDao = new UserDao();
        userDao.save(user);
        clearInputFields();
        reload();
    }

    private void clearInputFields() {
        usernameTextField.clear();
        passwordField.clear();
        surnameTextField.clear();
        nameTextField.clear();
        privilegeChoiceBox.getSelectionModel().select(0);
    }

    private void reload() {
        this.users = userDao.findAll();
        userTableView.setItems(FXCollections.observableList(users));
    }


    private void initUserTableView() {
        TableColumn<User, String> usernameColumn = new TableColumn<>("Korisničko Ime");
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

        TableColumn<User, String> nameColumn = new TableColumn<>("Ime");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<User, String> surnameColumn = new TableColumn<>("Prezime");
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        TableColumn<User, Privilege> privilegeColumn = new TableColumn<>("Nivo Pristupa");
        privilegeColumn.setCellValueFactory(new PropertyValueFactory<>("privilege"));

        userTableView.getColumns().addAll(usernameColumn, nameColumn, surnameColumn, privilegeColumn);
        userTableView.setItems(FXCollections.observableList(users));
    }
}
