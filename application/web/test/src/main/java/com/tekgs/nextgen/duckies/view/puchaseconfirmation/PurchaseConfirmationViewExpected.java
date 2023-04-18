package com.tekgs.nextgen.duckies.view.puchaseconfirmation;

public class PurchaseConfirmationViewExpected implements PurchaseConfirmationViewCalibratable {
    public static PurchaseConfirmationViewExpected getInstance() {
        return new PurchaseConfirmationViewExpected();
    }

    @Override
    public String getConfirmationMessage() {
        return "Payment Successful!";
    }
}
