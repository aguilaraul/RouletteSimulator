package edu.miracosta.cs210.roulettesimulator;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

import java.io.IOException;

public class MenuBarController {

    @FXML
    protected void onStatsMenuClick() throws IOException {
        StatsWindow.display();
    }

    @FXML
    protected void onCloseMenuClick() {
        System.out.println("Game exiting..");
        System.exit(0);
    }
}
