package com.melissadata.globalphone.model;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GlobalPhoneOptions {

    private final StringProperty optionVerifyPhone;
    private final StringProperty optionDefaultCallingCode;
    private final StringProperty optionTimeToWait;
    private final StringProperty optionCallerID;

    public GlobalPhoneOptions() {
        optionVerifyPhone = new SimpleStringProperty("");
        optionDefaultCallingCode = new SimpleStringProperty("");
        optionTimeToWait = new SimpleStringProperty("");
        optionCallerID = new SimpleStringProperty("");
    }

    public String generateOptionString() {
        List<String> optionList = new ArrayList<>();

        if(!getOptionVerifyPhone().equals(""))
            optionList.add("VerifyPhone:" + getOptionVerifyPhone());

        if(!getOptionDefaultCallingCode().equals(""))
            optionList.add("DefaultCallingCode:" + getOptionDefaultCallingCode());

        if(!getOptionTimeToWait().equals(""))
            optionList.add("TimeToWait:" + getOptionTimeToWait());

        if(!getOptionCallerID().equals(""))
            optionList.add("CallerID:" + getOptionCallerID());

        return String.join(",", optionList);
    }

    public String getOptionVerifyPhone() {
        return optionVerifyPhone.get();
    }

    public StringProperty optionVerifyPhoneProperty() {
        return optionVerifyPhone;
    }

    public void setOptionVerifyPhone(String optionVerifyPhone) {
        this.optionVerifyPhone.set(optionVerifyPhone);
    }

    public String getOptionDefaultCallingCode() {
        return optionDefaultCallingCode.get();
    }

    public StringProperty optionDefaultCallingCodeProperty() {
        return optionDefaultCallingCode;
    }

    public void setOptionDefaultCallingCode(String optionDefaultCallingCode) {
        this.optionDefaultCallingCode.set(optionDefaultCallingCode);
    }

    public String getOptionTimeToWait() {
        return optionTimeToWait.get();
    }

    public StringProperty optionTimeToWaitProperty() {
        return optionTimeToWait;
    }

    public void setOptionTimeToWait(String optionTimeToWait) {
        this.optionTimeToWait.set(optionTimeToWait);
    }

    public String getOptionCallerID() {
        return optionCallerID.get();
    }

    public StringProperty optionCallerIDProperty() {
        return optionCallerID;
    }

    public void setOptionCallerID(String optionCallerID) {
        this.optionCallerID.set(optionCallerID);
    }
}
