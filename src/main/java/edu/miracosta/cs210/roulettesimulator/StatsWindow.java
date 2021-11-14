package edu.miracosta.cs210.roulettesimulator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class StatsWindow {
    static private Stage window;

    @FXML
    Label gamesWonValue;
    @FXML
    Label currentBalanceValue;

    @FXML
    protected void onCloseButtonClick() {
        window.close();
    }

    public static void display() throws IOException {
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Stats");
        FXMLLoader statsSceneLoader = new FXMLLoader(App.class.getResource("statsWindow-view.fxml"));
        Scene statsScene = new Scene(statsSceneLoader.load(), 250, 250);
        window.setScene(statsScene);
        window.showAndWait();
    }

    private void setCurrentBalanceValue(double value) {
        String balance = String.valueOf(value);
        currentBalanceValue.setText(balance);
    }
}
