package edu.miracosta.cs210.roulettesimulator;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StatsWindow {
    public static void display() {
        // Window settings
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Stats");
        window.setMinWidth(250);
        window.setMinHeight(250);

        // Stats
        Label gamesWon   = new Label("Games Won:");
        Label gamesLost  = new Label("Games Lost:");
        Label winPercent = new Label("Win Percentage:");
        Label amtBet     = new Label("Bet Total:");
        Label amtWon     = new Label("Total Earnings:");
        Label amtLost    = new Label("Total Lost:");

        // Close button
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(gamesWon, gamesLost, winPercent, amtBet, amtWon, amtLost);
        layout.getChildren().add(closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
