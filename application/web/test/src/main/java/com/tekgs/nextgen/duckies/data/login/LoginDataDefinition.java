package com.tekgs.nextgen.duckies.data.login;

import com.google.gson.Gson;

public class LoginDataDefinition implements LoginDataCalibratable {
    private int failurePercentage;

    public static LoginDataDefinition getInstance() {
        return new LoginDataDefinition();
    }

    @Override
    public Integer getFailurePercentage() {
        return failurePercentage;
    }

    public LoginData toLoginData() {
        return LoginData.getInstance(this);
    }

    public LoginDataDefinition withFailurePercentage(int failurePercentage) {
        this.failurePercentage = failurePercentage;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), new Gson().toJson(this));
    }
}
