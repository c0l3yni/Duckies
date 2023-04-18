package com.tekgs.nextgen.duckies.view.cart;

import com.tekgs.nextgen.duckies.view.cart.items.CartItemsRegionCalibratable;

public interface CartViewCalibratable {
    String getTotal();

    Boolean isEmptyMessageDisplayed();

    CartItemsRegionCalibratable inCartItems();

    Boolean isCheckoutButtonDisplayed();
    Boolean isCheckoutButtonEnabled();
}
