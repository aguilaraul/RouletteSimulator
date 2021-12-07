package edu.miracosta.cs210.roulettesimulator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {
    Text text = Text.getInstance();
    Stage window = App.window;
    private Player player = App.player;
    private double balance = player.getBalance();
    private static int spinCount = 1;

    @FXML Label cashValue;

    @FXML
    protected void onCashOutClick() {
        updateCashValue(balance);
    }

    private void updateCashValue(double value) {
        cashValue.setText(text.formattedBalance(value));
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

    @FXML
    protected void onBetClick() throws IOException {
        //Uncomment to use the old wheel control
        //App.changeScene("Spin Wheel", "roulette-view.fxml", "css/game.css");
        App.changeScene("Spin #" + spinCount++, "roulette-wheel-view.fxml", "css/game.css");
    }
}
