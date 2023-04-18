package com.tekgs.nextgen.duckies.view.puchaseconfirmation;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class PurchaseConfirmationViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Purchase Confirmation' view";
    private final PurchaseConfirmationView actual;
    private final PurchaseConfirmationViewExpected expected;

    public PurchaseConfirmationViewCalibrator(PurchaseConfirmationViewExpected expected, PurchaseConfirmationView actual) {
        super(DESCRIPTION, expected, actual);

        this.expected = expected;
        this.actual = actual;
    }

    public static PurchaseConfirmationViewCalibrator getInstance(PurchaseConfirmationViewExpected expected, PurchaseConfirmationView actual) {
        return new PurchaseConfirmationViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Confirmation Message", expected.getConfirmationMessage(), actual.getConfirmationMessage());
    }
}
