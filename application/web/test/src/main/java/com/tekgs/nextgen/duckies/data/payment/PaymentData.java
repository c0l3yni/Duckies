package com.tekgs.nextgen.duckies.data.payment;

public class PaymentData implements PaymentDataCalibratable {
    private final int amount;

    public PaymentData(PaymentDataDefinition paymentDataDefinition) {
        this.amount = paymentDataDefinition == null ? 0 : paymentDataDefinition.getAmount();
    }

    public static PaymentData getInstance() {
        return new PaymentData(null);
    }

    public static PaymentData getInstance(PaymentDataDefinition paymentDataDefinition) {
        return new PaymentData(paymentDataDefinition);
    }

    public static String getSource() {
        return "tok_amex";
    }

    public static String getCurrency() {
        return "usd";
    }

    @Override
    public Integer getAmount() {
        return amount;
    }
}
