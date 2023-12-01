package com.example.regexlab_week9.Controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;

/**
 * This class stores information for the displayController sued to show information about an individual.
 */
public class DisplayController {//open class
    private String fscid, name, email, major, password;
    @FXML
    private Label fscidLabel, nameLabel, emailLabel, majorLabel, passwordLabel;

    /**
     * This is a default constructor.
     */
    public DisplayController(){
        fscid = "";
        name = "";
        email = "";
        major = "";
        password = "";
    }

    /**
     * this is a parameritized constructor for a DisplayController object.
     * this will instantiate a DisplayController with readily available values to be used to display on the screen.
     * @param n name
     * @param e email
     * @param m major
     * @param p password
     * */
    public DisplayController(String i, String n,String e,String m,String p){
        fscidLabel.setText(i);
        nameLabel.setText(n);
        emailLabel.setText(e);
        majorLabel.setText(m);
        passwordLabel.setText(p);
    }

    /**
     * initialize method.
     */
    public void initialize(){
        fscidLabel.setText("");
        nameLabel.setText("");
        majorLabel.setText("");
        emailLabel.setText("");
        passwordLabel.setText("");
    }

    /**
     * This method sets the current controller with the provided values
     * @param name -- user name
     * @param email -- user email
     * @param major -- user bday
     * @param password -- user zip
     */
    public void setUserInfo(String id, String name, String email, String major, String password) {
        fscidLabel.setText(id);
        nameLabel.setText(name);
        emailLabel.setText(email);
        majorLabel.setText(major);
        passwordLabel.setText(password);
    }

}
