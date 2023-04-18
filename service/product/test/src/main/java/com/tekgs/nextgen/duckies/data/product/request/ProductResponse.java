package com.tekgs.nextgen.duckies.data.product.request;

import com.tekgs.nextgen.duckies.data.product.Product;
import com.tekgs.nextgen.duckies.data.product.ProductCalibratable;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

public class ProductResponse implements ProductResponseCalibratable {
    private final Integer statusCode;
    private final List<Product> products = new ArrayList<>();

    private ProductResponse(Response response) {
        this.statusCode = response.getStatus();
        if (statusCode == 200) {
            //noinspection Convert2Diamond
            List<Product> theProducts = response.readEntity(new GenericType<List<Product>>() {
            });
            this.products.addAll(theProducts);
        }
    }

    public static ProductResponse getInstance(Response response) {
        return response == null ? null : new ProductResponse(response);
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
