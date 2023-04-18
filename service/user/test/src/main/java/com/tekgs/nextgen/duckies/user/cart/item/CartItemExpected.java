package com.tekgs.nextgen.duckies.user.cart.item;

import com.tekgs.nextgen.duckies.data.product.Product;
import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;

public class CartItemExpected implements CartItemCalibratable {
    private final Integer quantity;
    private final ProductCalibratable product;

    private CartItemExpected(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public static CartItemExpected getInstance(Product product, int quantity) {
        return new CartItemExpected(product, quantity);
    }

    @Override
    public Integer getPrice() {
        return getProduct().getPrice();
    }

    @Override
    public boolean equivalent(CartItemCalibratable comparator) {
        return false;
    }

    @Override
    public ProductCalibratable getProduct() {
        return product;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }
}
