package com.tekgs.nextgen.duckies.data.product;

public class ProductExpected implements ProductCalibratable{
    private final String id;
    private final String name;
    private final Integer price;
    private final Integer stock;

    public ProductExpected(String id, String name, Integer price, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public static ProductExpected getInstance() {
        return new ProductExpected(null, null, null, null);
    }

    public static ProductExpected getInstance(ProductCalibratable product) {
        return new ProductExpected(product.getId(), product.getName(), product.getPrice(), product.getStock());
    }

    @Override
    public boolean equivalent(ProductCalibratable comparator) {
        return false;
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Integer getStock() {
        return stock;
    }
}
