package com.tekgs.nextgen.duckies.user.cart;

import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;
import com.tekgs.nextgen.duckies.user.cart.item.CartItemCalibratable;

import java.util.List;

public interface CartCalibratable {
    List<CartItemCalibratable> getItems();

    Integer getTotal();

    String getId();

    List<ProductCalibratable> getProducts();

    boolean equivalent(CartCalibratable comparator);

    Boolean isIdSet();
}
