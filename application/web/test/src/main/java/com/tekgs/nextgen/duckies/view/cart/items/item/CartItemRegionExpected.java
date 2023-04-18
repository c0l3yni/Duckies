package com.tekgs.nextgen.duckies.view.cart.items.item;

import com.tekgs.nextgen.duckies.data.cart.item.CartItemCalibratable;
import com.tekgs.nextgen.duckies.view.products.list.productcard.ProductCardCalibratable;
import com.tekgs.nextgen.duckies.view.products.list.productcard.ProductCardExpected;

import java.util.Objects;

public class CartItemRegionExpected implements CartItemRegionCalibratable {
    private final CartItemCalibratable item;

    private CartItemRegionExpected(CartItemCalibratable item) {
        this.item = item;
    }

    public static CartItemRegionExpected getInstance(CartItemCalibratable item) {
        return new CartItemRegionExpected(item);
    }

    @Override
    public boolean equivalent(CartItemRegionCalibratable comparator) {
        return false;
    }

    @Override
    public Integer getQuantity() {
        return item.getQuantity();
    }

    @Override
    public ProductCardCalibratable inProduct() {
        return ProductCardExpected.getInstance(item.getProduct());
    }

    @Override
    public String getId() {
        return item.getProduct().getId();
    }

    @Override
    public Boolean isDecrementButtonDisplayed() {
        return true;
    }

    @Override
    public Boolean isIncrementButtonDisplayed() {
        return true;
    }

    @Override
    public Boolean isDecrementButtonEnabled() {
        return item.getQuantity() > 0;
    }

    @Override
    public Boolean isIncrementButtonEnabled() {

        return item.getProduct().getStock() > item.getQuantity();
    }
}
