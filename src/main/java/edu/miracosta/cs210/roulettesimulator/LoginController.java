package edu.miracosta.cs210.roulettesimulator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    RouletteTable table = new RouletteTable();
    Player player;

    @FXML
    private Label welcomeText;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

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
            player = AccountsManager.loadPlayer(username);
            int balance = player.getBalance();

            table.RouletteTable(username, balance);
            welcomeText.setText("Welcome to Roulette Simulator!");
        }

    }
}