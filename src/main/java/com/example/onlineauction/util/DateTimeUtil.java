package com.example.onlineauction.util;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static void setupDateTimeUpdate(Label dateTimeLabel) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateDateTimeLabel(dateTimeLabel)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private static void updateDateTimeLabel(Label dateTimeLabel) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        dateTimeLabel.setText(formattedDateTime);
    }
}

