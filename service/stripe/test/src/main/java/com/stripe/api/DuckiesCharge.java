package com.stripe.api;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;
import org.softwareonpurpose.gauntlet.Environment;

@SuppressWarnings("unused")
public class DuckiesCharge implements DuckiesChargeCalibratable {
    private final long amount;
    private final String currency;
    private final String source;
    private static final String SUCCEEDED = "succeeded";
    private Charge charge;

    private DuckiesCharge(long amount, String currency, String source) {
        this.amount = amount;
        this.currency = currency;
        this.source = source;
    }

    public static DuckiesCharge getInstance(long amount, String currency, String source) {
        return new DuckiesCharge(amount, currency, source);
    }

    @Override
    public Boolean isPaymentSuccessful() {
        return charge != null && charge.getPaid() && SUCCEEDED.equals(charge.getStatus());
    }

    public DuckiesCharge submit() {
        Stripe.apiKey = Environment.getInstance().getPaymentServiceApiKey();
        ChargeCreateParams chargeParams =
                ChargeCreateParams.builder()
                .setAmount(amount)
                .setCurrency(currency)
                .setSource(source)
                .build();
        try {
            charge = Charge.create(chargeParams);
        } catch (StripeException e) {
            e.printStackTrace();
        }
        return this;
    }
}
