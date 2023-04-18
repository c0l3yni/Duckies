package com.tekgs.nextgen.duckies.view.products.list.productcard;

import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;

public class ProductCardExpected implements ProductCardCalibratable {
    private final ProductCalibratable product;

    public ProductCardExpected(ProductCalibratable product) {
        this.product = product;
    }

    public static ProductCardExpected getInstance(ProductCalibratable product) {
        return new ProductCardExpected(product);
    }

    @Override
    public boolean equivalent(ProductCardCalibratable comparator) {
        return false;
    }

    @Override
    public String getProductName() {
        return product.getName();
    }

    @Override
    public Boolean isAddToCart() {
        return true;
    }

    @Override
    public String getProductPrice() {
        double centsConvertedToDollars = (double) product.getPrice() / 100;
        return String.format("$%.2f", centsConvertedToDollars);
    }

    @Override
    public Boolean isAddToCartEnabled() {
        return product.getStock() > 0;
    }

    @Override
    public String getButtonMessage() {
        if(product.getStock() < 1) {
            return "Out of Stock";
        }else {
            return "Add To Cart";
        }
    }


}
