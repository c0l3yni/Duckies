package com.tekgs.nextgen.duckies.view.products;

import com.tekgs.nextgen.duckies.data.product.Product;
import com.tekgs.nextgen.duckies.view.products.list.ProductCardsExpected;

public class ProductsViewExpected implements ProductsViewCalibratable {

    public static ProductsViewExpected getInstance() {
        return new ProductsViewExpected();
    }
    @Override
    public ProductCardsExpected inProductCards() {
        return ProductCardsExpected.getInstance();
    }
}
