package com.tekgs.nextgen.duckies.user.cart.request;

import com.tekgs.nextgen.duckies.user.cart.CartCalibratable;
import com.tekgs.nextgen.duckies.user.cart.CartExpected;

import java.util.ArrayList;
import java.util.List;

public class CartResponseExpected implements CartResponseCalibratable {
    private final List<CartExpected> carts = new ArrayList<>();
    @SuppressWarnings("FieldCanBeLocal")
    private final Integer statusCode = 200;

    public CartResponseExpected(CartCalibratable cart) {
        this.carts.add(CartExpected.getInstance(cart));
    }

    public static CartResponseExpected getInstance(CartCalibratable cart) {
        return new CartResponseExpected(cart);
    }

    @Override
    public Integer getStatusCode() {
        return statusCode;
    }

    @Override
    public List<CartCalibratable> getCarts() {
        return new ArrayList<>(carts);
    }
}
