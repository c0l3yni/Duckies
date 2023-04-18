package com.tekgs.nextgen.duckies.view.products.list;

import com.tekgs.nextgen.duckies.data.product.Product;
import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;
import com.tekgs.nextgen.duckies.data.product.ProductProvider;
import com.tekgs.nextgen.duckies.view.products.list.productcard.ProductCardCalibratable;
import com.tekgs.nextgen.duckies.view.products.list.productcard.ProductCardExpected;

import java.util.ArrayList;
import java.util.List;

public class ProductCardsExpected implements ProductsListCalibratable {
    private final List<Product> products = ProductProvider.getInstance().getAll();

    public static ProductCardsExpected getInstance() {
        return new ProductCardsExpected();
    }

    @Override
    public List<ProductCardCalibratable> inProductCards() {
        List<ProductCardCalibratable> productRegions = new ArrayList<>();
        for (ProductCalibratable product : products) {
            productRegions.add(ProductCardExpected.getInstance(product));
        }
        return productRegions;
    }
}
