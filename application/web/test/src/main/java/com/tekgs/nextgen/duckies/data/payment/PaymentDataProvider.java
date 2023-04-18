package com.tekgs.nextgen.duckies.data.payment;

public class PaymentDataProvider {
    public static PaymentDataProvider getInstance() {
        return new PaymentDataProvider();
    }

    public PaymentData get() {
        return PaymentData.getInstance();
    }

    public PaymentData get(PaymentDataDefinition paymentDefinition) {
        return paymentDefinition.toPayment();
    }
}
