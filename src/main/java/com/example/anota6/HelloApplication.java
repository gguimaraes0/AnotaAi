package com.example.anota6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TelaInicialEscolhaLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Anota Aí");
        //stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("Logo.png")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}