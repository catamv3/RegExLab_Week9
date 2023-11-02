module com.example.regexlab_week9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.regexlab_week9 to javafx.fxml;
    exports com.example.regexlab_week9;
}