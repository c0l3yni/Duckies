package com.tekgs.nextgen.duckies.data.product;

@SuppressWarnings("unused")
public class ProductDefinition implements ProductCalibratable {
    private String name;
    private String id;
    private Integer price;
    private Integer stock;

    public ProductDefinition(ProductCalibratable product) {
        if (product != null) {
            this.name = product.getName();
            this.id = product.getId();
            this.price = product.getPrice();
            this.stock = product.getStock();
        }
    }

    public static ProductDefinition getInstance() {
        return new ProductDefinition(null);
    }

    public static ProductCalibratable getInstance(ProductCalibratable product) {
        return new ProductDefinition(product);
    }

    @Override
    public boolean equivalent(ProductCalibratable comparator) {
        return false;
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

    @Override
    public Integer getPrice() {
        return price;
    }

    public ProductDefinition withName(String name) {
        this.name = name;
        return this;
    }
}
