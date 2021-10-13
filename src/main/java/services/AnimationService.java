package services;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class AnimationService {

    public AnimationService() {

    }

    public static void createButtonAnimation(Button button, Label label) {
        button.setOnMouseEntered(e-> enterButton(button, label));
        button.setOnMouseExited(e-> exitButton(button, label));
    }

    private static void background(Color bColor, Color tColor, Button button, javafx.scene.control.Label label) {
        button.setBackground(new Background(new BackgroundFill(bColor, CornerRadii.EMPTY, Insets.EMPTY)));
        button.setTextFill(tColor);
        BorderWidths svdjBorder = new BorderWidths(2, 2, 0, 0);
        Insets svdjInsets = new Insets(0, 0, 0, 10);
        label.setBorder(new Border(new BorderStroke(
                tColor,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                svdjBorder,
                svdjInsets)));
    }

    private static void enterButton(Button button, Label label) {
        final Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(500));
                setInterpolator(Interpolator.EASE_OUT);
            }

            @Override
            protected void interpolate(double frac) {
                Color bColor = new Color(1, 1, 1, frac);
                Color tColor = new Color(0, 0, 0, frac);
                background(bColor, tColor, button, label);
            }
        };
        animation.play();
    }

    private static void exitButton(Button button, Label label) {
        final Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(500));
                setInterpolator(Interpolator.EASE_OUT);
            }

            @Override
            protected void interpolate(double frac) {
                Color bColor = new Color(1, 1, 1, 1 - frac);
                Color tColor = new Color(1, 1, 1, frac);
                background(bColor, tColor, button, label);
            }
        };
        animation.play();

    }
}
