package com.melissadata.globalphone.view;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.melissadata.globalphone.model.GlobalPhoneOptions;
import com.melissadata.globalphone.model.GlobalPhoneTransaction;

public class GlobalPhoneController {
    private com.melissadata.globalphone.Main main;
    private GlobalPhoneOptions option;

    private GlobalPhoneTransaction Transaction;

    @FXML
    private Button buttonSend;
    @FXML
    private Button buttonClear;
    @FXML
    private TabPane tabPane;
    private final int CONFIGURATION_TAB = 0;
    private final int RESPONSE_TAB = 1;



    @FXML
    private TextField inputLicenseKeyText;
    @FXML
    private TextField inputPhoneText;
    @FXML
    private TextField inputCountryText;
    @FXML
    private TextField inputCountryOfOriginText;
    @FXML
    private TextField optionDefaultCallingCodeBox;
    @FXML
    private TextField optionTimeToWaitBox;

    @FXML
    private ComboBox<String> optionVerifyPhoneBox;

    @FXML
    private ComboBox<String> optionCallerIDBox;

    @FXML
    private TextArea RequestTextArea;
    @FXML
    private TextArea ResponseTextArea;

    @FXML
    private RadioButton jsonResponseFormatRadio;
    @FXML
    private RadioButton xmlResponseFormatRadio;
    /**
     * The constructor. The constructor is called before the initialize()
     * method.
     */
    public GlobalPhoneController() {
        Transaction = new GlobalPhoneTransaction();
        option      = new GlobalPhoneOptions();
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
        setupOptionSelections();
        initializeTextFields();
        sendButtonAction();
        clearButtonAction();
        updateRequestText();
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * //@param mainApp
     */
    public void setMainApp(com.melissadata.globalphone.Main main) {
        this.main = main;
    }

    public void sendButtonAction() {
        buttonSend.setOnAction((event) -> {
            ResponseTextArea.setText(Transaction.processTransaction(RequestTextArea.getText()));
            tabPane.getSelectionModel().select(RESPONSE_TAB);
        });
    }

    public void clearButtonAction(){
        buttonClear.setOnAction((event) -> {
            inputPhoneText.clear();
            inputCountryText.clear();
            inputCountryOfOriginText.clear();
            returnToConfiguration();
        });
    }

    public void initializeTextFields(){
        inputLicenseKeyText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setIdentNumber(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        inputPhoneText.textProperty().addListener((observable, oldvalue, newvalue) -> {
            Transaction.setPhone(newvalue);
            updateRequestText();
            returnToConfiguration();
        });

        optionDefaultCallingCodeBox.textProperty().addListener((observable, oldvalue, newvalue) -> {
            option.setOptionDefaultCallingCode(newvalue);
            Transaction.setOptions(option);
            updateRequestText();
            returnToConfiguration();
        });

        optionTimeToWaitBox.textProperty().addListener((observable, oldvalue, newvalue) -> {
            option.setOptionTimeToWait(newvalue);
            Transaction.setOptions(option);
            updateRequestText();
            returnToConfiguration();
        });


    }
    // Define what values each combo box can hold
    private void setupOptionSelections() {
        optionVerifyPhoneBox.setItems(FXCollections.observableArrayList("", "Express", "Premium"));
        //optionDefaultCallingCodeBox.setItems(FXCollections.observableArrayList("", "ON", "OFF"));
        //optionTimeToWaitBox.setItems(FXCollections.observableArrayList("", "1", "2", "5", "10"));
        optionCallerIDBox.setItems(FXCollections.observableArrayList("", "False", "True"));

    }

    public void setOptionVerifyPhoneBox() {
        option.setOptionVerifyPhone(optionVerifyPhoneBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    public void setOptionCallerIDBox() {
        option.setOptionCallerID(optionCallerIDBox.getValue());
        Transaction.setOptions(option);
        updateRequestText();
        returnToConfiguration();
    }

    private void returnToConfiguration(){
        if(tabPane.getSelectionModel().getSelectedIndex() != 0)	tabPane.getSelectionModel().select(CONFIGURATION_TAB);
    }

    private void updateRequestText(){
        RequestTextArea.setText(Transaction.generateRequestString());
    }

    public TextField getInputLicenseKeyText() {
        return inputLicenseKeyText;
    }

    public void setInputLicenseKeyText(TextField inputLicenseKeyText) {
        this.inputLicenseKeyText = inputLicenseKeyText;
    }

    public TextField getInputPhoneText() {
        return inputPhoneText;
    }

    public void setInputPhoneText(TextField inputPhoneText) {
        this.inputPhoneText = inputPhoneText;
    }

    public TextField getOptionTimeToWaitBox() {
        return optionTimeToWaitBox;
    }

    public void setOptionTimeToWaitBox(TextField optionTimeToWaitBox) {
        this.optionTimeToWaitBox = optionTimeToWaitBox;
    }

    public ComboBox<String> getOptionVerifyPhoneBox() {
        return optionVerifyPhoneBox;
    }

    public void setOptionVerifyPhoneBox(ComboBox<String> optionVerifyPhoneBox) {
        this.optionVerifyPhoneBox = optionVerifyPhoneBox;
    }

    public TextField getOptionDefaultCallingCodeBox() {
        return optionDefaultCallingCodeBox;
    }


    public void setOptionDefaultCallingCodeBox(TextField optionDefaultCallingCodeBox) {
        this.optionDefaultCallingCodeBox = optionDefaultCallingCodeBox;
    }

    public ComboBox<String> getOptionCallerIDBox() {
        return optionCallerIDBox;
    }

    public void setOptionCallerIDBox(ComboBox<String> optionCallerIDBox) {
        this.optionCallerIDBox = optionCallerIDBox;
    }

}
