package com.tekgs.nextgen.duckies.view.admindashboard;

import com.tekgs.nextgen.duckies.data.login.LoginData;
import com.tekgs.nextgen.duckies.data.login.LoginDataDefinition;
import com.tekgs.nextgen.duckies.data.login.LoginDataProvider;
import com.tekgs.nextgen.duckies.view.admindashboard.loginfailure.LoginFailureReportCalibratable;
import com.tekgs.nextgen.duckies.view.admindashboard.loginfailure.LoginFailureReportExpected;

public class AdminDashboardViewExpected implements AdminDashboardViewCalibratable {
    private final LoginData loginData;

    private AdminDashboardViewExpected(LoginData loginData) {
        this.loginData = loginData;
    }

    public static AdminDashboardViewExpected getInstance(LoginData loginData) {
        return new AdminDashboardViewExpected(loginData);
    }

    @Override
    public String getTitle() {
        return "Admin Dashboard";
    }

    @Override
    public LoginFailureReportExpected inLoginFailureReport() {
        return LoginFailureReportExpected.getInstance(loginData);
    }
}
