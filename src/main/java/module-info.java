module edu.miracosta.cs210.roulettesimulator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens edu.miracosta.cs210.roulettesimulator to javafx.fxml;
    exports edu.miracosta.cs210.roulettesimulator;
}