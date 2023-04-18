package com.tekgs.nextgen.duckies.view.paymentsubmission;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class PaymentSubmissionViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'purchase submission' view";
    private final PaymentSubmissionViewExpected expected;
    private final PaymentSubmissionView actual;

    protected PaymentSubmissionViewCalibrator(PaymentSubmissionViewExpected expected, PaymentSubmissionView actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static PaymentSubmissionViewCalibrator getInstance(PaymentSubmissionViewExpected expected, PaymentSubmissionView actual) {
        return new PaymentSubmissionViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Total owed", expected.getTotalOwed(), actual.getTotalOwed());
    }
}
