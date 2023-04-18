package com.tekgs.nextgen.duckies.user.cart;

import com.google.gson.Gson;
import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;
import com.tekgs.nextgen.duckies.user.cart.item.CartItem;
import com.tekgs.nextgen.duckies.user.cart.item.CartItemCalibratable;

import java.util.ArrayList;
import java.util.List;

public class Cart implements CartCalibratable {
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final List<CartItem> items = new ArrayList<>();
    @SuppressWarnings("unused")
    private String id;
    @SuppressWarnings("FieldCanBeLocal")
    private Integer total;

    public Cart() {
    }

    public boolean equivalent(CartCalibratable comparator) {
        if (comparator == null) {
            return false;
        } else if (comparator.getId() != null && this.getId().equals(comparator.getId())) {
            return true;
        }
        boolean isEquivalent = comparator.getTotal() == null || this.getTotal().equals(comparator.getTotal());
        isEquivalent &= itemsAreEquivalent(comparator.getItems());
        return isEquivalent;
    }

    @Override
    public Boolean isIdSet() {
        return id != null;
    }

    private boolean itemsAreEquivalent(List<CartItemCalibratable> comparatorItems) {
        List<CartItemCalibratable> actualItems = new ArrayList<>(this.getItems());
        for (CartItemCalibratable comparatorItem : comparatorItems) {
            CartItemCalibratable itemFound = null;
            for (CartItemCalibratable candidate : actualItems) {
                if (candidate.equivalent(comparatorItem)) {
                    itemFound = candidate;
                    actualItems.remove(candidate);
                    break;
                }
            }
            if (itemFound == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<CartItemCalibratable> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public Integer getTotal() {
        total = 0;
        for (CartItemCalibratable item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public String getId() {
        return id;
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
    public String toString() {
        return String.format("%s: %s", this.getClass().getSimpleName(), new Gson().toJson(this));
    }

    public CartDefinition toDefinition() {
        return CartDefinition.getInstance().withItems(new ArrayList<>(items));
    }
}
