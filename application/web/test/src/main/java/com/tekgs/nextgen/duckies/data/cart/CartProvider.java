package com.tekgs.nextgen.duckies.data.cart;

import com.tekgs.nextgen.duckies.data.product.ProductProvider;

public class CartProvider {
    private final CartRepository cartRepository = CartRepository.getInstance();

    public static CartProvider getInstance() {
        return new CartProvider();
    }

    public Cart get(CartCalibratable cartDefinition) {
        Cart candidate = cartRepository.query(cartDefinition);
        return candidate;
    }

    public Cart get() {
        return get(CartDefinition.getInstance());
    }

    public Cart getMissingAtLeastOneProduct() {
        int totalProductCount = ProductProvider.getInstance().getAll().size();
        for (Cart candidate : cartRepository.query()) {
            if (candidate.getItems().size() < totalProductCount) {
                return candidate;
            }
        }
        return null;
    }
}
