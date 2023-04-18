package com.tekgs.nextgen.duckies.data.payment;

import com.google.gson.Gson;

public class PaymentDataDefinition implements PaymentDataCalibratable {
    private int amount;

    public static PaymentDataDefinition getInstance() {
        return new PaymentDataDefinition();
    }

    public PaymentDataDefinition withAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public PaymentData toPayment() {
        return PaymentData.getInstance(this);
    }

    @Override
    public Integer getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("PaymentDataDefinition %s", new Gson().toJson(this));
    }
}
