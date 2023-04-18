package com.tekgs.nextgen.duckies.view.paymentsubmission;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.duckies.data.cart.Cart;
import com.tekgs.nextgen.duckies.data.payment.PaymentData;
import com.tekgs.nextgen.duckies.view.DuckiesView;
import com.tekgs.nextgen.duckies.view.puchaseconfirmation.PurchaseConfirmationView;

public class PaymentSubmissionView extends DuckiesView implements PaymentSubmissionViewCalibratable {
    public static final String RELATIVE_URL = "payment-submission";
    private static final String LOCATOR_VALUE = "payment-submission";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String DESCRIPTION = "'Payment Submission' view";

    public PaymentSubmissionView() {
        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }


    public static PaymentSubmissionView directNav() {
        new PaymentSubmissionView().load();
        return UiView.expect(PaymentSubmissionView.class);
    }

    public static PaymentSubmissionView directNav(Cart cart) {
        new PaymentSubmissionView().load(String.format("?total=%s", cart.getTotal()));
        return UiView.expect(PaymentSubmissionView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }

    public PurchaseConfirmationView submit(PaymentData paymentData) {
        getAmountElement().set(String.format("%d", paymentData.getAmount()));
        getCurrencyElement().set(PaymentData.getCurrency());
        getSourceElement().set(PaymentData.getSource());
        getSubmitElement().click();
        return UiView.expect(PurchaseConfirmationView.class);
    }

    private UiElement getAmountElement() {
        return getViewElementByName("Amount", "amount");
    }

    private UiElement getCurrencyElement() {
        return getViewElementByName("Currency", "currency");
    }

    private UiElement getSourceElement() {
        return getViewElementByName("Source", "source");
    }

    private UiElement getSubmitElement() {
        return getViewElementById("'Submit' button", "submit");
    }
    private UiElement getTotalOwedElement() {
        return getViewElementById("Total Owed", "total-owed");
    }
    @Override
    public String getTotalOwed() {
        return getTotalOwedElement().getText();
    }


}
