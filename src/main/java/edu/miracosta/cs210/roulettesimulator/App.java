package edu.miracosta.cs210.roulettesimulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loginSceneLoader = new FXMLLoader(App.class.getResource("login-view.fxml"));
        Scene loginScene = new Scene(loginSceneLoader.load(), 250, 250);

        FXMLLoader gameSceneLoader = new FXMLLoader(App.class.getResource("game-view.fxml"));
        Scene gameScene = new Scene(gameSceneLoader.load(), 640, 480);

        primaryStage.setTitle("Login Window");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}