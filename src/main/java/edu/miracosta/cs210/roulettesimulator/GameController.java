package edu.miracosta.cs210.roulettesimulator;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {
    Text text = Text.getInstance();
    Stage window = App.window;
    private Player player = App.player;
    private double balance = player.getBalance();
    private double wager;
    private static int spinCount = 1;

    @FXML TextField wagerTextField;
    @FXML ListView<String> log;
    @FXML Label playerBalanceLabel;

    /* Menu bar functions */
    @FXML
    protected void onCloseMenuClick() {
        App.exitProgram();
    }

    @FXML
    protected void onStatsMenuClick() throws IOException {
        StatsWindow.display();
    }

    /* Bet Buttons */
    @FXML
    protected void onRedBetClick() {
        log.getItems().add("Placed bet on RED");
    }
    @FXML
    protected void onBlackBetClick() {
        log.getItems().add("Placed bet on BLACK");
    }
    @FXML
    protected void onOddBetClick() {
        log.getItems().add("Placed bet on ODD");
    }
    @FXML
    protected void onEvenBetClick() {
        log.getItems().add("Placed bet on EVEN");
    }

    /* Game Buttons */
    @FXML
    protected void onCashOutClick() {
        updateCashValue(balance);
        log.getItems().add("Cash out " + text.formattedBalance(balance));
    }

    private void updateCashValue(double value) {
        playerBalanceLabel.setText(text.formattedBalance(value));
    }

    @FXML
    protected void onBetClick() throws IOException {
        checkBet();
    }

    /**
     * Checks if valid bet was placed
     * @throws IOException unable to change scene
     */
    private void checkBet() throws IOException {
        if(checkWager()) {
            log.getItems().add("You bet " + text.formattedBalance(this.wager));
            App.changeScene("Spin #" + spinCount++, "roulette-wheel-view.fxml", "css/game.css");
        }
    }

    private boolean checkWager() {
        boolean validWager = false;
        if (wagerTextField.getText().isBlank() || wagerTextField.getText().equals("0")) {
            log.getItems().add("Enter a wager amount");
        } else {
            try {
                this.wager = Double.parseDouble(wagerTextField.getText());
                if(wager > this.balance) {
                    log.getItems().add("Your wager is greater than your balance");
                }
                validWager = wager > 0 && wager <= this.balance;
            } catch (NumberFormatException invalidWager) {
                log.getItems().add("Please enter a valid wager");
            }
        }
        return validWager;
    }

    @FXML
    public void initialize() {
        playerBalanceLabel.setText(text.formattedBalance(balance));
        App.spinList().addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                //@Debug
//                System.out.println("Game Controller - Detected a change! ");
//                while (change.next()) {
//                    System.out.println("Was added? " + change.wasAdded());
//                    System.out.println("Was removed? " + change.wasRemoved());
//                    System.out.println("Was replaced? " + change.wasReplaced());
//                    System.out.println("Was permutated? " + change.wasPermutated());
//                }
            }
        });
    }
}
