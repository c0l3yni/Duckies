package com.tekgs.nextgen.duckies.user.cart;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.duckies.user.cart.item.CartItemCalibratable;
import com.tekgs.nextgen.duckies.user.cart.item.CartItemCalibrator;
import com.tekgs.nextgen.duckies.user.cart.request.CartResponseCalibrator;

import java.util.ArrayList;
import java.util.List;

public class CartCalibrator extends Calibrator {
    private static final String DESCRIPTION = "Cart";
    private final CartCalibratable expected;
    private final CartCalibratable actual;

    private CartCalibrator(CartCalibratable expected, CartCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
        List<CartItemCalibratable> cartItemsExpected = getCartItemCalibratableList(this.expected);
        List<CartItemCalibratable> cartItemsActual = getCartItemCalibratableList(this.actual);
        addCalibrationsExpected(cartItemsExpected, cartItemsActual);
        addCalibrationsUnexpected(cartItemsActual);
    }

    public static CartCalibrator getInstance(CartCalibratable expected, CartCalibratable actual) {
        return new CartCalibrator(expected, actual);
    }

    private static List<CartItemCalibratable> getCartItemCalibratableList(CartCalibratable cart) {
        List<CartItemCalibratable> cartItemsActual = new ArrayList<>();
        if (cart != null) {
            cartItemsActual.addAll(cart.getItems());
        }
        return cartItemsActual;
    }

    private void addCalibrationsExpected(List<CartItemCalibratable> cartItemsExpected, List<CartItemCalibratable> cartItemsActual) {
        for (CartItemCalibratable item : cartItemsExpected) {
            CartItemCalibratable itemFound = null;
            for (CartItemCalibratable candidate : cartItemsActual) {
                if (candidate.equivalent(item)) {
                    itemFound = candidate;
                    addChildCalibrator(CartItemCalibrator.getInstance(item, itemFound));
                    break;
                }
            }
            if (itemFound == null) {
                addChildCalibrator(CartItemCalibrator.getInstance(item, null));
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
        verify("Is 'id' set", expected.isIdSet(), actual.isIdSet());
    }
}
