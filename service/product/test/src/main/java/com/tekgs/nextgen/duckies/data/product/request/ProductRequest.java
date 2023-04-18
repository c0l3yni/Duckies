package com.tekgs.nextgen.duckies.data.product.request;

import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;

public class ProductRequest {
    private static final String PRODUCT_URL = "http://localhost:3002/product";
    private final ProductCalibratable product;

    private ProductRequest(ProductCalibratable product) {
        this.product = product;
    }

    public static ProductRequest getInstance(ProductCalibratable product) {
        return new ProductRequest(product);
    }

    public ProductResponse get() {
        String targetUrl = String.format("%s/%s", PRODUCT_URL, product.getId());
        System.out.printf("Send 'get' request to: %s...%n", targetUrl);
        ProductResponse response;
        try (Client client = ClientBuilder.newBuilder().build()) {
            response = ProductResponse.getInstance(client.target(targetUrl).request().get());
        }
        return response;
    }

//    public ProductResponse put() {
//        String targetUrl = String.format("%s/%s", PRODUCT_URL, cart.getId());
//        System.out.printf("Send 'put' request to: %s with %s...%n", targetUrl, product.toString());
//        Entity<Product> productPayload = Entity.entity(product, "application/json");
//        ProductResponse response;
//        try (Client client = ClientBuilder.newBuilder().build()) {
//            response = ProductResponse.getInstance(client.target(targetUrl).request().put(productPayload));
//        }
//        return response;
//    }
//
//    public ProductResponse post() {
//        Cart cartDefinition = Cart.getInstance(cart);
//        System.out.printf("Send 'post' request to: %s with %s...%n", PRODUCT_URL, cartDefinition.getId());
//        Entity<Cart> cartPayload = Entity.entity(cartDefinition, "application/json");
//        ProductResponse response;
//        try (Client client = ClientBuilder.newBuilder().build()) {
//            response = ProductResponse.getInstance(client.target(PRODUCT_URL).request().post(cartPayload));
//        }
//        return response;
//    }
}
