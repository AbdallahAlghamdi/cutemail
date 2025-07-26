package io.github.abdallahalghamdi.maillist.ui;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class NewIndicator extends HBox {

    NewIndicator() {
        Color TextColorPrimary = Color.web("#e83048");
        final Color TextColorSecondary = Color.web("#f0f0f0");
        final Background BackgroundColorPrimary = Background.fill(Paint.valueOf("#f08800"));
        final Background BackgroundColorSecondary = Background.fill(Paint.valueOf("#e83048"));
        final Text newText = new Text("NEW");

        newText.setFill(TextColorPrimary);

        getChildren().add(newText);
        setBackground(BackgroundColorPrimary);
        setAlignment(Pos.CENTER);
        setMaxHeight(1);
        setEffect(getShadow());
        setPadding(new Insets(0, 5, 0, 5));
        HBox.setMargin(this, new Insets(0, 10, 0, 10));

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, _ -> {
                    setBackground(BackgroundColorPrimary);
                    newText.setFill(TextColorPrimary);
                }),
                new KeyFrame(Duration.seconds(1), _ -> {
                    setBackground(BackgroundColorSecondary);
                    newText.setFill(TextColorSecondary);
                }));
        timeline.setAutoReverse(true);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private DropShadow getShadow() {
        final Color ShadowColor = Color.web("#a8b0a0");

        DropShadow newBoxShadow = new DropShadow();
        newBoxShadow.setColor(ShadowColor);
        newBoxShadow.setRadius(0);
        newBoxShadow.setOffsetX(3);
        newBoxShadow.setOffsetY(3);
        newBoxShadow.setBlurType(BlurType.ONE_PASS_BOX);

        return newBoxShadow;
    }
}
