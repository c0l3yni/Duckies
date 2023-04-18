package com.stripe.api;

import com.softwareonpurpose.calibrator4test.Calibrator;

    public class DuckiesChargeCalibrator extends Calibrator {
        private static final String DESCRIPTION = "Charge";
        private final DuckiesCharge actual;
        private final DuckiesChargeExpected expected;

        private DuckiesChargeCalibrator(DuckiesChargeExpected expected, DuckiesCharge actual) {
            super(DESCRIPTION, expected, actual);
            this.actual = actual;
            this.expected = expected;
        }

        public static DuckiesChargeCalibrator getInstance(DuckiesChargeExpected expected, DuckiesCharge actual) {
            return new DuckiesChargeCalibrator(expected, actual);
        }

        @Override
    protected void executeVerifications() {
            verify("Is payment successful", expected.isPaymentSuccessful(), actual.isPaymentSuccessful());
    }
}
