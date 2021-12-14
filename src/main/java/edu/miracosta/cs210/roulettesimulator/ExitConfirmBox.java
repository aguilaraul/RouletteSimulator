package edu.miracosta.cs210.roulettesimulator;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExitConfirmBox {

    static boolean exit;

    public static boolean display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Exit?");
        window.setMinWidth(250.0);

        Label label = new Label();
        label.setText("Are you sure you want to exit?");
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        yesButton.setOnAction(actionEvent -> {
            exit = true;
            window.close();
        });
        noButton.setOnAction(actionEvent -> {
            exit = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return exit;
    }
}
