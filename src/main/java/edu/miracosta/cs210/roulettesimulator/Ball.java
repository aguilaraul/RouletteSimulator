package edu.miracosta.cs210.roulettesimulator;

import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.*;


public class Ball {

    private Circle ball = new Circle(400, 140, 10);

    Ball() {
        ball.setFill(Color.GOLD);
        ball.setTranslateY(260);
        ball.getTransforms().add(new Translate(0, 240));
    }

    public Circle getShape() {
        return ball;
    }
}