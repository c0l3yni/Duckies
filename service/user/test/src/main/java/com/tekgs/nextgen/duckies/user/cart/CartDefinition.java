package com.tekgs.nextgen.duckies.user.cart;

import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;
import com.tekgs.nextgen.duckies.user.cart.item.CartItemCalibratable;
import com.tekgs.nextgen.duckies.user.cart.item.CartItemDefinition;

import java.util.ArrayList;
import java.util.List;

public class CartDefinition implements CartCalibratable {
    private final List<CartItemDefinition> items = new ArrayList<>();
    @SuppressWarnings("FieldCanBeLocal")
    private String id;
    @SuppressWarnings("unused")
    private Integer total;

    public CartDefinition(CartCalibratable cart) {
        if (cart != null) {
            total = cart.getTotal();
            id = cart.getId();
            List<CartItemDefinition> cartItems = new ArrayList<>();
            for (CartItemCalibratable item : cart.getItems()) {
                cartItems.add(CartItemDefinition.getInstance(item));
            }
            items.addAll(cartItems);
        }
    }

    public static CartDefinition getInstance() {
        return new CartDefinition(null);
    }

    public static CartDefinition getInstance(CartCalibratable cart) {
        return new CartDefinition(cart);
    }

    @Override
    public List<CartItemCalibratable> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public Integer getTotal() {
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
    public boolean equivalent(CartCalibratable comparator) {
        return false;
    }

    @Override
    public Boolean isIdSet() {
        return id != null;
    }

    public CartDefinition withItem(CartItemCalibratable cartItemDefinition) {
        items.add(CartItemDefinition.getInstance(cartItemDefinition));
        return this;
    }

    public CartDefinition withItems(List<CartItemCalibratable> items) {
        List<CartItemDefinition> itemDefinitions = new ArrayList<>();
        for (CartItemCalibratable item : items) {
            itemDefinitions.add(CartItemDefinition.getInstance(item));
        }
        this.items.addAll(itemDefinitions);
        return this;
    }
}
