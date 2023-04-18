package com.tekgs.nextgen.duckies.view.cart.items;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.duckies.view.cart.items.item.CartItemRegionCalibratable;
import com.tekgs.nextgen.duckies.view.cart.items.item.CartItemRegionCalibrator;

import java.util.ArrayList;
import java.util.List;

public class CartItemsRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Items' region";

    private CartItemsRegionCalibrator(CartItemsRegionExpected expected, CartItemsRegion actual) {
        super(DESCRIPTION, expected, actual);
        List<CartItemRegionCalibratable> actualItems = new ArrayList<>(actual.getItems());
        for (CartItemRegionCalibratable expectedItem : expected.getItems()) {
            CartItemRegionCalibratable foundItem = null;
            for (CartItemRegionCalibratable candidate : actualItems) {
                if (candidate.equivalent(expectedItem)) {
                    foundItem = candidate;
                    addChildCalibrator(CartItemRegionCalibrator.getInstance(expectedItem, foundItem));
                    break;
                }
            }
            if (foundItem == null) {
                addChildCalibrator(CartItemRegionCalibrator.getInstance(expectedItem, null));
            } else {
                actualItems.remove(foundItem);
            }
        }
        for (CartItemRegionCalibratable unexpected : actualItems) {
            addChildCalibrator(CartItemRegionCalibrator.getInstance(null, unexpected));
        }
    }

    public static CartItemsRegionCalibrator getInstance(CartItemsRegionExpected expected, CartItemsRegion actual) {
        return new CartItemsRegionCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {

    }
}
