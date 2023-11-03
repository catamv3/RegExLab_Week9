package com.example.regexlab_week9;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HelloController {
    @FXML
    private Label addOutputLabel, emailLabel, zipLabel, bdayLabel;

    @FXML
    private TextField nameField, emailField, bdayField, zipField;

    @FXML
    private Button addButton;
    private boolean flag;

    public void initialize(){
        nameField.setOnKeyPressed(event -> {

            if (event.getCode() != KeyCode.TAB && flag){
                nameField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                addOutputLabel.setText("");

                flag=false;
            }

        });

        nameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Name text is focused");
            } else {
                if(nameField.getText().matches("[A-Za-z]{2,12}[\\s][A-Za-z]{2,13}"))
                {
                    emailField.setEditable(true);
                    nameField.setBorder(null);
                }
                else
                {
                    nameField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    nameField.setVisible(true);
                    nameField.requestFocus();
                    addOutputLabel.setText(nameField.getText()+ " is not valid name");
                    emailField.setEditable(false);
                    bdayField.setEditable(false);
                    zipField.setEditable(false);
                    flag=true;
                }

            }
        });

        emailField.setOnKeyPressed(event -> {

            if (event.getCode() != KeyCode.TAB && flag){
                emailField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                emailLabel.setText("");

                flag=false;
            }

        });


        emailField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Email text is focused");
            } else {
                if(emailField.getText().matches("[a-z][a-z0-9]{2,6}@farmingdale.edu"))
                {
                    bdayField.setEditable(true);
                    emailField.setBorder(null);
                }
                else
                {
                    emailField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    emailField.setVisible(true);
                    emailField.requestFocus();
                    emailLabel.setText(emailField.getText()+ " is not valid farmingdale email");
                    bdayField.setEditable(false);
                    flag=true;
                }

            }
        });

        bdayField.setOnKeyPressed(event -> {
            if (event.getCode() != KeyCode.TAB && flag){
                bdayField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                bdayLabel.setText("");

                flag=false;
            }
        });


        bdayField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Bday field is focused");
            } else {
                if(bdayField.getText().matches("(((0[1-9]|1[0-2])[\\W]){2}((([1][9])[0-9][0-9])|(([2][0])[0][0-4])))"))
                {
                    zipField.setEditable(true);
                    bdayField.setBorder(null);
                }
                else
                {
                    bdayField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    bdayField.setVisible(true);
                    bdayField.requestFocus();
                    bdayLabel.setText(bdayField.getText()+ " is not valid bday");
                    zipField.setEditable(false);
                    flag=true;
                }
            }
        });

        zipField.setOnKeyPressed(event -> {
            if (event.getCode() != KeyCode.TAB && flag){
                zipField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                zipLabel.setText("");

                flag=false;
            }
        });


        zipField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("ZIP field is focused");
            } else {
                if(zipField.getText().matches("([1][1][7])[0-9][0-9]"))
                {
                    addButton.setOnAction(event -> {

                        try {
                            System.out.println("All user data valid! The button was clicked and the user" +
                                    "is ready to be added to the database!");
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayView.fxml"));
                            Scene scene = new Scene(fxmlLoader.load(), 850, 560);
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        //scene.getStylesheets().add(getClass().getResource("sunset.css").toExternalForm());

                    });
                    zipField.setBorder(null);
                }
                else
                {
                    zipField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    zipField.setVisible(true);
                    zipField.requestFocus();
                    zipLabel.setText(zipField.getText()+ " is not valid ZIP CODE");
                //    zipField.setEditable(false);
                    flag=true;
                }
            }
        });


    }



    @FXML
    public void checkUserName(){
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

    /*

        TRIGGER THE CHECK WHEN IN FOCUS, DELETE WHEN OUT OF FOCUS

        if the email is invalid, the cursor cant select another field
        also change the color/view of the tetxfield (in method setStyleclass);

     */

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