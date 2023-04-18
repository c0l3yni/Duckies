package com.tekgs.nextgen.duckies.view.cart.items;

import com.tekgs.nextgen.duckies.data.cart.Cart;
import com.tekgs.nextgen.duckies.data.cart.item.CartItem;
import com.tekgs.nextgen.duckies.data.cart.item.CartItemCalibratable;
import com.tekgs.nextgen.duckies.view.cart.items.item.CartItemRegionCalibratable;
import com.tekgs.nextgen.duckies.view.cart.items.item.CartItemRegionExpected;

import java.util.ArrayList;
import java.util.List;

public class CartItemsRegionExpected implements CartItemsRegionCalibratable {
    private final List<CartItemCalibratable> items;

    public CartItemsRegionExpected(Cart cart) {
        this.items = new ArrayList<>(cart.getItems());
    }

    public static CartItemsRegionExpected getInstance(Cart cart) {
        return new CartItemsRegionExpected(cart);
    }

    @Override
    public List<CartItemRegionCalibratable> getItems() {
        List<CartItemRegionCalibratable> itemRegions = new ArrayList<>();
        for (CartItemCalibratable item : items) {
            itemRegions.add(CartItemRegionExpected.getInstance(item));
        }
        return itemRegions;
    }
}
