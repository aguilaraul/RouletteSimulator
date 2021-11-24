package edu.miracosta.cs210.roulettesimulator;

import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.io.IOException;

public class RouletteWheel  extends VBox {

    // Number of steps in one orbit of roulette wheel.
    private static final double ANGLE = 9.72972973f;
    // Sets number of rotations of wheel - must be multiple of 360.
    private static final int SPIN_LENGTH = 1800;
    // Scene size.
    private static final int SIZE = 400;
    private Ball ball = new Ball();

    public RouletteWheel() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("roulette-wheel.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
            showWheel();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    //UI Stuff
    public void showWheel() {
        float center = SIZE/2;
        float radius = (center/4) * 3;
        double angle = 85.135135135f;
        Group wheel = new Group();
        Group text = new Group();
        for (int i = 0; i < 37; i++) {
            Arc arc = new Arc();
            if (i == 0) {
                arc.setFill(Color.GREEN);
            }
            else if (i % 2 == 0) {
                arc.setFill(Color.RED);
            }
            else {
                arc.setFill(Color.BLACK);
            }

            arc.setCenterX(center);
            arc.setCenterY(center);
            arc.setRadiusX(radius);
            arc.setRadiusY(radius);
            arc.setStartAngle(angle);
            arc.setLength(ANGLE);
            arc.setType(ArcType.ROUND);
            wheel.getChildren().add(arc);

            angle += ANGLE;

        }
        for (int i = 0; i < 37; i++) {
            Text textNode = new Text(""+i);
            int centreX = (int)center;
            int centreY = (int)(center - (center/40));
            int radiusInt = (int) (radius - (radius/10));
            double angleText = (180+numberToAngle(i));
            textNode.setFill(Color.YELLOW);
            double x = centreX + radiusInt * (Math.cos(numberToAngle(i) * Math.PI / 180f));
            double y = centreY + radiusInt * (Math.sin(numberToAngle(i) * Math.PI / 180f));
//            System.out.println(x);
//            System.out.println(y);
            textNode.relocate(y, x);
            textNode.getTransforms().add(new Rotate(angleText));
            text.getChildren().add(textNode);
        }

        Button b = new Button("Spin");
        b.setOnAction(this::press);

        Group group = new Group(wheel, ball.getShape(), b);

        this.getChildren().add(group);
    }

    private void press(ActionEvent e) {

        animate(ball);

    }

    private void animate(Ball ball) {
        Duration d = Duration.seconds(5);
        RotateTransition rt = new RotateTransition(d, ball.getShape());
        rt.setFromAngle(180);
        rt.setToAngle(SPIN_LENGTH + getRandomNum(0, 37));
        rt.setAxis(Rotate.Z_AXIS);
        rt.setAutoReverse(false);
        rt.setOnFinished((actionEvent-> {
            System.out.println("Finished spinning wheel.");
            PauseTransition wait = new PauseTransition(Duration.seconds(1.5));
            wait.setOnFinished((e) -> {
                try {
                    App.changeScene("Roulette Simulator", "game-view.fxml", "css/game.css");
                } catch (IOException ioe) {
                    System.err.println("Unable to change scene");
                    ioe.printStackTrace();
                }
                wait.stop();
            });
            wait.play();
        }));
        rt.play();
    }

    private int getRandomNum(int min, int max) {
        int number = (int)(Math.random()*(max - min) + min);
        System.out.println(number);
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

    private class Ball {

        //
        private Circle ball = new Circle(SIZE/2, (SIZE/8 + SIZE/20), SIZE/40);

        Ball() {
            ball.setFill(Color.GOLD);
            double translateY = (float)SIZE/3.07;
            ball.setTranslateY(translateY);
            ball.getTransforms().add(new Translate(0, translateY));
        }

        public Circle getShape() {
            return ball;
        }
    }

}
