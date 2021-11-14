package edu.miracosta.cs210.roulettesimulator;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class MenuBarController {
    @FXML
    private MenuItem statsMenu;

    @FXML
    protected void onStatsMenuClick() {
        statsMenu.setOnAction(e -> StatsWindow.display());
    }
}
