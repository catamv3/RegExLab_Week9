package com.example.regexlab_week9;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DisplayController {
    private String name, email, birthday, zip;

    @FXML
    private Label nam,emai, birthda,zi;

    public DisplayController(){}

    public DisplayController(String n,String e,String b,String z){
        name = n;
        email=e;
        birthday = b;
        zip = z;
    }

    public void initialize(){

    }


}
