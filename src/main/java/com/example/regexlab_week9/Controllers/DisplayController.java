package com.example.regexlab_week9.Controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;

/**
 * This class stores information for the displayController sued to show information about an individual.
 */
public class DisplayController {//open class
    private String name, email, birthday, zip;
    @FXML
    private Label nameLabel, emailLabel, bdayLabel, zipLabel;

    /**
     * This is a default constructor.
     */
    public DisplayController(){
    }

    /**
     * this is a parameritized constructor for a DisplayController object.
     * this will instantiate a DisplayController with readily available values to be used to display on the screen.
     * @param n name
     * @param e email
     * @param b birthday
     * @param z zip
     */
    public DisplayController(String n,String e,String b,String z){
        nameLabel.setText(n);
        emailLabel.setText(e);
        bdayLabel.setText(b);
        zipLabel.setText(z);
    }

    /**
     * initialize method.
     */
    public void initialize(){
    }


    public void setUserInfo(String name, String email, String birthday, String zip) {
        nameLabel.setText(name);
        emailLabel.setText(email);
        bdayLabel.setText(birthday);
        zipLabel.setText(zip);
    }

}