package com.tekgs.nextgen.duckies.view.cart.items.item;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class CartItemRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Item' region";
    private final CartItemRegionCalibratable expected;
    private final CartItemRegionCalibratable actual;

    private CartItemRegionCalibrator(CartItemRegionCalibratable expected, CartItemRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static CartItemRegionCalibrator getInstance(CartItemRegionCalibratable expected, CartItemRegionCalibratable actual) {
        return new CartItemRegionCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Is Decrement button displayed", expected.isDecrementButtonDisplayed(), actual.isDecrementButtonDisplayed());
        verify("Is Increment button displayed", expected.isIncrementButtonDisplayed(), actual.isIncrementButtonDisplayed());
        verify("Is Decrement button enabled", expected.isDecrementButtonEnabled(), actual.isDecrementButtonEnabled());
        verify("Is Increment button enabled", expected.isIncrementButtonEnabled(), actual.isIncrementButtonEnabled());
    }
}
