package com.tekgs.nextgen.duckies.data.cart.item;

import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;

public class CartItemDefinition implements CartItemCalibratable {
    private ProductCalibratable product;
    @SuppressWarnings("unused")
    private Integer quantity;

    public static CartItemDefinition getInstance() {
        return new CartItemDefinition();
    }

    public CartItemDefinition withProduct(ProductCalibratable product) {
        this.product = product;
        return this;
    }

    @Override
    public Integer getPrice() {
        return null;
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
