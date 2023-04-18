package com.tekgs.nextgen.duckies.view.error;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ErrorViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Generic Error' View";
    private final ErrorViewCalibratable expected;
    private final ErrorViewCalibratable actual;

    protected ErrorViewCalibrator(ErrorViewCalibratable expected, ErrorViewCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static ErrorViewCalibrator getInstance(ErrorViewCalibratable expected, ErrorViewCalibratable actual) {
        return new ErrorViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Generic Error Message", expected.getGenericErrorMessage(), actual.getGenericErrorMessage());
    }
}
