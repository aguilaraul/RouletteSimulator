package edu.miracosta.cs210.roulettesimulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class App extends Application {
    static Stage window;
    static Player player;
    static HashMap<String, Scene> scenes = new HashMap<String, Scene>();

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

    static public void changeScene(String title, String fxml) throws IOException {
        changeScene(title, null);
    }
    static public void changeScene(String title, String fxml, String stylesheet) throws IOException {
        Scene newScene;
        String key = title+fxml+stylesheet;
        if (scenes.containsKey(key)) {
            newScene = scenes.get(key);
        } else {
            newScene = new Scene(FXMLLoader.load(App.class.getResource(fxml)));
            scenes.put(key, newScene);
        }

        window.setScene(newScene);
        if (stylesheet!=null) {
            newScene.getStylesheets().add(App.class.getResource(stylesheet).toExternalForm());
        }
        window.setMinWidth(640.0);
        window.setMinHeight(480.0);
        window.setTitle(title);
    }

    public static void main(String[] args) {
        launch();
    }
}