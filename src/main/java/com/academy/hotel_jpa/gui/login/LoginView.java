package com.academy.hotel_jpa.gui.login;

import com.academy.hotel_jpa.controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

/**
 * Stage -> Scene -> LoginView(UI) (ekstenzija GridPane)
 */
public class LoginView extends GridPane {

    private final Label usernameLabel = new Label("Korisničko ime:");
    private final Label passwordLabel = new Label("Lozinka:");
    private final TextField usernameTextField = new TextField();
    private final PasswordField passwordTextField = new PasswordField();
    private final Button loginButton = new Button("Login");
    private final Button cancelButton = new Button("Cancel");
    //empty tekst ali ćemo dinamički puniti ako korisnik unese pogrešno username i pass
    private final Label errorMessageLabel = new Label();

    public LoginView() {
        setHgap(10);
        setVgap(10);

        setPadding(new Insets(25, 25, 25, 25));
        setAlignment(Pos.CENTER);

        add(usernameLabel, 0, 0);//UI kontrolu, kolona , red
        add(usernameTextField, 1, 0);
        add(passwordLabel, 0, 1);
        add(passwordTextField, 1, 1);

        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(10);
        flowPane.setAlignment(Pos.CENTER_RIGHT);
        flowPane.getChildren().addAll(loginButton, cancelButton);
        add(flowPane, 1, 2);//add(flowPane, 1, 2)

        add(errorMessageLabel, 1, 3);

        Controller controller = Controller.instance();
        loginButton.setOnAction(controller.getLoginEvent());
        cancelButton.setOnAction(controller.getCancelEvent());
    }


    public String getUsername() {
        return usernameTextField.getText();
    }

    public String getPassword() {
        return passwordTextField.getText();
    }

    public void setErrorMessage(String errorMessage) {
        errorMessageLabel.setText(errorMessage);
    }
}
