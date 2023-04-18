package com.tekgs.nextgen.duckies.user.cart.item;

import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;
import com.tekgs.nextgen.duckies.data.product.ProductDefinition;

public class CartItemDefinition implements CartItemCalibratable {
    private ProductCalibratable product;

    public CartItemDefinition(CartItemCalibratable cartItem) {
        this.product = cartItem == null ? null : ProductDefinition.getInstance(cartItem.getProduct());
    }

    public static CartItemDefinition getInstance() {
        return new CartItemDefinition(null);
    }

    public static CartItemDefinition getInstance(CartItemCalibratable cartItem) {
        return new CartItemDefinition(cartItem);
    }

    @Override
    public Integer getQuantity() {
        return null;
    }

    @Override
    public ProductCalibratable getProduct() {
        return product;
    }

    @Override
    public boolean equivalent(CartItemCalibratable comparatorItem) {
        return false;
    }

    @Override
    public Integer getPrice() {
        return product.getPrice();
    }

    public CartItemDefinition withProduct(ProductCalibratable product) {
        this.product = product;
        return this;
    }
}
