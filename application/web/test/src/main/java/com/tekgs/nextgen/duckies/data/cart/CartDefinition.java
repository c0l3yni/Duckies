package com.tekgs.nextgen.duckies.data.cart;

import com.google.gson.Gson;
import com.tekgs.nextgen.duckies.data.cart.item.CartItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class CartDefinition implements CartCalibratable {
    private final List<CartItemCalibratable> items = new ArrayList<>();
    @SuppressWarnings("unused")
    private String id;
    private Integer total;
    private Boolean isEmpty;

    public static CartDefinition getInstance() {
        return new CartDefinition();
    }

    public CartDefinition withTotal(int total) {
        this.total = total;
        return this;
    }

    @SuppressWarnings("unused")
    public CartDefinition withItem(CartItemCalibratable item) {
        this.items.add(item);
        return this;
    }
    public CartDefinition withNoItem() {
        isEmpty = true;
        return this;
    }

    public CartDefinition withItems(List<CartItemCalibratable> items) {
        this.items.addAll(items);
        return this;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getClass().getSimpleName(), new Gson().toJson(this));
    }

    @Override
    public Integer getTotal() {
        return total;
    }

    @Override
    public Boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public List<CartItemCalibratable> getItems() {
        return items;
    }
}
