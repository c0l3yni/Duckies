package com.tekgs.nextgen.duckies.user.cart.item;

import com.tekgs.nextgen.duckies.data.product.Product;
import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;

public class CartItem implements CartItemCalibratable {
    Product product;
    Integer quantity;

    @SuppressWarnings("unused")
    public CartItem() {
    }

    public boolean equivalent(CartItemCalibratable comparator) {
        if (comparator == null) {
            return false;
        }
        if (comparator.getProduct().getId() != null && this.getProduct().getId().equals(comparator.getProduct().getId())) {
            return true;
        }
        boolean isEquivalent = comparator.getProduct() == null || this.getProduct().equivalent(comparator.getProduct());
        isEquivalent &= comparator.getQuantity() == null || this.getQuantity().equals(comparator.getQuantity());
        return isEquivalent;
    }

    @Override
    public Integer getPrice() {
        return product.getPrice();
    }

    @Override
    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public ProductCalibratable getProduct() {
        return product;
    }
}
