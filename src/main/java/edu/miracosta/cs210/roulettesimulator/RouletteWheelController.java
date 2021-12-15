package edu.miracosta.cs210.roulettesimulator;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class RouletteWheelController {

    Bet bet;

    @FXML
    private RouletteWheelControl rouletteWheelControl;

    @FXML
    private Label resultsLabel;

    @FXML
    public void initialize() {
        resultsLabel.setFont(Font.font(24));
        String resultsText = "Bet  : " + App.bet + "\nAmount : $" + App.bet.getWagerAmount();
        resultsLabel.setText(resultsText);
        App.spinList().addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change change) {
                System.out.println("Roulette Controller - Detected a change! ");
                while (change.next()) {
                    System.out.println("Was added? " + change.wasAdded());
                    System.out.println("Was removed? " + change.wasRemoved());
                    System.out.println("Was replaced? " + change.wasReplaced());
                    System.out.println("Was permutated? " + change.wasPermutated());
                    Integer num = App.spinList().get(App.spinList().size()-1);
                    if (App.bet!=null) {
                        boolean isWinner = App.bet.isWinner(num);
                        System.out.println("Bet was a winner? " + isWinner);
                        String existingText = resultsLabel.getText() + "\n";
                        if (isWinner) {
                            resultsLabel.setText(existingText + "WINNER!");
                        } else {
                            resultsLabel.setText(existingText + "LOSING BET!");
                        }

                    }
                }
            }
        });
    }

}
