package com.tekgs.nextgen.duckies.data.login;

public class LoginData implements LoginDataCalibratable{
    private final Integer failurePercentage;

    private LoginData(LoginDataDefinition loginDataDefinition) {
        this.failurePercentage = loginDataDefinition.getFailurePercentage();
    }

    public static LoginData getInstance(LoginDataDefinition loginDataDefinition) {
        return new LoginData(loginDataDefinition);
    }

    @Override
    public Integer getFailurePercentage() {
        return failurePercentage;
    }

    public String getFailurePercentageFormatted() {
        return failurePercentage + "%";
    }
}
