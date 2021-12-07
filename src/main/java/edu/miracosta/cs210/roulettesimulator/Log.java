package edu.miracosta.cs210.roulettesimulator;

import javafx.scene.control.ListView;

public final class Log extends ListView {

    private Log() {
    }

    private static final Log INSTANCE = new Log();

    public static Log getInstance() { return INSTANCE; }

    public void addToLog(String message) {
        this.getItems().add(message);
    }
}
