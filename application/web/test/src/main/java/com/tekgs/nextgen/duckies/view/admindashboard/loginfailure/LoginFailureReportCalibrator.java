package com.tekgs.nextgen.duckies.view.admindashboard.loginfailure;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class LoginFailureReportCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Login Failure' report";
    private final LoginFailureReport actual;
    private final LoginFailureReportExpected expected;

    private LoginFailureReportCalibrator(LoginFailureReportExpected expected, LoginFailureReport actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
    }

    public static LoginFailureReportCalibrator getInstance(LoginFailureReportExpected expected, LoginFailureReport actual) {
        return new LoginFailureReportCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Login failure percentage", expected.getFailurePercentage(), actual.getFailurePercentage());
    }
}
