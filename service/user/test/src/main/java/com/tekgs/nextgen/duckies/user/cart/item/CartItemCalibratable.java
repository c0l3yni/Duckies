package com.tekgs.nextgen.duckies.user.cart.item;

import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;

public interface CartItemCalibratable {
    Integer getQuantity();

    ProductCalibratable getProduct();

    boolean equivalent(CartItemCalibratable comparatorItem);

    Integer getPrice();
}
