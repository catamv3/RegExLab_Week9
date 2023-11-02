package com.example.regexlab_week9;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HelloController {
    @FXML
    private Label welcomeText, addOutputLabel;

    @FXML
    private TextField nameField, emailField, bdayField, zipField;


    @FXML
    public void checkUserName(){
        boolean flag;
        String userName;
        do{
            String namePattern = "[A-Za-z]{2,12}[\\s][A-Za-z]{2,13}";
            userName = nameField.getText();
            Pattern nPattern = Pattern.compile(namePattern);
            flag = userName.matches(namePattern);

            if(!flag) {
                //System.out.println("Invalid data");
                addOutputLabel.setText("INVALID ENTRY");
                nameField.setText("");
                flag = userName.matches(namePattern);
            }
        } while (!flag);
            System.out.println("valid data");
            addOutputLabel.setText("valid");
    }

    @FXML
    public void checkEmail(){
        boolean flag;
        String email;
        do{
            String namePattern = "[a-z][a-z0-9]{2,6}@farmingdale.edu";
            email = emailField.getText();
            Pattern nPattern = Pattern.compile(namePattern);
            flag = email.matches(namePattern);

            if(!flag) {
                //System.out.println("Invalid data");
                addOutputLabel.setText("INVALID ENTRY");
                nameField.setText("");
                flag = email.matches(namePattern);
            }
        } while (!flag);
        System.out.println("valid data");
        addOutputLabel.setText("valid");
    }



}