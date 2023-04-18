package com.tekgs.nextgen.duckies.view.cart;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.duckies.view.cart.items.CartItemsRegionCalibrator;

public class CartViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Cart' view";
    private final CartView actual;
    private final CartViewExpected expected;

    private CartViewCalibrator(CartViewExpected expected, CartView actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
        UiRegion.suppressConstructionLogging(true);
        addChildCalibrator(CartItemsRegionCalibrator.getInstance(expected.inCartItems(), actual.inCartItems()));
        UiRegion.suppressConstructionLogging(false);
    }

    public static CartViewCalibrator getInstance(CartViewExpected expected, CartView actual) {
        return new CartViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        String checkoutButtonEnabled = "'Checkout Button' enabled";
        String checkoutButtonDisplayed = "'Checkout Button' displayed";
        String emptyCartMessageDisplayed = "Is empty cart message displayed";
        verify(checkoutButtonEnabled, expected.isCheckoutButtonEnabled(), actual.isCheckoutButtonEnabled());
        verify(checkoutButtonDisplayed, expected.isCheckoutButtonDisplayed(), actual.isCheckoutButtonDisplayed());
        verify("Cart Total", expected.getTotal(), actual.getTotal());
        verify(emptyCartMessageDisplayed, expected.isEmptyMessageDisplayed(), actual.isEmptyMessageDisplayed());
    }
}
