package edu.miracosta.cs210.roulettesimulator;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {
    Text text = Text.getInstance();
    Stage window = App.window;
    private Player player = App.player;
    private double balance = player.getBalance();
    private static int spinCount = 1;

    @FXML ListView<String> log;
    @FXML Label cashValue;

    /* Menu bar functions */
    @FXML
    protected void onCloseMenuClick() {
        System.out.println("Game exiting..");
        window.close();
    }

    @FXML
    protected void onStatsMenuClick() throws IOException {
        StatsWindow.display();
    }

    /* Game Buttons */
    @FXML
    protected void onCashOutClick() {
        updateCashValue(balance);
        log.getItems().add("Cash out " + text.formattedBalance(balance));
    }

    private void updateCashValue(double value) {
        cashValue.setText(text.formattedBalance(value));
    }

    @FXML
    protected void onBetClick() throws IOException {
        App.changeScene("Spin #" + spinCount++, "roulette-wheel-view.fxml", "css/game.css");
    }

    @FXML
    public void initialize() {
        App.spinList().addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Game Controller - Detected a change! ");
                while (change.next()) {
                    System.out.println("Was added? " + change.wasAdded());
                    System.out.println("Was removed? " + change.wasRemoved());
                    System.out.println("Was replaced? " + change.wasReplaced());
                    System.out.println("Was permutated? " + change.wasPermutated());
                }
            }
        });
    }
}
