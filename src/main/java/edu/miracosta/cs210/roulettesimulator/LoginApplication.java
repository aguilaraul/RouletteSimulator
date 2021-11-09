package edu.miracosta.cs210.roulettesimulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loginScene = new FXMLLoader(LoginApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(loginScene.load(), 640, 480);

        FXMLLoader nextScene = new FXMLLoader(LoginApplication.class.getResource("nextScene-view.fxml"));
        Scene scene2 = new Scene(nextScene.load(), 640, 480);

        stage.setTitle("Login Window");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}