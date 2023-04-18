package com.tekgs.nextgen.duckies.user.cart;

import com.tekgs.nextgen.duckies.data.product.Product;
import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;
import com.tekgs.nextgen.duckies.user.cart.item.CartItemCalibratable;
import com.tekgs.nextgen.duckies.user.cart.item.CartItemExpected;

import java.util.ArrayList;
import java.util.List;

public class CartExpected implements CartCalibratable {
    private final CartCalibratable cart;
    private final List<CartItemCalibratable> items = new ArrayList<>();

    private CartExpected(CartCalibratable cart, Product product) {
        this.cart = cart;
        this.items.addAll(cart.getItems());
        if (product != null) {
            this.items.add(CartItemExpected.getInstance(product, 1));
        }
    }

    public static CartExpected getInstance(CartCalibratable cart) {
        return new CartExpected(cart, null);
    }

    public static CartExpected getInstance(CartCalibratable cart, Product product) {
        return new CartExpected(cart, product);
    }

    @Override
    public List<CartItemCalibratable> getItems() {
        return items;
    }

    @Override
    public Integer getTotal() {
        Integer total = 0;
        for (CartItemCalibratable item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public String getId() {
        return cart.getId();
    }

    @Override
    public List<ProductCalibratable> getProducts() {
        List<ProductCalibratable> products = new ArrayList<>();
        for (CartItemCalibratable item : items) {
            products.add(item.getProduct());
        }
        return products;
    }

    @Override
    public boolean equivalent(CartCalibratable comparator) {
        return false;
    }

    @Override
    public Boolean isIdSet() {
        return true;
    }
}
