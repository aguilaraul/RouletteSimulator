package edu.miracosta.cs210.roulettesimulator;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class MenuBarController {

    @FXML
    protected void onStatsMenuClick() {
        StatsWindow.display();
    }

    @FXML
    protected void onCloseMenuClick() {
        System.out.println("Game exiting..");
        System.exit(0);
    }
}
