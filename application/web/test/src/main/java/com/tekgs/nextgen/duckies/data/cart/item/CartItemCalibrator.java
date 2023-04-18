package com.tekgs.nextgen.duckies.data.cart.item;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.duckies.data.product.ProductCalibrator;

public class CartItemCalibrator extends Calibrator {
    private static final String DESCRIPTION = "Cart Item";

    private CartItemCalibrator(CartItemCalibratable expected, CartItemCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        if (actual != null && expected != null) {
            addChildCalibrator(ProductCalibrator.getInstance(expected.getProduct(), actual.getProduct()));
        }
    }

    public static CartItemCalibrator getInstance(CartItemCalibratable expected, CartItemCalibratable actual) {
        return new CartItemCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
