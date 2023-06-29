package com.example.chatapp02;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientInitializer extends Application {

    public static void main(String[] args) {

        launch(args);
    }



    @Override
    public void start(Stage stage) throws Exception {

        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("Client.FXML"))));
        stage.show();

    }
}
