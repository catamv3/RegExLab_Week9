package com.example.regexlab_week9;

import com.example.regexlab_week9.Controllers.DisplayController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Controller class to handle processes related to the registration form fxml.
 * This file uses RegEx to validate user input data.
 */
public class RegistrationController {
    //declare class members
    @FXML
    private Label fscidLabel, nameLabel, emailLabel, majorLabel, passwordLabel;

    @FXML
    private TextField fscidField, nameField, emailField, majorField, passwordField;

    @FXML
    private Button createAccountButton;
    private boolean flag;

    /**
     * this method initializes the registration controller with text fields that will validate their respective
     * informaiton before a user can proceed to the next to add more data.
     */
    public void initialize() {

        fscidField.setOnKeyPressed(e ->{
            if (e.getCode() != KeyCode.TAB && flag) {
                fscidField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                fscidLabel.setText("");

                flag = false;
            }
        } );

        fscidField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("FSCID text is focused");
            } else {
                if (fscidField.getText().matches("[a-z][a-z0-9]{2,6}")) {
                    nameField.setEditable(true);
                    fscidField.setBorder(null);
                } else
                //if there is an error with the users data, change the appearance of the box
                //show on the screen that the user's name is invalid
                //update flag
                {
                    fscidField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    fscidField.setVisible(true);
                    fscidField.requestFocus();
                    fscidLabel.setText(fscidField.getText() + " is not valid FSC ID");
                    nameField.setEditable(false);
                    emailField.setEditable(false);
                    majorField.setEditable(false);
                    passwordField.setEditable(false);
                    flag = true;
                }

            }
        });





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
                nameLabel.setText("");

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
                    nameLabel.setText(nameField.getText() + " is not valid name");
                    emailField.setEditable(false);
                    majorField.setEditable(false);
                    passwordField.setEditable(false);
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
                    majorField.setEditable(true);
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
                    majorField.setEditable(false);
                    passwordField.setEditable(false);
                    flag = true;
                }

            }
        });

        /**
         * this lambda expression does not allow the user to advance to the next birthday if there is an error in their input
         * the flag relates to the flag (if any), produced when the input is compared to the regex.
         */
        majorField.setOnKeyPressed(event -> {
            if (event.getCode() != KeyCode.TAB && flag) {
                majorField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                majorField.setText("");

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
        majorField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("major field is focused");
            } else {
                //bday format
                if (majorField.getText().toUpperCase().matches("[A-Z]{3}")) {
                    majorField.setEditable(true);
                    majorField.setBorder(null);
                } else
                //if there is an error with the users data, change the appearance of the box
                //show on the screen that the user's bday is invalid
                //update flag
                {
                    majorField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    majorField.setVisible(true);
                    majorField.requestFocus();
                    majorLabel.setText(majorField.getText() + " is not valid major");
                    passwordField.setEditable(false);
                    flag = true;
                }
            }
        });


        /**
         * this lambda expression does not allow the user to advance to the next zipField if there is an error in their input
         * the flag relates to the flag (if any), produced when the input is compared to the regex.
         */
        passwordField.setOnKeyPressed(event -> {
            if (event.getCode() != KeyCode.TAB && flag) {
                passwordField.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                passwordField.setText("");

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
        passwordField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("password field is focused");
            } else {
                //zip format "117-XX"
                if (passwordField.getText().matches(("^(?=.*[A-Z])(?=.*\\d.*\\d)[A-Za-z\\d]{5,10}$"))) {
                    createAccountButton.setOnAction(event -> {

                        try {
                            //loading the fxml file
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("displayView.fxml"));
                            //declare a new root w that fxml file
                            Parent root = fxmlLoader.load();
                            DisplayController controller = fxmlLoader.getController();
                            controller.setUserInfo(fscidField.getText(), nameField.getText(), emailField.getText(), majorField.getText(), passwordField.getText());

                            Scene scene = new Scene(root, 850, 560);
                            Stage stage = (Stage) createAccountButton.getScene().getWindow();
                            scene.getStylesheets().add("sunset.css");
                            stage.setScene(scene);
                            stage.show();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }


                    });
                    passwordField.setBorder(null);
                } else
                //if there is an error with the users data, change the appearance of the box
                //show on the screen that the user's zip is invalid
                //update flag
                {
                    passwordField.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    passwordField.setVisible(true);
                    passwordField.requestFocus();
                    passwordField.setText(passwordField.getText() + " is not valid passsword");
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

//    @FXML
//    public void checkUserName(){
//        String userName;
//        do{
//            String namePattern = "[A-Za-z]{2,12}[\\s][A-Za-z]{2,13}";
//            userName = nameField.getText();
//            Pattern nPattern = Pattern.compile(namePattern);
//            flag = userName.matches(namePattern);
//
//            if(!flag) {
//                //System.out.println("Invalid data");
//                addOutputLabel.setText("INVALID ENTRY");
//                nameField.setText("");
//                flag = userName.matches(namePattern);
//            }
//        } while (!flag);
//            System.out.println("valid data");
//            addOutputLabel.setText("valid");
//    }
//
//    /*
//
//        TRIGGER THE CHECK WHEN IN FOCUS, DELETE WHEN OUT OF FOCUS
//
//        if the email is invalid, the cursor cant select another field
//        also change the color/view of the tetxfield (in method setStyleclass);
//
//     */
//
//    /**
//     * This method check
//     */
//    @FXML
//    public void checkEmail(){
//        boolean flag;
//        String email;
//        do{
//            String namePattern = "[a-z][a-z0-9]{2,6}@farmingdale.edu";
//            email = emailField.getText();
//            Pattern nPattern = Pattern.compile(namePattern);
//            flag = email.matches(namePattern);
//
//            if(!flag) {
//                //System.out.println("Invalid data");
//                addOutputLabel.setText("INVALID ENTRY");
//                nameField.setText("");
//                flag = email.matches(namePattern);
//            }
//        } while (!flag);
//        System.out.println("valid data");
//        addOutputLabel.setText("valid");
//    }



}