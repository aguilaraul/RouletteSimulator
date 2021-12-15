package edu.miracosta.cs210.roulettesimulator;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class App extends Application {
    static final double windowWidth = 1080.0;
    static final double windowHeight = 720.0;
    static Stage window;
    static Player player;
    static HashMap<String, Scene> scenes = new HashMap<String, Scene>();
    static private ObservableList<Integer> spinList;
    static Bet bet;


    public static ObservableList<Integer> spinList() {
        if (spinList == null) {
            ArrayList<Integer> spinArray = new ArrayList<Integer>();
            spinList = FXCollections.observableList(spinArray);
        }
        return spinList;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        window.setResizable(false);
        window.setTitle("Login");
        window.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            exitProgram();
        });

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
        if (stylesheet!=null) {
            newScene.getStylesheets().add(App.class.getResource(stylesheet).toExternalForm());
        }
        window.setScene(newScene);
        window.setMinWidth(windowWidth);
        window.setMinHeight(windowHeight);
        window.setTitle(title);
    }

    public static void exitProgram() {
        if(ExitConfirmBox.display()) {
            System.out.println("Saving player..");
            AccountsManager.savePlayer(App.player.getName(), App.player.getBalance());
            System.out.println("Exiting..");
            window.close();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}