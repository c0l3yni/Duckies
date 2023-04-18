package com.tekgs.nextgen.duckies.data.cart;

import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

public class CartResponse {
    private final Response.StatusType status;
    private final List<Cart> carts = new ArrayList<>();

    private CartResponse(Response response) {
        this.status = response.getStatusInfo();
        if (status.getStatusCode() == 200) {
            //noinspection Convert2Diamond
            List<Cart> theCarts = response.readEntity(new GenericType<List<Cart>>() {
            });
            this.carts.addAll(theCarts);
        }
    }

    public static CartResponse getInstance(Response response) {
        return new CartResponse(response);
    }

    public Cart getCart(CartCalibratable cartDefinition) {
        for(Cart candidate:carts){
            if(candidate.equivalent(cartDefinition)){
                return candidate;
            }
        }
        return null;
    }
}
