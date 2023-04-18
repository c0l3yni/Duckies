package com.tekgs.nextgen.duckies.data.cart;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.duckies.data.cart.item.CartItemCalibratable;
import com.tekgs.nextgen.duckies.data.cart.item.CartItemCalibrator;
import java.util.ArrayList;
import java.util.List;

public class CartCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Cart' data";

    private CartCalibrator(CartExpected expected, Cart actual) {
        super(DESCRIPTION, expected, actual);
        List<CartItemCalibratable> cartItemsExpected = expected.getItems();
        List<CartItemCalibratable> cartItemsActual = new ArrayList<>(actual.getItems());
        addCalibrationsExpected(cartItemsExpected, cartItemsActual);
        addCalibrationsUnexpected(cartItemsActual);
    }

    public static CartCalibrator getInstance(CartExpected expected, Cart actual) {
        return new CartCalibrator(expected, actual);
    }

    private void addCalibrationsExpected(List<CartItemCalibratable> cartItemsExpected, List<CartItemCalibratable> cartItemsActual) {
        for (CartItemCalibratable expectedItem : cartItemsExpected) {
            CartItemCalibratable itemFound = null;
            for (CartItemCalibratable candidate : cartItemsActual) {
                if (candidate.equivalent(expectedItem)) {
                    itemFound = candidate;
                    addChildCalibrator(CartItemCalibrator.getInstance(expectedItem, itemFound));
                    break;
                }
            }
            if (itemFound == null) {
                addChildCalibrator(CartItemCalibrator.getInstance(expectedItem, null));
            } else {
                cartItemsActual.remove(itemFound);
            }
        }
    }

    private void addCalibrationsUnexpected(List<CartItemCalibratable> unexpectedItems) {
        for (CartItemCalibratable unexpectedItem : unexpectedItems) {
            addChildCalibrator(CartItemCalibrator.getInstance(null, unexpectedItem));
        }
    }

    @Override
    protected void executeVerifications() {

    }
}
