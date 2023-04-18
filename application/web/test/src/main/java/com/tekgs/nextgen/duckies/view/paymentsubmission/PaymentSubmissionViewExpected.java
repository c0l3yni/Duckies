package com.tekgs.nextgen.duckies.view.paymentsubmission;

import com.tekgs.nextgen.duckies.data.cart.Cart;

public class PaymentSubmissionViewExpected implements PaymentSubmissionViewCalibratable{
    private final Cart cart;

    public PaymentSubmissionViewExpected(Cart cart) {
        this.cart = cart;
    }

    public static PaymentSubmissionViewExpected getInstance(Cart cart) {
        return new PaymentSubmissionViewExpected(cart);
    }

    @Override
    public String getTotalOwed() {
        double centsConvertedToDollars = (double) cart.getTotal() / 100;
        return String.format("$%.2f", centsConvertedToDollars);
    }
}
