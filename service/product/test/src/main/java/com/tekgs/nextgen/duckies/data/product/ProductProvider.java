package com.tekgs.nextgen.duckies.data.product;

import java.util.List;

public class ProductProvider {
    private final ProductRepository repository = ProductRepository.getInstance();

    public static ProductProvider getInstance() {
        return new ProductProvider();
    }

    public Product getNotIn(List<ProductCalibratable> products) {
        for (Product candidate : repository.queryAll()) {
            for (ProductCalibratable product : products) {
                if (product.equivalent(candidate)) {
                    continue;
                }
                return candidate;
            }
        }
        return null;
    }

    public Product get() {
        for (Product candidate : repository.queryAll()) {
            return candidate;
        }
        return null;
    }
}
