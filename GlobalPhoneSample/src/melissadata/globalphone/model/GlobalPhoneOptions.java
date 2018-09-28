package melissadata.globalphone.model;

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
        String optionString = "";

        if(!getOptionVerifyPhone().equals(""))
            optionString += "VerifyPhone:" + getOptionVerifyPhone();

        if(!getOptionDefaultCallingCode().equals("") && !optionString.equals(""))
            optionString += ",DefaultCallingCode:" + getOptionDefaultCallingCode();
        else if(!getOptionDefaultCallingCode().equals("") && optionString.equals(""))
            optionString += "DefaultCallingCode:" + getOptionDefaultCallingCode();

        if(!getOptionTimeToWait().equals("") && !optionString.equals(""))
            optionString += ",TimeToWait:" + getOptionTimeToWait();
        else if(!getOptionTimeToWait().equals("") && optionString.equals(""))
            optionString += "TimeToWait:" + getOptionTimeToWait();

        if(!getOptionCallerID().equals("") && !optionString.equals(""))
            optionString += ",CallerID:" + getOptionCallerID();
        else if(!getOptionCallerID().equals("") && optionString.equals(""))
            optionString += "CallerID:" + getOptionCallerID();
        return optionString;
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
