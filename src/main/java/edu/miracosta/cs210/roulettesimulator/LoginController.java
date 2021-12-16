package edu.miracosta.cs210.roulettesimulator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.Scanner;


public class LoginController {
    boolean validLogin = false;
    int totalUsers = 4;
    String INPUT_FILE = "src/main/Users.txt";


    @FXML
    private Label welcomeText;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    @FXML
    protected void onLoginButtonClick() throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        App app = new App();
        String username = usernameField.getText();
        AccountsManager accountsManager = AccountsManager.getInstance();

        if(username.isEmpty()) {
            usernameField.setPromptText("Enter a username");
        }
        if(passwordField.getText().isBlank()) {
            passwordField.setPromptText("Enter a password");
        }

        if(!username.isEmpty() && !passwordField.getText().isBlank()) {
            App.player = accountsManager.getInstance().loadPlayer(username);

            try {
                Scanner file = new Scanner (new File(INPUT_FILE));
                String userTxt, passwordTxt, line;
                String[] data;
                int count = 0;

                while(file.hasNextLine())
                {
                    line = file.nextLine();
                    data = line.split(",");

                    userTxt = data[0];
                    passwordTxt = data[1];

                    if (userTxt.equals(username) && passwordTxt.equals(passwordField.getText())){
                        //System.out.println("login successful");
                        validLogin = true;
                        Player player = AccountsManager.getInstance().loadPlayer(username);
                        App.player = player;
                    }
                    else {
                        count++;
                    }

                    if (count == totalUsers) {
                        //System.out.println("login failed");
                        validLogin = false;
                    }
                }
            }
            catch (FileNotFoundException e)
            {
                System.out.println("Error loading: " + e.getMessage());
            }
        }

        if(!username.isEmpty() && !passwordField.getText().isBlank() && validLogin == true) {
            //validLogin = true; // doesn't really do anything yet
            App.player = AccountsManager.getInstance().loadPlayer(username);
            app.changeScene("Roulette Simulator", "game-view.fxml", "css/game.css");
        }
    }
}