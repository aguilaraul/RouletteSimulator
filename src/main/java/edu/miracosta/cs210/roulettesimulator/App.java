package edu.miracosta.cs210.roulettesimulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    static Stage window;
    static Player player;

    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        window.setResizable(false);
        window.setTitle("Login");

        FXMLLoader loginSceneLoader = new FXMLLoader(App.class.getResource("login-view.fxml"));
        Scene loginScene = new Scene(loginSceneLoader.load(), 250, 250);
        window.setScene(loginScene);
        loginScene.getStylesheets().add(getClass().getResource("css/login.css").toExternalForm());
        window.show();
    }

    public void changeScene(String title, String fxml) throws IOException {
        Scene newScene = new Scene(FXMLLoader.load(getClass().getResource(fxml)));
        window.setScene(newScene);
        window.setMinWidth(640.0);
        window.setMinHeight(480.0);
        window.setTitle(title);
    }
    public void changeScene(String title, String fxml, String stylesheet) throws IOException {
        Scene newScene = new Scene(FXMLLoader.load(getClass().getResource(fxml)));
        window.setScene(newScene);
        newScene.getStylesheets().add(getClass().getResource(stylesheet).toExternalForm());
        window.setMinWidth(640.0);
        window.setMinHeight(480.0);
        window.setTitle(title);
    }

    public static void main(String[] args) {
        launch();
    }
}