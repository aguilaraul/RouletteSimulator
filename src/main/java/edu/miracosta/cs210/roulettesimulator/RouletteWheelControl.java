package edu.miracosta.cs210.roulettesimulator;


import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.IOException;

public class RouletteWheelControl  extends VBox {

    //The last number that came up
    public static int winningNumber =-1;
    // Number of steps in one orbit of roulette wheel.
    private static final double ANGLE = 9.72972973f;
    // Sets number of rotations of wheel - must be multiple of 360.
    private static final int SPIN_LENGTH = 1800;

    private Text text = Text.getInstance();
    private Ball ball = new Ball();
    private Wheel wheel = new Wheel();
    private Button buttonSpin = new Button("Spin");



    public RouletteWheelControl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("roulette-wheel-control.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
            showWheel();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    // Animation for spinning ball.
    private void animate() {
        Duration d = Duration.seconds(3);
        RotateTransition rt = new RotateTransition(d, ball.getShape());
        rt.setFromAngle(180);

        rt.setToAngle(SPIN_LENGTH + getRandomNum(0,37));//betting.getAngle());
        rt.setAxis(Rotate.Z_AXIS);
        rt.setOnFinished((actionEvent-> {
            System.out.println("Finished spinning wheel.");
            System.out.println(winningNumber);
            buttonSpin.setText("" + winningNumber);
            text.addToLog(text.winningNumber(winningNumber));
            App.spinList().add(winningNumber);

            PauseTransition wait = new PauseTransition(Duration.seconds(2));
            wait.setOnFinished((e) -> {
                buttonSpin.setText("Back");
                buttonSpin.setDisable(false);
                buttonSpin.setOnAction(this::goBack);
                wait.stop();
            });
            wait.play();
        }));
        rt.play();
    }

    //UI Stuff
    public void showWheel() {
        wheel.getWheel().setScaleX(0.65);
        wheel.getWheel().setScaleY(0.65);
        ball.getShape().setScaleX(0.65);
        ball.getShape().setScaleY(0.65);
        buttonSpin.setOnAction(this::press);
        Insets insets = new Insets(20, 20, 20, 20);
        buttonSpin.setPadding(insets);
        buttonSpin.setLayoutX(150);
        buttonSpin.setLayoutY(50);
        buttonSpin.setTranslateX(20);
        buttonSpin.setTranslateY(100);
        Group graphics = new Group(wheel.getWheel(), ball.getShape(), buttonSpin);
        this.getChildren().add(graphics);;
    }


    private void press(ActionEvent e) {
        buttonSpin.setDisable(true);
        animate();
    }

    private void goBack(ActionEvent e) {
        try {
            App.changeScene("Roulette Simulator", "game-view.fxml", "css/game.css");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    private int getRandomNum(int min, int max) {
        int number = (int)(Math.random()*(max - min) + min);
        winningNumber = number;
        return numberToAngle(number);
    }


    // Big ugly switch statement to convert number to angle for animation.
    private int numberToAngle(int number) {

        int angle=0;
        switch (number) {
            case 1: angle = 44;
                break;
            case 2: angle =  238;
                break;
            case 3: angle =  160;
                break;
            case 4: angle =  219;
                break;
            case 5: angle =  5;
                break;
            case 6: angle =  277;
                break;
            case 7: angle =  122;
                break;
            case 8: angle =  336;
                break;
            case 9: angle =  83;
                break;
            case 10: angle =  355;
                break;
            case 11: angle =  316;
                break;
            case 12: angle =  141;
                break;
            case 13: angle =  297;
                break;
            case 14: angle =  63;
                break;
            case 15: angle =  199;
                break;
            case 16: angle =  24;
                break;
            case 17: angle =  258;
                break;
            case 18: angle =  102;
                break;
            case 19: angle =  209;
                break;
            case 20: angle =  54;
                break;
            case 21: angle =  229;
                break;
            case 22: angle =  92;
                break;
            case 23: angle =  345;
                break;
            case 24: angle =  15;
                break;
            case 25: angle =  248;
                break;
            case 26: angle =  170;
                break;
            case 27: angle =  287;
                break;
            case 28: angle =  131;
                break;
            case 29: angle =  112;
                break;
            case 30: angle =  326;
                break;
            case 31: angle =  73;
                break;
            case 32: angle =  190;
                break;
            case 33: angle =  34;
                break;
            case 34: angle =  268;
                break;
            case 35: angle =  151;
                break;
            case 36: angle =  306;
                break;
            default: angle =  180;
                break;
        }
        return angle;
    }


}
