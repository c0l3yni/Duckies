package com.tekgs.nextgen.duckies.user.cart;

public class CartProvider {
    private final CartRepository cartRepository;

    public CartProvider() {
        cartRepository = CartRepository.getInstance();
    }

    public static CartProvider getInstance() {
        return new CartProvider();
    }

    public Cart get(CartCalibratable cart) {
        return cartRepository.query(cart);
    }

    public Cart get() {
        return get(CartDefinition.getInstance());
    }
}
