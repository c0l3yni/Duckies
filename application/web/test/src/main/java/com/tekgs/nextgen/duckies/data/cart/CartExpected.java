package com.tekgs.nextgen.duckies.data.cart;

import com.tekgs.nextgen.duckies.data.cart.item.CartItemCalibratable;
import com.tekgs.nextgen.duckies.data.cart.item.CartItemExpected;
import com.tekgs.nextgen.duckies.data.product.Product;

import java.util.ArrayList;
import java.util.List;

public class CartExpected implements CartCalibratable {
    private final CartCalibratable cart;
    private final List<CartItemCalibratable> items = new ArrayList<>();

    private CartExpected(Cart cart, Product product) {
        this.cart = cart;
        this.items.addAll(cart.getItems());
        if (product != null) {
            this.items.add(CartItemExpected.getInstance(product, 1));
        }
    }

    public static CartExpected getInstance(Cart cart, Product product) {
        return new CartExpected(cart, product);
    }

    public static CartExpected getInstance(Cart cart) {
        return new CartExpected(cart, null);
    }

    @Override
    public Integer getTotal() {
        Integer total = 0;
        for (CartItemCalibratable cartItem : items) {
            total += cartItem.getPrice() * cartItem.getQuantity();

        }
        return total;
    }

    @Override
    public Boolean isEmpty() {
        return items.size() == 0;
    }

    @Override
    public List<CartItemCalibratable> getItems() {
        return items;
    }

    @Override
    public String getId() {
        return cart.getId();
    }
}
