module com.example.regexlab_week9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.regexlab_week9 to javafx.fxml;
    exports com.example.regexlab_week9;
    exports com.example.regexlab_week9.Controllers;
    opens com.example.regexlab_week9.Controllers to javafx.fxml;
}