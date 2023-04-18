package com.tekgs.nextgen.duckies.data.cart;

import com.tekgs.nextgen.duckies.data.cart.item.CartItemCalibratable;

import java.util.List;

public interface CartCalibratable {
    Integer getTotal();

    Boolean isEmpty();

    List<CartItemCalibratable> getItems();

    String getId();
}
