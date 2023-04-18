package com.tekgs.nextgen.duckies.view.admindashboard;

import com.tekgs.nextgen.duckies.view.admindashboard.loginfailure.LoginFailureReportCalibratable;

public interface AdminDashboardViewCalibratable {
    String getTitle();

    LoginFailureReportCalibratable inLoginFailureReport();
}
