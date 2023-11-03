package com.example.regexlab_week9;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("registrationForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 560);
        scene.getStylesheets().add("sunset.css");
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


}