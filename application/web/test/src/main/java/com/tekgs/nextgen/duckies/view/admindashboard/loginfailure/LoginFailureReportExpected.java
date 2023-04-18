package com.tekgs.nextgen.duckies.view.admindashboard.loginfailure;

import com.tekgs.nextgen.duckies.data.login.LoginData;

public class LoginFailureReportExpected implements LoginFailureReportCalibratable {
    private final LoginData loginData;

    public LoginFailureReportExpected(LoginData loginData) {
        this.loginData = loginData;
    }

    public static LoginFailureReportExpected getInstance(LoginData loginData) {
        return new LoginFailureReportExpected(loginData);
    }

    @Override
    public String getFailurePercentage() {
        return loginData.getFailurePercentageFormatted();
    }
}
