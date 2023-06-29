package com.example.chatapp02;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {

    @FXML
    private TextArea ServerTxtArea;

    @FXML
    private TextField ServerTxtField;

    ServerSocket serverSocket;
    Socket socket;

    DataInputStream dataInputStream ;
    DataOutputStream dataOutputStream ;

    String message = "" ;

    public void initialize(){

        new Thread(()->{
            try {
                serverSocket = new ServerSocket(4005);
                ServerTxtArea.appendText("server started !");
                socket = serverSocket.accept();
                ServerTxtArea.appendText("\nClient Acceptet !");
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                while (!message.equals("finish")){
                    message=dataInputStream.readUTF();
                    ServerTxtArea.appendText("\nClient :"+message);
                    ServerTxtField.setText(" ");
                }

            } catch (IOException e) {
               throw new RuntimeException(e);
            }

        }).start();
    }

    public void ServerOnAction(ActionEvent actionEvent) throws IOException {

        dataOutputStream.writeUTF(ServerTxtField.getText().trim());
        dataOutputStream.flush();
        ServerTxtField.setText(" ");

    }
}
