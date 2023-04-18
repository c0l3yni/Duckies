package com.tekgs.nextgen.duckies.data.cart;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;

public class CartRequest {
    private final String targetUrl;
    private final CartDefinition cart;

    private CartRequest(CartDefinition cart) {
        this.cart = cart;
        targetUrl = "http://localhost:3001/cart";
    }

    public static CartRequest getInstance(CartDefinition cart) {
        return new CartRequest(cart);
    }

    public CartResponse post() {
        System.out.printf("Send 'post' request to: %s with %s...%n", targetUrl, cart.toString());
        Entity<CartDefinition> cartPayload = Entity.entity(cart, "application/json");
        CartResponse response;
        try (Client client = ClientBuilder.newBuilder().build()) {
            response = CartResponse.getInstance(client.target(targetUrl).request().post(cartPayload));
        }
        return response;
    }
}
