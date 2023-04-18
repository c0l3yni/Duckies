package com.tekgs.nextgen.duckies.view.invalidurl;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class InvalidUrlViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Invalid Url' view";
    private final InvalidUrlView actual;
    private final InvalidUrlViewExpected expected;

    private InvalidUrlViewCalibrator(InvalidUrlViewExpected expected, InvalidUrlView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static InvalidUrlViewCalibrator getInstance(InvalidUrlViewExpected expected, InvalidUrlView actual) {
        return new InvalidUrlViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("404 Message", expected.getMessage(), actual.getMessage());
    }
}