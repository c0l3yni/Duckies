package com.tekgs.nextgen.duckies.data.product.request;

import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;

import java.util.List;

public interface ProductResponseCalibratable {
    Integer getStatusCode();

    List<ProductCalibratable> getProducts();
}
