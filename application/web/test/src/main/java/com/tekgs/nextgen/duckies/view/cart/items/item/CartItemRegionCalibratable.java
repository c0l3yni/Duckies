package com.tekgs.nextgen.duckies.view.cart.items.item;

import com.tekgs.nextgen.duckies.view.products.list.productcard.ProductCardCalibratable;

public interface CartItemRegionCalibratable {
    boolean equivalent(CartItemRegionCalibratable comparator);

    Integer getQuantity();

    ProductCardCalibratable inProduct();

    String getId();
    Boolean isDecrementButtonDisplayed();
    Boolean isIncrementButtonDisplayed();

    Boolean isDecrementButtonEnabled();

    Boolean isIncrementButtonEnabled();
}
