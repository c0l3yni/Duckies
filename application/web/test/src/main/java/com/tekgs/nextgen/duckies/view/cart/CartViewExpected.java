package com.tekgs.nextgen.duckies.view.cart;

import com.tekgs.nextgen.duckies.data.cart.Cart;
import com.tekgs.nextgen.duckies.view.cart.items.CartItemsRegionExpected;

public class CartViewExpected implements CartViewCalibratable {
    private final Cart cart;

    private CartViewExpected(Cart cart) {
        this.cart = cart;
    }

    public static CartViewExpected getInstance(Cart cart) {
        return new CartViewExpected(cart);
    }

    @Override
    public String getTotal() {
        double centsConvertedToDollars = (double) cart.getTotal() / 100;
        return String.format("$%.2f", centsConvertedToDollars);
    }

    @Override
    public Boolean isEmptyMessageDisplayed() {
        return cart.isEmpty();
    }

    @Override
    public CartItemsRegionExpected inCartItems() {
        return CartItemsRegionExpected.getInstance(cart);
    }

    @Override
    public Boolean isCheckoutButtonDisplayed() {
        return true;
    }

    @Override
    public Boolean isCheckoutButtonEnabled() {
        return !cart.isEmpty();
    }
}
