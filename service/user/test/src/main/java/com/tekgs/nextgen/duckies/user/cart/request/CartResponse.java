package com.tekgs.nextgen.duckies.user.cart.request;

import com.tekgs.nextgen.duckies.user.cart.Cart;
import com.tekgs.nextgen.duckies.user.cart.CartCalibratable;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

public class CartResponse implements CartResponseCalibratable {
    private final Integer statusCode;
    private final List<Cart> carts = new ArrayList<>();

    private CartResponse(Response response) {
        this.statusCode = response.getStatus();
        if (statusCode == 200) {
            //noinspection Convert2Diamond
            List<Cart> theCarts = response.readEntity(new GenericType<List<Cart>>() {
            });
            this.carts.addAll(theCarts);
        }
    }

    public static CartResponse getInstance(Response response) {
        return response == null ? null : new CartResponse(response);
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
