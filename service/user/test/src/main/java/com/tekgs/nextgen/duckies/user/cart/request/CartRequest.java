package com.tekgs.nextgen.duckies.user.cart.request;

import com.tekgs.nextgen.duckies.data.product.Product;
import com.tekgs.nextgen.duckies.user.cart.Cart;
import com.tekgs.nextgen.duckies.user.cart.CartCalibratable;
import com.tekgs.nextgen.duckies.user.cart.CartDefinition;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;

public class CartRequest {
    private static final String CART_URL = "http://localhost:3001/cart";
    private final Product product;
    private final CartDefinition cart;

    private CartRequest(CartCalibratable cart, Product newProduct) {
        this.product = newProduct;
        this.cart = CartDefinition.getInstance(cart);
    }

    public static CartRequest getInstance(CartCalibratable cart) {
        return new CartRequest(cart, null);
    }

    public static CartRequest getInstance(Cart cart, Product product) {
        return new CartRequest(cart, product);
    }

    public static CartRequest getInstance() {
        return new CartRequest(null, null);
    }

    public CartResponse get() {
        String targetUrl = String.format("%s/%s", CART_URL, cart.getId());
        System.out.printf("Send 'get' request to: %s...%n", targetUrl);
        CartResponse response;
        try (Client client = ClientBuilder.newBuilder().build()) {
            response = CartResponse.getInstance(client.target(targetUrl).request().get());
        }
        return response;
    }

    public CartResponse put() {
        String targetUrl = String.format("%s/%s", CART_URL, cart.getId());
        System.out.printf("Send 'put' request to: %s with %s...%n", targetUrl, product.toString());
        Entity<Product> productPayload = Entity.entity(product, "application/json");
        CartResponse response;
        try (Client client = ClientBuilder.newBuilder().build()) {
            response = CartResponse.getInstance(client.target(targetUrl).request().put(productPayload));
        }
        return response;
    }

    public CartResponse post() {
        CartDefinition cartDefinition = cart;
        System.out.printf("Send 'post' request to: %s with %s...%n", CART_URL, cartDefinition.getId());
        Entity<CartDefinition> cartPayload = Entity.entity(cartDefinition, "application/json");
        CartResponse response;
        try (Client client = ClientBuilder.newBuilder().build()) {
            response = CartResponse.getInstance(client.target(CART_URL).request().post(cartPayload));
        }
        return response;
    }
}
