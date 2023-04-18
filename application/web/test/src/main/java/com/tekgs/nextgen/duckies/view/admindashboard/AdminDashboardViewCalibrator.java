package com.tekgs.nextgen.duckies.view.admindashboard;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.duckies.view.admindashboard.loginfailure.LoginFailureReportCalibrator;

public class AdminDashboardViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Admin Dashboard' view";
    private final AdminDashboardView actual;
    private final AdminDashboardViewExpected expected;

    private AdminDashboardViewCalibrator(AdminDashboardViewExpected expected, AdminDashboardView actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
        addChildCalibrator(LoginFailureReportCalibrator.getInstance(expected.inLoginFailureReport(), actual.inLoginFailureReport()));
    }

    public static AdminDashboardViewCalibrator getInstance(AdminDashboardViewExpected expected, AdminDashboardView actual) {
        return new AdminDashboardViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Title", expected.getTitle(), actual.getTitle());
    }
}
