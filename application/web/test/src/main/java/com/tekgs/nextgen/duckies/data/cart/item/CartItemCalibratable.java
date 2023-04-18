package com.tekgs.nextgen.duckies.data.cart.item;

import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;

public interface CartItemCalibratable {
    Integer getPrice();

    boolean equivalent(CartItemCalibratable comparator);

    ProductCalibratable getProduct();

    Integer getQuantity();
}
