package edu.miracosta.cs210.roulettesimulator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    boolean validLogin = false;

    @FXML
    private Label welcomeText;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    @FXML
    protected void onLoginButtonClick() {
        String username = usernameField.getText();

        if(username.isEmpty()) {
            usernameField.setPromptText("Enter a username");
        }
        if(passwordField.getText().isBlank()) {
            passwordField.setPromptText("Enter a password");
        }
        if(!username.isEmpty() && !passwordField.getText().isBlank()) {
            validLogin = true;
//            player = AccountsManager.loadPlayer(username);
//            int balance = player.getBalance();
//            table.RouletteTable(username, balance);

            //welcomeText.setText("Welcome to Roulette Simulator!");
        }
    }
}