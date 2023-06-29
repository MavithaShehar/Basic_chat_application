package com.example.chatapp02;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientController {

    @FXML
    private TextArea ClientTxtArea;

    @FXML
    private Button ClientButt;

    @FXML
    private TextField ClientTxtFileld;

    ServerSocket serverSocket;
    Socket socket;

    DataInputStream dataInputStream ;
    DataOutputStream dataOutputStream ;

    String message ="" ;

    public void initialize(){

        new Thread(()->{

            try {
                socket = new Socket("localhost",4005);
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                while (!message.equals("finish")){
                    message=dataInputStream.readUTF();
                    ClientTxtArea.appendText("\nServer :"+message);
                    ClientTxtFileld.setText("");

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }).start();

    }

    @FXML
    void ClientButtOnAction(ActionEvent event) throws IOException {

        dataOutputStream.writeUTF(ClientTxtFileld.getText().trim());
        dataOutputStream.flush();
        ClientTxtFileld.setText("");

    }

}
