package com.tekgs.nextgen.duckies.user.cart.request;

import com.tekgs.nextgen.duckies.user.cart.CartCalibratable;

import java.util.List;

public interface CartResponseCalibratable {
    Integer getStatusCode();

    List<CartCalibratable> getCarts();
}
