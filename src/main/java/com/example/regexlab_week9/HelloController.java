package com.example.regexlab_week9;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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

/**
 * Controller class to handle processes related to the registration form fxml.
 * This file uses RegEx to validate user input data.
 */
public class HelloController {
    //declare class members
    @FXML
    private Label addOutputLabel, emailLabel, zipLabel, bdayLabel;

    @FXML
    private TextField nameField, emailField, bdayField, zipField;

    @FXML
    private Button addButton;
    private boolean flag;

    /**
     * this method initializes the registration controller with text fields that will validate their respective
     * informaiton before a user can proceed to the next to add more data.
     */
    public void initialize() {

        /**
         * this lambda expression does not allow the user to advance to the next textfield if there is an error in their input
         * the flag relates to the flag (if any), produced when the input is compared to the regex.
         * @parm - this method does not accept any parameters.
         * @return - this method does not return anything
         * @throws - this method at large does not throw any errors, however sub parts of this method may.
         */
        nameField.setOnKeyPressed(event -> {

            if (event.getCode() != KeyCode.TAB && flag) {
                nameField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                addOutputLabel.setText("");

                flag = false;
            }

        });

        /**
         * this method adds a listener to the namefield element. if the data entered does not match the pattern,
         * the user can not advance to the next textfield.
         *
         * Valid names entail a first and last name, seperated by one space. the first name must be between
         * 2 and no more than 12 letters, the last name must be between
         *          * 2 and no more than 13 letters
         */
        nameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Name text is focused");
            } else {
                if (nameField.getText().matches("[A-Za-z]{2,12}[\\s][A-Za-z]{2,13}")) {
                    emailField.setEditable(true);
                    nameField.setBorder(null);
                } else
                //if there is an error with the users data, change the appearance of the box
                //show on the screen that the user's name is invalid
                //update flag
                {
                    nameField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    nameField.setVisible(true);
                    nameField.requestFocus();
                    addOutputLabel.setText(nameField.getText() + " is not valid name");
                    emailField.setEditable(false);
                    bdayField.setEditable(false);
                    zipField.setEditable(false);
                    flag = true;
                }

            }
        });

        /**
         * this lambda expression does not allow the user to advance to the next textfield if there is an error in their input
         * the flag relates to the flag (if any), produced when the input is compared to the regex.
         */
        emailField.setOnKeyPressed(event -> {

            if (event.getCode() != KeyCode.TAB && flag) {
                emailField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                emailLabel.setText("");

                flag = false;
            }

        });

        /**
         * this method adds a listener to the emailField element to validate the user input.
         *
         * Valid email:
         * 1. starts with a letter
         * 2. contains any mix of lowercase letters and digits 0-9
         * 3. must end with @farmingdale.edu
         */
        emailField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Email text is focused");
            } else {
                if (emailField.getText().matches("[a-z][a-z0-9]{2,6}@farmingdale.edu")) {
                    bdayField.setEditable(true);
                    emailField.setBorder(null);
                } else
                //if there is an error with the users data, change the appearance of the box
                //show on the screen that the user's email is invalid
                //update flag
                {
                    emailField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    emailField.setVisible(true);
                    emailField.requestFocus();
                    emailLabel.setText(emailField.getText() + " is not valid farmingdale email");
                    bdayField.setEditable(false);
                    flag = true;
                }

            }
        });

        /**
         * this lambda expression does not allow the user to advance to the next birthday if there is an error in their input
         * the flag relates to the flag (if any), produced when the input is compared to the regex.
         */
        bdayField.setOnKeyPressed(event -> {
            if (event.getCode() != KeyCode.TAB && flag) {
                bdayField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                bdayLabel.setText("");

                flag = false;
            }
        });

        /**
         * this method adds a listener to the bdayField element to validate the user input.
         *
         * Valid birthday:
         * 1. user enters date in format MM/DD/YYYY
         * 2. user must be born between 1900-2004
         * 3. single digit months/days preceeded by 0;
         */
        bdayField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Bday field is focused");
            } else {
                //bday format
                if (bdayField.getText().matches("(((0[1-9]|1[0-2])[\\W]){2}((([1][9])[0-9][0-9])|(([2][0])[0][0-4])))")) {
                    zipField.setEditable(true);
                    bdayField.setBorder(null);
                } else
                //if there is an error with the users data, change the appearance of the box
                //show on the screen that the user's bday is invalid
                //update flag
                {
                    bdayField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    bdayField.setVisible(true);
                    bdayField.requestFocus();
                    bdayLabel.setText(bdayField.getText() + " is not valid bday");
                    zipField.setEditable(false);
                    flag = true;
                }
            }
        });


        /**
         * this lambda expression does not allow the user to advance to the next zipField if there is an error in their input
         * the flag relates to the flag (if any), produced when the input is compared to the regex.
         */
        zipField.setOnKeyPressed(event -> {
            if (event.getCode() != KeyCode.TAB && flag) {
                zipField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                zipLabel.setText("");

                flag = false;
            }
        });

        /**
         * MUST READ:
         * this method adds a listener to the zipField element to validate the user input.
         * in order for the user to proceed to the next screen by tapping the button, all fields must be validated.
         * once the zip is validated, this method should add functionality to the button to switch between screens.
         *
         * Valid Zipcode:
         * 1. begins with "117"
         * 5 digits long (last twp digits are any digit b/w 0-9).
         */
        zipField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("ZIP field is focused");
            } else {
                //zip format "117-XX"
                if (zipField.getText().matches("([1][1][7])[0-9][0-9]")) {
                    addButton.setOnAction(event -> {

                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayView.fxml"));
                            Parent root = fxmlLoader.load();
                            DisplayController controller = fxmlLoader.getController();
                            controller.setUserInfo(nameField.getText(), emailField.getText(), bdayField.getText(), zipField.getText());

                            Scene scene = new Scene(root, 850, 560);
                            Stage stage = (Stage) addButton.getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }


                    });
                    zipField.setBorder(null);
                } else
                //if there is an error with the users data, change the appearance of the box
                //show on the screen that the user's zip is invalid
                //update flag
                {
                    zipField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    zipField.setVisible(true);
                    zipField.requestFocus();
                    zipLabel.setText(zipField.getText() + " is not valid ZIP CODE");
                    //    zipField.setEditable(false);
                    flag = true;
                }
            }
        });
    }

    @FXML
    public void onAddButtonClicked() {
        if (validateUserData()) {
            // If user data is valid, switch to the Display scene

        }
    }

    private boolean validateUserData() {
        // Add your validation logic here and return true if data is valid, false otherwise
        return false;
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

    /**
     * This method check
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