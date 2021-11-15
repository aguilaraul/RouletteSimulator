package edu.miracosta.cs210.roulettesimulator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {
    Stage window = App.window;
    private Player player = App.player;
    private double balance = player.getBalance();

    @FXML Label balanceValue;

    public void updateCashValue(double value) {
        balanceValue.setText(String.valueOf(value));
    }

    @FXML
    protected void onButtonClick() {
        updateCashValue(balance);
    }

    // Menu bar functions
    @FXML
    protected void onCloseMenuClick() {
        System.out.println("Game exiting..");
        window.close();
    }

    @FXML
    protected void onStatsMenuClick() throws IOException {
        StatsWindow.display();
    }
}
