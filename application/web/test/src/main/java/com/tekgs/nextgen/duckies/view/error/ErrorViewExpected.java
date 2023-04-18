package com.tekgs.nextgen.duckies.view.error;

public class ErrorViewExpected implements ErrorViewCalibratable{

    public static ErrorViewExpected getInstance() {
        return new ErrorViewExpected();
    }

    @Override
    public String getGenericErrorMessage() {
        return "Generic Error";
    }
}
