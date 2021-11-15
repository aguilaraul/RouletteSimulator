package edu.miracosta.cs210.roulettesimulator;

import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {
    Stage window = App.window;
    private Player player = App.player;
    private double balance = player.getBalance();

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
