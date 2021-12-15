package edu.miracosta.cs210.roulettesimulator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
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
    private static int spinCount = 1;

    Bet bet;
    String betTypeSelection;

    @FXML ListView<String> log;
    @FXML Label cashValue;
    @FXML
    ComboBox betSelection;
    @FXML
    TextField wagerAmount;

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
        if (betTypeSelection==null || wagerAmount.getText()==null) {
            System.out.println("No bet type selected or wager amount is empty");
            return;
        }
        createWager();
        App.changeScene("Spin #" + spinCount++, "roulette-wheel-view.fxml", "css/game.css");
    }

    @FXML
    public void initialize() {
        updateCashValue(App.player.getBalance());
        App.spinList().addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Game Controller - Detected a change! ");
                while (change.next()) {
                    System.out.println("Was added? " + change.wasAdded());
                    System.out.println("Was removed? " + change.wasRemoved());
                    System.out.println("Was replaced? " + change.wasReplaced());
                    System.out.println("Was permutated? " + change.wasPermutated());
                    Integer num = App.spinList().get(App.spinList().size()-1);
                    if (bet!=null) {
                        boolean isWinner = bet.isWinner(num);
                        System.out.println("Bet was a winner? " + isWinner);
                        String logString = isWinner ? "WINNING BET! New balance : " : "LOSING BET! New Balance : ";
                        if (isWinner) {
                            balance+=bet.getWagerAmount();
                        } else {
                            balance-=bet.getWagerAmount();
                        }
                        App.player.setBalance((int)balance);
                        updateCashValue(App.player.getBalance());
                        AccountsManager.savePlayer(App.player.getName(), (int)balance);
                        log.getItems().add(logString + text.formattedBalance(balance));
                    }
                }
            }
        });

        betSelection.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue<? extends String> selected, String oldValue, String newValue) {
                if (newValue != null) {
                    betTypeSelection = newValue;
                }
//                    String wagerString = wagerAmount.getText();
//                    if (wagerString==null) {
//                        System.out.println("No wager amount");
//                        return;
//                    }
//                    System.out.println("Wager amount : " + wagerString);
//                    Integer wagerAmt = Integer.parseInt(wagerString);
//                    System.out.println("Bet selected " + selected);
//                    switch(newValue) {
//                        case "Black":
//                            bet = new ColorBet();
//                            bet.setWagerAmount(wagerAmt);
//                            ((ColorBet)bet).setColor(Color.BLACK);
//                            break;
//                        case "Red":
//                            bet = new ColorBet();
//                            bet.setWagerAmount(wagerAmt);
//                            ((ColorBet)bet).setColor(Color.RED);
//                            break;
//                        case "Odd":
//                            bet = new OddEvenBet();
//                            bet.setWagerAmount(wagerAmt);
//                            ((OddEvenBet)bet).setIsEven(false);
//                            break;
//                        case "Even":
//                            bet = new OddEvenBet();
//                            bet.setWagerAmount(wagerAmt);
//                            ((OddEvenBet)bet).setIsEven(true);
//                            break;
//                        default:
//                            int value = Integer.parseInt(newValue);
//                            bet = new NumberBet();
//                            bet.setWagerAmount(wagerAmt);
//                            ((NumberBet)bet).setNumber(value);
//
//                    }
//                }
            }
        });
    }

    public void createWager() {
        String newValue = betTypeSelection;
        String wagerString = wagerAmount.getText();
        if (wagerString==null) {
            System.out.println("No wager amount");
            return;
        }
        System.out.println("Wager amount : " + wagerString);
        Integer wagerAmt = Integer.parseInt(wagerString);
        System.out.println("Bet selected " + betTypeSelection);
        switch(newValue) {
            case "Black":
                bet = new ColorBet();
                bet.setWagerAmount(wagerAmt);
                ((ColorBet)bet).setColor(Color.BLACK);
                break;
            case "Red":
                bet = new ColorBet();
                bet.setWagerAmount(wagerAmt);
                ((ColorBet)bet).setColor(Color.RED);
                break;
            case "Odd":
                bet = new OddEvenBet();
                bet.setWagerAmount(wagerAmt);
                ((OddEvenBet)bet).setIsEven(false);
                break;
            case "Even":
                bet = new OddEvenBet();
                bet.setWagerAmount(wagerAmt);
                ((OddEvenBet)bet).setIsEven(true);
                break;
            default:
                int value = Integer.parseInt(newValue);
                bet = new NumberBet();
                bet.setWagerAmount(wagerAmt);
                ((NumberBet)bet).setNumber(value);

        }
    }
}
