package com.tekgs.nextgen.duckies.data.product.request;

import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;
import com.tekgs.nextgen.duckies.data.product.ProductExpected;
import com.tekgs.nextgen.duckies.data.product.request.ProductResponseCalibratable;

import java.util.ArrayList;
import java.util.List;

public class ProductResponseExpected implements ProductResponseCalibratable {
    private final List<ProductExpected> products = new ArrayList<>();
    @SuppressWarnings("FieldCanBeLocal")
    private final Integer statusCode = 200;

    public ProductResponseExpected(ProductCalibratable product) {
        this.products.add(ProductExpected.getInstance(product));
    }

    public static ProductResponseExpected getInstance(ProductCalibratable product) {
        return new ProductResponseExpected(product);
    }

    @Override
    public Integer getStatusCode() {
        return statusCode;
    }

    @Override
    public List<ProductCalibratable> getProducts() {
        return new ArrayList<>(products);
    }
}
