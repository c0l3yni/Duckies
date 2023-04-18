package com.tekgs.nextgen.duckies.view.invalidurl;

public class InvalidUrlViewExpected implements InvalidUrlViewCalibratable {

    public static InvalidUrlViewExpected getInstance() {
        return new InvalidUrlViewExpected();
    }

    @Override
    public String getMessage() {
        return "Sorry, page not found!";
    }
}