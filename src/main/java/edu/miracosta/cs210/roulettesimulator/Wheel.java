package edu.miracosta.cs210.roulettesimulator;

/* Graphic object for wheel */

import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.transform.*;
import javafx.scene.shape.*;
import javafx.scene.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;

public class Wheel {
    // Group contains all graphical elements for the wheel.
    private Group wheel = new Group();
    // Angle per segment of roulette wheel.
    private static final double ANGLE = 9.72972973f;
    // Sets the start angle for drawing the wheel segments.
    private static final double START_ANGLE = 85.135135135f;
    // NumberSet used to draw text onto wheel.
    private NumberSet numberSet = new NumberSet();

    public Wheel() {
        drawDecorationBottom();
        drawSegments();
        drawNumbers();
        drawDecorationTop();
    }

    public Group getWheel() {
        return wheel;
    }
    // Draws each segment as an arc, 0 is set to North.
    private void drawSegments() {
        Group segments = new Group();
        double startAngle = START_ANGLE;
        for (int i = 0; i < 37; i++) {
            Arc arc = new Arc();
            arc.setStroke(Color.GOLD);
            if (i == 0) {
                arc.setFill(Color.GREEN);
            }
            else if (i % 2 == 0) {
                arc.setFill(Color.RED);
            }
            else {
                arc.setFill(Color.BLACK);
            }
            arc.setCenterX(400.0f);
            arc.setCenterY(400.0f);
            arc.setRadiusX(300.0f);
            arc.setRadiusY(300.0f);
            arc.setStartAngle(startAngle);
            arc.setLength(ANGLE);
            arc.setType(ArcType.ROUND);
            segments.getChildren().add(arc);
            startAngle += ANGLE;
        }
        wheel.getChildren().add(segments);
    }
    // Draws the numbers on top of the segments using the NumberSet.
    private void drawNumbers() {
        Group text = new Group();
        for (Number n : numberSet.getNumberSet()) {
            Text textNode = new Text(""+n.getNumber());
            int centreX = 400;
            int centreY = 380;
            int radius = 270;
            double angleText = (180+n.getAngle());
            textNode.setFill(Color.WHITE);
            textNode.setFont(Font.font ("Tahoma", 20));
            double x = centreX + radius * (Math.cos((n.getAngle()+88) * Math.PI / 180f));
            double y = centreY + radius * (Math.sin((n.getAngle()+88) * Math.PI / 180f));
            textNode.relocate(x, y);
            textNode.getTransforms().add(new Rotate(angleText));
            text.getChildren().add(textNode);
        }
        wheel.getChildren().add(text);
    }
    // Draws decoration around wheel.
    private void drawDecorationBottom() {
        Group decoration = new Group();

        Circle outerBorder = new Circle(400, 400, 350);
        outerBorder.setFill(Color.SADDLEBROWN);
        outerBorder.setStroke(Color.GOLD);
        outerBorder.setEffect(dropShadow());

        decoration.getChildren().add(outerBorder);

        wheel.getChildren().add(decoration);
    }
    // Draws decoration on top of wheel.
    private void drawDecorationTop() {
        Group decoration = new Group();

        Circle wheelCentre = new Circle(400, 400, 200);
        wheelCentre.setStroke(Color.GOLD);
        wheelCentre.setFill(Color.SADDLEBROWN);
        wheelCentre.setEffect(dropShadow());
        decoration.getChildren().add(wheelCentre);

        Circle wire = new Circle(400, 400, 260);
        wire.setFill(Color.TRANSPARENT);
        wire.setStroke(Color.GOLD);
        decoration.getChildren().add(wire);

        Circle circle = new Circle(400, 400, 50);
        Rectangle rec1 = new Rectangle(395, 300, 10, 200);
        Rectangle rec2 = new Rectangle(300, 395, 200, 10);
        Stop[] stops = new Stop[] { new Stop(0, Color.WHITE), new Stop(1, Color.GOLD)};
        LinearGradient lg1 = new LinearGradient(0, 0, 50, 50, false, CycleMethod.REFLECT, stops);
        Shape rec = Shape.union(rec1, rec2);
        Shape centerJobby = Shape.union(rec, circle);
        centerJobby.setFill(lg1);
        centerJobby.setEffect(dropShadow());
        decoration.getChildren().add(centerJobby);

        wheel.getChildren().add(decoration);
    }

    private DropShadow dropShadow() {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(40.0);
        return dropShadow;
    }
}