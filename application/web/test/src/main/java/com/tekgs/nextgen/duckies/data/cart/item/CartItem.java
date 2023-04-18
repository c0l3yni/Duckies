package com.tekgs.nextgen.duckies.data.cart.item;

import com.tekgs.nextgen.duckies.data.product.Product;

public class CartItem implements CartItemCalibratable {
    Product product;
    Integer quantity;

    private static boolean areEquivalent(Object comparatorValue, Object thisValue) {
        return comparatorValue == null || thisValue.equals(comparatorValue);
    }

    @Override
    public Integer getPrice() {
        return product.getPrice();
    }

    @Override
    public boolean equivalent(CartItemCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
        boolean isEquivalent = comparator.getProduct() == null || this.getProduct().equivalent(comparator.getProduct());
        isEquivalent &= areEquivalent(comparator.getQuantity(), this.getQuantity());
        return isEquivalent;
    }

    @Override
    public Product getProduct() {
        return product;
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }
}
