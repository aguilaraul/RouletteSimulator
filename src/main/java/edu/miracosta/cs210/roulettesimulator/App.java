package edu.miracosta.cs210.roulettesimulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static Stage window;

    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;

        FXMLLoader loginSceneLoader = new FXMLLoader(App.class.getResource("login-view.fxml"));
        Scene loginScene = new Scene(loginSceneLoader.load(), 250, 250);

        //FXMLLoader gameSceneLoader = new FXMLLoader(App.class.getResource("game-view.fxml"));
        //Scene gameScene = new Scene(gameSceneLoader.load(), 640, 480);

        primaryStage.setTitle("Login Window");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public void changeScene(String fxml, String title) throws IOException {
        Parent newScene = FXMLLoader.load(getClass().getResource(fxml));
        window.getScene().setRoot(newScene);
        window.setMinWidth(640.0);
        window.setMinHeight(480.0);
        window.setTitle(title);
    }

    public static void main(String[] args) {
        launch();
    }
}