package com.tekgs.nextgen.duckies.view.products.list.productcard;

public interface ProductCardCalibratable {
    boolean equivalent(ProductCardCalibratable comparator);

    String getProductName();

    Boolean isAddToCart();

    String getProductPrice();

    Boolean isAddToCartEnabled();

    String getButtonMessage();
}
