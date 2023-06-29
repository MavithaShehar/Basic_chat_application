module com.example.chatapp02 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chatapp02 to javafx.fxml;
    exports com.example.chatapp02;
}