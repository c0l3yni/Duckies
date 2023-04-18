package com.tekgs.nextgen.duckies.view.puchaseconfirmation;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.tekgs.nextgen.duckies.view.DuckiesView;

public class PurchaseConfirmationView extends DuckiesView implements PurchaseConfirmationViewCalibratable {
    public static final String RELATIVE_URL = "purchase-confirmation";
    private static final String LOCATOR_VALUE = "purchase-confirmation";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String DESCRIPTION = "'Purchase Confirmation' view";

    public PurchaseConfirmationView() {
        super(RELATIVE_URL, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    @Override
    protected boolean confirmElementStates() {

        return this.getElement().waitUntilVisible();
    }

    @Override
    public String getConfirmationMessage() {

        return getConfirmationMessageElement().getText();
    }

    private UiElement getConfirmationMessageElement() {
        String description = "Confirmation Message";
        String locatorValue = "confirmation-message";
        return getViewElementById(description, locatorValue);
    }
}
