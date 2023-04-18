package com.stripe.api;

public class DuckiesChargeExpected implements DuckiesChargeCalibratable {
    private final Boolean isPaymentSuccessful;

    public DuckiesChargeExpected(long amount) {
        isPaymentSuccessful = amount > 49L && amount < 100000000L;
    }

    public static DuckiesChargeExpected getInstance(long amount) {
        return new DuckiesChargeExpected(amount);
    }

    @Override
    public Boolean isPaymentSuccessful() {
        return isPaymentSuccessful;
    }
}
