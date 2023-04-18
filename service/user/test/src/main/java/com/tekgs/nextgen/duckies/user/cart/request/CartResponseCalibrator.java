package com.tekgs.nextgen.duckies.user.cart.request;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.duckies.user.cart.CartCalibratable;
import com.tekgs.nextgen.duckies.user.cart.CartCalibrator;

import java.util.ArrayList;
import java.util.List;

public class CartResponseCalibrator extends Calibrator {
    private static final String DESCRIPTION = "Cart Response";
    private final CartResponseExpected expected;
    private final CartResponse actual;

    private CartResponseCalibrator(CartResponseExpected expected, CartResponse actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
        if (actual != null && expected != null) {
            List<CartCalibratable> CartListExpected = expected.getCarts();
            List<CartCalibratable> CartListActual = new ArrayList<>(actual.getCarts());
            addCalibrationsExpected(CartListExpected, CartListActual);
            addCalibrationsUnexpected(CartListActual);
        }
    }

    public static CartResponseCalibrator getInstance(CartResponseExpected expected, CartResponse actual) {
        return new CartResponseCalibrator(expected, actual);
    }

    private void addCalibrationsExpected(List<CartCalibratable> CartListExpected, List<CartCalibratable> CartListActual) {
        for (CartCalibratable expectedCart : CartListExpected) {
            CartCalibratable cartFound = null;
            for (CartCalibratable candidate : CartListActual) {
                if (candidate != null && candidate.equivalent(expectedCart)) {
                    cartFound = candidate;
                    addChildCalibrator(CartCalibrator.getInstance(expectedCart, cartFound));
                    break;
                }
            }
            if (cartFound == null) {
                addChildCalibrator(CartCalibrator.getInstance(expectedCart, null));
            } else {
                CartListActual.remove(cartFound);
            }
        }
    }

    private void addCalibrationsUnexpected(List<CartCalibratable> unexpectedCartList) {
        for (CartCalibratable unexpectedCart : unexpectedCartList) {
            addChildCalibrator(CartCalibrator.getInstance(null, unexpectedCart));
        }
    }

    @Override
    protected void executeVerifications() {
        verify("Status Code", expected.getStatusCode(), actual.getStatusCode());
    }
}
